package es.ucm.fdi.iw.controller;







import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import es.ucm.fdi.iw.model.User;


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
    @RequestMapping(value = "/nuevaReserva", method = RequestMethod.POST)
	@Transactional
	public String creaReserva(
			@RequestParam String datepicker,
			@RequestParam ("franja-horaria") String[] checkboxValue,
			HttpSession session) {
    	int j = 0;
    	for(int i = 9; i < 21; i++) {
    		String aux = Integer.toString(i);
    		if(checkboxValue[j].equals(aux)) {
    			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    			
    			String d = datepicker + " " + checkboxValue[j] + ":00";
    			
    			try {
					Date date = sdf.parse(d);
					
					Reservation r = new Reservation();
					//año-mes-dia-horas-minutos-segundos
					
					r.setDate(date);
					//r.setIdUser((String) session.getAttribute("user"));
							
					entityManager.persist(r);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			j++;
    		}
    		
    	}
    			
		
		
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
