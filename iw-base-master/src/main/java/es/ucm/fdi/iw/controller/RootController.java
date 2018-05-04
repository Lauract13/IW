package es.ucm.fdi.iw.controller;

import java.security.Principal;

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

import es.ucm.fdi.iw.model.Normal;
import es.ucm.fdi.iw.model.User;

@Controller	
public class RootController {

	private static Logger log = Logger.getLogger(RootController.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EntityManager entityManager;
	
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "/static");
    }

	@GetMapping({"/", "/index"})
	public String root(Model model, Principal principal) {
		//log.info(principal.getName() + " de tipo " + principal.getClass());		
		// org.springframework.security.core.userdetails.User
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	@Transactional
	public String addUser(
			@RequestParam String Nombre, 
			@RequestParam String Email,
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String Password,
			@RequestParam ("UCM") String checkboxValue,			
			@RequestParam(required=false) String isAdmin, Model m, HttpSession session) {
	
		User u = new Normal();
		u.setLogin(Email);
		u.setPassword(passwordEncoder.encode(Password));
		u.setDir(Direccion);
		u.setName(Nombre);
		u.setPhone(Telefono);
		
		if(checkboxValue.equals("option1")) {
			u.setUCM(true);
		}else {
			u.setUCM(false);
		}
		
		u.setRoles("on".equals(isAdmin) ? "ADMIN,USER" : "USER");
				
		entityManager.persist(u);
		
		session.setAttribute("user", u);
		
		return "home";
	}
}
