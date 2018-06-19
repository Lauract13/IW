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
import org.springframework.web.bind.annotation.ResponseBody;

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
    @SuppressWarnings("unused")
	@RequestMapping(value = "/nuevaReserva", method = RequestMethod.POST)
	@Transactional
	public String creaReserva(
			@RequestParam String idCourt,
			@RequestParam String[] datepicker,
			@RequestParam ("franja-horaria") int[] checkboxValue,
			@RequestParam int[] countH,
			@RequestParam int horasR,
			HttpSession session) {
    	
    	int j = 0;
    	User u = entityManager.find(User.class, session.getAttribute("user"));
    	Court c = entityManager.find(Court.class, Long.parseLong(idCourt));
    	int cont = 0;
    	if(u.isPlayer())
    		cont = horasR;
    	
    	for(int k = 0; k < datepicker.length; k++) {
        	Reservation r = new Reservation();
        	boolean suma = false;
        	
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
    				if(u.isPlayer())
    					suma = true;
    			}
    			
    			r.setDate(date);
    			r.setUser(u);		
    			r.setCourt(c);			
    			
    			List<String> horas = new ArrayList<>();
    			int count = 0;
    			for(int i = 9; i < 21 && count < countH[k]; i++) {
    	    		if(checkboxValue[j] == i) {
    	    			String h = checkboxValue[j] + ":00";
    	    			
    	    			horas.add(h);				
    					
    	    			j++;
    	    			count++;
    	    			if(u.isPlayer())
    	    				cont++;
    	    		}	    		
    	    	}
    			
    			r.setHoras(horas);
    			
    			if(cont > 18) {
    				return "redirect:/error";
    			}
        		entityManager.persist(r);
    		} catch (ParseException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	}    	

		return "redirect:/user/tus-reservas";
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value ="/reserva/{id}", method = RequestMethod.GET)
	public String reserva(@PathVariable("id") long id, Model m, HttpSession session) {
    	User u = entityManager.find(User.class, session.getAttribute("user"));
    	int cont = -1;
    	if(u.isPlayer()) {
    		cont = 0;
    		List<Reservation> list = entityManager.createNamedQuery("reservationsPlayer").setParameter("n", u).getResultList();
        	
        	for(Reservation r: list) {
        		cont += r.getHoras().size();
        	}
    	}
    	
    	Court c = entityManager.find(Court.class, id);
    	
    	m.addAttribute("idCourt", id);
    	m.addAttribute("nameCourt", c.getName());
    	m.addAttribute("isPlayer", u.isPlayer());
    	m.addAttribute("cont", cont);
    	m.addAttribute("s", "../../static");
    	
		return "reserva";
	}
    
    /**
     * Mapper de la vista encargada de editar una reserva, obtiene las horas disponibles esa
     * fecha en la pista de la reseva.
     * @param id Id de la reserva
     * @param m
     * @param session
     * @return 
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value ="/editar/{id}", method = RequestMethod.GET)
	public String editarReserva(@PathVariable("id") long id, Model m, HttpSession session) {
    	
    	Reservation r = entityManager.find(Reservation.class, id);
    	
    	TReservation t = new TReservation();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(r.getDate());
		
		t.setDate(date);
		t.setId(r.getId());
		t.setNameCourt(r.getCourt().getName());
				
		List<Reservation> list = entityManager.createNamedQuery("bookingCourt").setParameter("d", r.getDate()).setParameter("c", r.getCourt()).getResultList();
		List<THour> th = new ArrayList<THour>();
		
		th = toTHour(r.getHoras()); //Lleno la lista con las horas de la reserva del usuario
		
		for(int i = 0; i < th.size(); i++) {
			if(th.get(i).getReserved() == 2) {
				th.get(i).setReserved(1);
			}
		}
		
		for(Reservation res: list) {
			List<String> horas = res.getHoras();
			List<THour> aux = toTHour(horas);
			
			for(int i = 0; i < th.size(); i++) {
				if(aux.get(i).getReserved() == 2 && th.get(i).getReserved() != 1) {
					th.get(i).setReserved(2);
				}
			}
		}	
		
		t.setHoras(th);
    	
		m.addAttribute("t", t);
		m.addAttribute("s", "../../static");
		
		return "editar-reserva";
	}
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	@Transactional
	public String upload(
			@RequestParam long id,
			@RequestParam ("franja-horaria") int[] checkboxValue) {
		
		Reservation r = entityManager.find(Reservation.class, id);
		
		List<String> horas = new ArrayList<>();
		int count = 0;
		for(int i = 9; i < 21 && count < checkboxValue.length; i++) {
    		if(checkboxValue[count] == i) {
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
	
	/**
	 * Devuelve las horas reservadas y disponibles dada una fecha concreta.
	 * @param date Fecha de la que obetener información
	 * @param court Pista sobre la que se quiere obtener información de las reservas.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	@ResponseBody
	public List<THour> booking(@RequestParam String date, @RequestParam long court) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<THour> t = new ArrayList<THour>();
		
    	try {
			Date d = sdf.parse(date);
			Court c = entityManager.find(Court.class, court);
			List<Reservation> list = entityManager.createNamedQuery("freeHours").setParameter("d", d).setParameter("c", c).getResultList();
			
			List<String> all = new ArrayList<String>();
			for(Reservation r: list) {
				List<String> horas = r.getHoras();
				
				for(String h: horas) {
					all.add(h);
				}
			}
			
			t = toTHour(all);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;	
	}
	
	/**
	 * Método encargado de parsear las horas de las que dispone un día,
	 * parseando la hora y la disponibilidad de cada una de ellas en un transfer adecuado para la vista,
	 * en este caso el transfer THour.
	 * @param horas
	 * @return
	 */
	private List<THour> toTHour(List<String> horas) {
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
				th.setReserved(2);
			}else {
				th.setReserved(0);
			}
			
			tHours.add(th);
		}
		
		return tHours;
	}

}
