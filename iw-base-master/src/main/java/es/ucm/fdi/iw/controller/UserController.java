package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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

import es.ucm.fdi.iw.LocalData;
import es.ucm.fdi.iw.model.Normal;
import es.ucm.fdi.iw.model.User;

@Controller	
@RequestMapping("user")
public class UserController {
private static Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private LocalData localData;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EntityManager entityManager;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "../static");
    }
    
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
    
	@GetMapping({"", "/"})
	public String root(Model m) {
		m.addAttribute("users", entityManager
				.createQuery("select u from User u").getResultList());
		
		return "login";	
	}
	
	@RequestMapping(value = "/uploadUser", method = RequestMethod.POST)
	@Transactional
	public String uploadUser(
			@RequestParam String Nombre, 
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String Password, Model m, HttpSession session) {
		
		
		User u = entityManager.find(User.class, session.getAttribute("user") );
		
		u.setName(Nombre);
		u.setDir(Direccion);
		u.setPhone(Telefono);
		u.setPassword(Password);
		
		return "profile";
	}
	
}
