package es.ucm.fdi.iw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Admin;
import es.ucm.fdi.iw.model.Court;
import es.ucm.fdi.iw.model.Reservation;

@Controller	
@RequestMapping("admin")
public class AdminController {	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EntityManager entityManager;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "../static");
    }
    
    /**
     * Mapper para visualizar formulario de creación de administrador.
     * @param session
     * @return
     */
    @GetMapping("/crear-admin")
	public String crearAdmin(HttpSession session) {
    	if (session.getAttribute("role") == "admin") {
    		return "crear-admin";
    	}else {
			return "redirect:/error";
		}
	}
    
    /**
     * Mapper para visualizar la vista de asignación de equipo a un jugador.
     * @param session
     * @return
     */
    @GetMapping("/asignar-equipo")
	public String asignarEquipo(HttpSession session) {
    	if (session.getAttribute("role") == "admin") {
    		return "asignar-equipo";
    	}else {
			return "redirect:/error";
		}
	}
    
    /**
     * Elimina a un administrador.
     * @param Nombre
     * @param m
     * @param session
     * @return
     */
    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.POST)
	@Transactional
	public String deleteAdmin(@RequestParam String Nombre,Model m, HttpSession session) {
		
    	
		Admin a = entityManager.find(Admin.class, Nombre);
		entityManager.remove(a);
		
		return "redirect:/admin/listado-admins";
	}
    
    /**
     * Crea un nuevo administrador con la información proporcionada por el administrador de la sesión.
     * @param Nombre
     * @param Email
     * @param Direccion
     * @param Telefono
     * @param Dni
     * @param Workplace
     * @param Job
     * @param Password
     * @param m
     * @param session
     * @return
     */
    @RequestMapping(value = "/newAdmin", method = RequestMethod.POST)
	@Transactional
	public String newCourt(
			@RequestParam String Nombre, 
			@RequestParam String Email,
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String Dni,
			@RequestParam String Workplace,
			@RequestParam String Job,@RequestParam String Password, Model m, HttpSession session) {
		
		
		Boolean errores = false;
		
		if (Nombre == "") {
			m.addAttribute("errorNombre", "Debe insertar un nombre");
			errores = true;
		}
		if (Direccion == "") {
			m.addAttribute("errorDireccion", "Debe insertar una dirección");
			errores = true;
		}
		if (Telefono == "") {
			m.addAttribute("errorTelefono", "Debe insertar un teléfono");
			errores = true;
		}
		if (Email == "") {
			m.addAttribute("errorEmail", "Debe insertar un email");
			errores = true;
		}
		if (Dni == "") {
			m.addAttribute("errorDni", "Debe insertar un dni");
			errores = true;
		}
		if (Workplace == "") {
			m.addAttribute("errorWorkplace", "Debe insertar un lugar de trabajo");
			errores = true;
		}
		if (Job == "") {
			m.addAttribute("errorJob", "Debe insertar un puesto de trabajo");
			errores = true;
		}
		if (errores) {
			return "crear-admin";
		}
		
		
		
		Admin a = new Admin();
		a.setLogin(Email);
		a.setPassword(passwordEncoder.encode(Password));
		a.setDir(Direccion);
		a.setName(Nombre);
		a.setPhone(Telefono);
		a.setDni(Dni);
		a.setWorkplace(Workplace);
		a.setJob(Job);
		a.setRoles("ADMIN,USER");
		
		
		entityManager.persist(a);
		
		session.setAttribute("admin", a.getLogin());
		
		
		return "redirect:/admin/listado-admins";
	}
	
    /**
     * Mapper para visualizar todos los administradores existentes.
     * @param m
     * @param session
     * @return
     */
	@SuppressWarnings("unchecked")
	@GetMapping("/listado-admins")
	public String admins(Model m, HttpSession session) {
		
		if (session.getAttribute("role") == "admin") {
			List<Admin> admin = entityManager.createNamedQuery("allAdmins").getResultList();
			
			m.addAttribute("listAdmins", admin);
			return "listado-admins";
		}
		else {
			return "redirect:/error";
		}
	}	
	
	/**
	 * Mapper para visualizar las reservas de una determinada pista.
	 * @param m
	 * @param id
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/ver-reservas/{id}", method = RequestMethod.GET)
	public String reservas(Model m, @PathVariable("id") long id, HttpSession session) {
		if (session.getAttribute("role") == "admin") {
			Court c = entityManager.find(Court.class, id);
			List<Reservation> l = entityManager.createNamedQuery("reservationsCourt").setParameter("c", c).getResultList();
			List<ReservationTransfer> list = new ArrayList<ReservationTransfer>();
			for(Reservation r: l) {
				ReservationTransfer t = new ReservationTransfer();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = sdf.format(r.getDate());
				
				t.setDate(date);
				t.setId(r.getId());
				t.setNameCourt(r.getCourt().getName());
				t.setIdCourt(r.getCourt().getId());
				t.setUser(r.getUser().getLogin());
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
			m.addAttribute("s", "../../static");
			
			return "ver-reservas";
		} else {
			return "redirect:/error";
		}
	}
	
}
