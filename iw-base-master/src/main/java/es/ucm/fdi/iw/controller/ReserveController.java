package es.ucm.fdi.iw.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Court;
import es.ucm.fdi.iw.model.ReservaHoras;
import es.ucm.fdi.iw.model.Reservation;
import es.ucm.fdi.iw.model.User;


@Controller	
@RequestMapping("reserve")
public class ReserveController {
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
			@RequestParam String idCourt,
			@RequestParam String datepicker,
			@RequestParam ("franja-horaria") String[] checkboxValue,
			HttpSession session) {
    	int j = 0;
    	Reservation r = new Reservation();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	String d = datepicker;
    	Date date;
		try {
			date = sdf.parse(d);
			r.setDate(date);
			User u = entityManager.find(User.class, session.getAttribute("user"));
			
			r.setUser(u);
			
			Court c = entityManager.find(Court.class, Long.parseLong(idCourt));
			
			r.setCourt(c);
			
			long idr = r.getId();
					
			entityManager.persist(r);
			
			for(int i = 9; i < 21; i++) {
	    		String aux = Integer.toString(i);
	    		if(checkboxValue[j].equals(aux)) {
	    			//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    			//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    			
	    			
	    			//String d = datepicker + " " + checkboxValue[j] + ":00";
	    			
	    			//String d = datepicker;
	    			String h = checkboxValue[j] + ":00";
	    			
	    			
						//Date date = sdf.parse(d);
						
						
						
						ReservaHoras rs = new ReservaHoras();
						
						
						rs.setIdReserva(idr); 
						
						rs.setHora(h);
						
						entityManager.persist(rs);
						
					
	    			j++;
	    		}
	    		
	    	}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
		
		
    	
    	
    			
		
		
		return "home";
	}
    @GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
    @RequestMapping(value ="/reserva/{id}", method = RequestMethod.GET)
	public String reserva(@PathVariable("id") String id, Model m) {
    	m.addAttribute("idCourt", id);
    	m.addAttribute("s", "../../static");
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
