package es.ucm.fdi.iw.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
			@RequestParam String[] datepicker,
			@RequestParam ("franja-horaria") String[] checkboxValue,
			@RequestParam String[] countH,
			HttpSession session) {
    	
    	int j = 0;
    	User u = entityManager.find(User.class, session.getAttribute("user"));
    	Court c = entityManager.find(Court.class, Long.parseLong(idCourt));
    	
    	for(int k = 0; k < datepicker.length; k++) {
        	Reservation r = new Reservation();
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        	String d = datepicker[k];
        	Date date = new Date();
    		try {
  
         			
    			date = sdf.parse(d);
    			
    			DateFormat format2=new SimpleDateFormat("EEEE"); 
            	String finalDay=format2.format(date);
            	
    			if(finalDay.equals("domingo") || finalDay.equals("sÃ¡bado") || finalDay.equals("saturday") || finalDay.equals("sunday")) {
    				r.setWeekend(true);
    			}else {
    				r.setWeekend(false);
    			}
    			
    			r.setDate(date);
    			r.setUser(u);		
    			r.setCourt(c);			
    			
    			List<String> horas = new ArrayList<>();
    			int count = 0;
    			for(int i = 9; i < 21 && count < Integer.parseInt(countH[k]); i++) {
    	    		String aux = Integer.toString(i);
    	    		if(checkboxValue[j].equals(aux)) {
    	    			String h = checkboxValue[j] + ":00";
    	    			
    	    			horas.add(h);				
    					
    	    			j++;
    	    			count++;
    	    		}	    		
    	    	}
    			
    			r.setHoras(horas);
        		entityManager.persist(r);
    		} catch (ParseException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	}    	

		return "redirect:/user/tus-reservas";
	}
	
    @RequestMapping(value ="/reserva/{id}", method = RequestMethod.GET)
	public String reserva(@PathVariable("id") long id, Model m, HttpSession session) {
    	User u = entityManager.find(User.class, session.getAttribute("user"));
    	
    	m.addAttribute("idCourt", id);
    	m.addAttribute("isPlayer", u.isPlayer());
    	m.addAttribute("s", "../../static");
    	
		return "reserva";
	}
    
    @RequestMapping(value ="/editar/{id}", method = RequestMethod.GET)
	public String editarReserva(@PathVariable("id") long id, Model m) {
    	
    	Reservation r = entityManager.find(Reservation.class, id);
    	
    	TReservation t = new TReservation();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(r.getDate());
		
		t.setDate(date);
		t.setId(r.getId());
		t.setNameCourt(r.getCourt().getName());
		
		List<String> horas = r.getHoras();
		List<Integer> tHoras = new ArrayList<Integer>();
		for(int i = 0; i < horas.size(); i++) {
			String[] h = horas.get(i).split(":");
			
			tHoras.add(Integer.parseInt(h[0]));
		}
		
		List<THour> tHours = new ArrayList<THour>();
		for(int i = 9; i < 21; i++) {
			THour th = new THour();
			th.setHour(i);
			if(tHoras.indexOf(i) != -1) {
				th.setReserved(1);
			}else {
				th.setReserved(0);
			}
			
			tHours.add(th);
		}
		
		t.setHoras(tHours);
    	
		m.addAttribute("t", t);
		m.addAttribute("s", "../../static");
		
		return "editar-reserva";
	}
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	@Transactional
	public String upload(
			@RequestParam long id,
			@RequestParam ("franja-horaria") String[] checkboxValue,
			//@RequestParam String[] countH,
			HttpSession session) {
		
		Reservation r = entityManager.find(Reservation.class, id);
		
		List<String> horas = new ArrayList<>();
		int count = 0;
		for(int i = 9; i < 21 && count < checkboxValue.length; i++) {
    		String aux = Integer.toString(i);
    		if(checkboxValue[count].equals(aux)) {
    			String h = checkboxValue[count] + ":00";
    			horas.add(h);				
    			count++;
    		}	    		
    	}
			
		r.setHoras(horas);
		
		return "home";
	}    
    
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public String deleteReservation(
			@RequestParam long id,
			HttpSession session) {
		
		Reservation r = entityManager.find(Reservation.class, id);
		
		entityManager.remove(r);
		
		return "home";
	}

}
