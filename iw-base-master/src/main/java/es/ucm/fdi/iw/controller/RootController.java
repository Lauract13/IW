package es.ucm.fdi.iw.controller;

import java.security.Principal;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login-admin")
	public String loginAdmin() {
		return "login-admin";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@GetMapping("/logout")
	public String logout(
			
			HttpSession session) {
			
		
		session.invalidate();
		
		
		return "redirect:login";
		
		
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
		u.setPassword(Password);
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
		
		session.setAttribute("user", u.getLogin());
		
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Transactional
	public String login(@RequestParam String Email,
						@RequestParam String Password, Model m, HttpSession session) {
		
		Boolean errores = false;
		if (Email == "") {
			m.addAttribute("errorEmail", "Debe insertar un email");
			errores = true;
		}
		if (Password == "") {
			m.addAttribute("errorPassword", "Debe insertar una contraseña");
			errores = true;
		}
		if (errores) {
			return "login";
		}
		try {
			User u = entityManager.find(User.class, Email);
			session.setAttribute("user", u.getLogin());	
			
			if(u.getPassword().equals(Password)) {
				return "home";
			}else {
				m.addAttribute("error", "El usuario introducido no es correcto");
				return "login";
			}
		} catch (Exception e) {
			m.addAttribute("error", "El usuario introducido no es correcto");
			return "login";
		}
			
	}
	
	@RequestMapping(value = "/login-admin", method = RequestMethod.POST)
	@Transactional
	public String loginAdmin(@RequestParam String Email,
						@RequestParam String Password, Model m, HttpSession session) {
		User u = entityManager.find(User.class, Email);
	
		session.setAttribute("user", u.getLogin());	
		
		if(u.getPassword().equals(Password) && u.getRoles().contains("ADMIN")) {
			return "redirect:/court/pistas";
		}else {
			return "login-admin";
		}
			
	}
}
