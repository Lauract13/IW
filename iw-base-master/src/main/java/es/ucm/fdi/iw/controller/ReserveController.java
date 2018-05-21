package es.ucm.fdi.iw.controller;







import java.util.Date;

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


import es.ucm.fdi.iw.model.Reservation;


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
    // id usuario, fecha->date, id pista
    @RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional
	public String creaReserva(
			@RequestParam String Email) {
	
		Reservation r = new Reservation();
		//año-mes-dia-horas-minutos-segundos
		Date date = new Date();
		r.setDate(date);
		
		r.setIdUser(Email);
		

				
		entityManager.persist(r);
		
		
		
		
		return "home";
	}
    @GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
    @GetMapping("/reserva")
	public String reserva() {
		return "reserva";
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@Transactional
	public String deleteReservation(
			@RequestParam long idReserva,
			HttpSession session) {
		
		Reservation r = entityManager.find(Reservation.class,idReserva);
		
		entityManager.remove(r);
		
		return "home";
	}

}
