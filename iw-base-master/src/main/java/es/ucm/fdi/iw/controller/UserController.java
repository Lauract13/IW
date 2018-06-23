package es.ucm.fdi.iw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Player;
import es.ucm.fdi.iw.model.Reservation;
import es.ucm.fdi.iw.model.User;

@Controller	
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EntityManager entityManager;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "../static");
    }
    
    @GetMapping("/profile")
    public String profile(Model m, HttpSession session) {
    	if (session.getAttribute("user") != null) {
    		User u = entityManager.find(User.class, session.getAttribute("user"));
        	m.addAttribute("user", u);
        	return "profile";
        	
    	} else {
    		return "redirect:/login";
    	}
    	
    }
	
	@GetMapping("/editar-perfil")
	public String editar(Model m, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User u = entityManager.find(User.class, session.getAttribute("user"));
		  	
	    	m.addAttribute("user", u);
			return "editar-perfil";
		} else {
			return "redirect:/login";
		}
	}
    
	@SuppressWarnings("unchecked")
	@GetMapping("/tus-reservas")
	public String tusReservas(Model m, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User u = entityManager.find(User.class, session.getAttribute("user"));
			List<Reservation> l = entityManager.createNamedQuery("findUserBooking").setParameter("n", u).getResultList();
			List<ReservationTransfer> list = new ArrayList<ReservationTransfer>();
			for(Reservation r: l) {
				ReservationTransfer t = new ReservationTransfer();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = sdf.format(r.getDate());
				
				t.setDate(date);
				t.setId(r.getId());
				t.setNameCourt(r.getCourt().getName());
				t.setIdCourt(r.getCourt().getId());
				
				List<String> horas = r.getHoras();
				List<HourTransfer> tHoras = new ArrayList<HourTransfer>();
				for(int i = 0; i < horas.size(); i++) {
					HourTransfer th = new HourTransfer();
					String[] h = horas.get(i).split(":");
					
					int n = Integer.parseInt(h[0]);
					
					String cad = n + ":00 - " + (n+1) + ":00";
					th.setCad(cad);
					tHoras.add(th);
				}
				
				t.setHoras(tHoras);
				t.setWeekend(r.isIsWeekend());
				list.add(t);
			}
			
			m.addAttribute("list", list);	
			
			return "tus-reservas";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/uploadUser", method = RequestMethod.POST)
	@Transactional
	public String uploadUser(
			@RequestParam String Nombre, 
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String OldPassword, 
			@RequestParam String Password, Model m, HttpSession session) {
		
		Boolean errores = false;
		if (Direccion == "") {
			m.addAttribute("errorDireccion", "Debe insertar una direccion");
			errores = true;
		}
		if (Telefono == "") {
			m.addAttribute("errorTelefono", "Debe insertar un telefono");
			errores = true;
		}
		if (Nombre == "") {
			m.addAttribute("errorNombre", "Debe insertar un nombre");
			errores = true;
		}
		if (Password == "") {
			m.addAttribute("errorPassword", "Debe insertar una contraseña");
			errores = true;
		}
		if (OldPassword == "") {
			m.addAttribute("errorOldPassword", "Debe insertar la contraseña antigua");
			errores = true;
		}
		if (errores) {
			return "register";
		}
		
		
		User u = entityManager.find(User.class, session.getAttribute("user") );
		if(passwordEncoder.matches(OldPassword, u.getPassword())) {
			u.setName(Nombre);
			u.setDir(Direccion);
			u.setPhone(Telefono);
			u.setPassword(passwordEncoder.encode(Password));
			m.addAttribute("user", u);
			return "profile";
		}else {
			return "editar-perfil";
		}		
	}
	
	@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
	@Transactional
	public String addTeam(@RequestParam String Email, 
						  @RequestParam String Equipo,
						  Model m, HttpSession session) {
		
		Boolean errores = false;
		if (Email == "") {
			m.addAttribute("errorEmail", "Debe insertar una direccion");
			errores = true;
		}
		if (Equipo == "") {
			m.addAttribute("errorEquipo", "Debe insertar un telefono");
			errores = true;
		}
		
		if(session.getAttribute("user") != null) {
			User u = entityManager.find(User.class, Email);
			Player player = (Player) u;
			
			if(player != null && u.isPlayer() && player.getTeam() == null) {
				Query q = entityManager.createNamedQuery("findPlayerTeam").setParameter("t", Equipo);
				
				if(q.getResultList().size() == 0) {
					
					player.setTeam(Equipo);
				}else {
					m.addAttribute("error", "Este equipo ya tiene capitán");
					errores = true;
				}
			}else {
				if(player == null)
					m.addAttribute("error", "El usuario no está registrado");
				if(!u.isPlayer())
					m.addAttribute("error", "El usuario no es un jugador");
				if(player.getTeam() != null)
					m.addAttribute("error", "El usuario ya tiene equipo");
				errores = true;
			}
			
			if (errores) {
				return "asignar-equipo";
			}
			
		}else {
			return "redirect:/error";
		}
		
		return "redirect:/court/pistas";
	}
	
}

