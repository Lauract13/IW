package es.ucm.fdi.iw.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Court;
import es.ucm.fdi.iw.model.Reservation;
import es.ucm.fdi.iw.model.User;

@Controller	
@RequestMapping("user")
public class UserController {
private static Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private EntityManager entityManager;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "../static");
    }
    
    @GetMapping("/profile")
    public String profile(Model m, HttpSession session) {
    	User u = entityManager.find(User.class, session.getAttribute("user"));
    	
    	m.addAttribute("user", u);
    	
    	return "profile";
    }
	
	
	@GetMapping("/upload")
	public String upload(Model m, HttpSession session) {
		User u = entityManager.find(User.class, session.getAttribute("user"));
  	
    	m.addAttribute("user", u);
    	
		return "upload";
	}
	
	@GetMapping("/editar")
	public String editar() {
		return "editar-perfil";
	}
    
	@GetMapping("/tus-reservas")
	public String tusReservas(Model m) {
		List<Reservation> l = entityManager.createNamedQuery("findUserBooking").getResultList();
		//Hay que hacer que todas las reervas de un mismo día se vean en un solo pack
		for(Reservation r: l) {
			
		}
		
		return "tus-reservas";
	}
	
	@RequestMapping(value = "/uploadUser", method = RequestMethod.POST)
	@Transactional
	public String uploadUser(
			@RequestParam String Nombre, 
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String OldPassword, 
			@RequestParam String Password, Model m, HttpSession session) {
		
		
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

