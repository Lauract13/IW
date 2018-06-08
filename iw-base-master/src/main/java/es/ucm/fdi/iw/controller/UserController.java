package es.ucm.fdi.iw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Reservation;
import es.ucm.fdi.iw.model.User;

@Controller	
@RequestMapping("user")
public class UserController {
	
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
			
			List<TReservation> list = new ArrayList<TReservation>();
			for(Reservation r: l) {
				TReservation t = new TReservation();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = sdf.format(r.getDate());
				
				t.setDate(date);
				t.setId(r.getId());
				t.setNameCourt(r.getCourt().getName());
				
				List<String> horas = r.getHoras();
				List<THour> tHoras = new ArrayList<THour>();
				for(int i = 0; i < horas.size(); i++) {
					THour th = new THour();
					String[] h = horas.get(i).split(":");
					
					int n = Integer.parseInt(h[0]);
					
					String cad = n + ":00 - " + (n+1) + ":00";
					th.setCad(cad);
					tHoras.add(th);
				}
				
				t.setHoras(tHoras);
				
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
		if(u.getPassword().equals(OldPassword)) {
			u.setName(Nombre);
			u.setDir(Direccion);
			u.setPhone(Telefono);
			u.setPassword(Password);
			m.addAttribute("user", u);
			return "profile";
		}else {
			return "editar-perfil";
		}		
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	@Transactional
	public String deleteUser(Model m, HttpSession session) {
		
		
		User u = entityManager.find(User.class, session.getAttribute("user") );
		entityManager.remove(u);
		
		return "profile";
	}
	
	
}

