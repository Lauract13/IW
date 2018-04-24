package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
@RequestMapping("reserve")
public class ReserveController {
	
	private static Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private EntityManager entityManager;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "../static");
    }
    
    @GetMapping("/create")
	public String create() {
		return "create";
	}
    
    @GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}

}
