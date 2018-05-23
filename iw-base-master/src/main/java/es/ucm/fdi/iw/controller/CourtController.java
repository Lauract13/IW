package es.ucm.fdi.iw.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.ucm.fdi.iw.LocalData;
import es.ucm.fdi.iw.model.Court;


@Controller
@RequestMapping("court")
public class CourtController {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private LocalData localData;
	
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "/static");
    }

	/**
	 * Returns a users' photo
	 * @param id of user to get photo from
	 * @return
	 */
	@RequestMapping(value="/photo/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void userPhoto(@PathVariable("id") String id, 
			HttpServletResponse response) {
	    File f = localData.getFile("user", id);
	    InputStream in = null;
	    try {
		    if (f.exists()) {
		    	in = new BufferedInputStream(new FileInputStream(f));
		    } else {
		    	in = new BufferedInputStream(
		    			this.getClass().getClassLoader().getResourceAsStream("unknown-user.jpg"));
		    }
	    	FileCopyUtils.copy(in, response.getOutputStream());
	    } catch (IOException ioe) {
	    	//log.info("Error retrieving file: " + f + " -- " + ioe.getMessage());
	    }
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/pistas")
	public String pistas(Model m) {
		
		List<Court> l = entityManager.createNamedQuery("allCourts").getResultList();
		
		m.addAttribute("list", l);
		return "pistas";
	}
	
	@RequestMapping(value="/perfil-pista/{id}", method = RequestMethod.GET)
	public String perfilPista(@PathVariable("id") String id, Model m) {
		Court c = (Court) entityManager.createNamedQuery("findCourtById").getSingleResult();
		
		m.addAttribute("court", c);
		return "perfil-pista";
	}
	
	@GetMapping("/pistas-user")
	public String pistasUser() {
		return "pistas-user";
	}
	
	@GetMapping("/crear-pista")
	public String loginAdmin() {
		return "crear-pista";
	}
	
	@RequestMapping(value = "/newCourt", method = RequestMethod.POST)
	@Transactional
	public String newCourt(
			@RequestParam String Nombre, 
			@RequestParam Double Precio,
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String Extras,
			@RequestParam String Descripcion,
			@RequestParam("file") MultipartFile photo, Model m, HttpSession session) {
		
		Court c = new Court();
					
		Query q = entityManager.createNamedQuery("findCourtByName").setParameter("n", Nombre);
		
		if(q.getResultList().isEmpty()) {
			c.setDescription(Descripcion);
			c.setDir(Direccion);
			c.setExtras(Extras);
			c.setName(Nombre);
			c.setPhone(Telefono);
			c.setPrice(Precio);
			
			if (!photo.isEmpty()) {
				try {
					byte[] bytes = photo.getBytes();
					c.setPhoto(bytes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	        }		
		}				
				
		entityManager.persist(c);
		
		return "redirect:/court/pistas";
	}
	
	@RequestMapping(value="/deleteCourt", method=RequestMethod.DELETE)
	public String deleteCourt(@RequestParam long id) {
				
		Court c = entityManager.find(Court.class, id);
		
		entityManager.remove(c);
		
		return "home";
	}
	
	@RequestMapping(value="/uploadCourt", method=RequestMethod.POST)
	public String uploadCourt(@RequestParam long id,
							 @RequestParam String name,
							 @RequestParam String description,
							 @RequestParam String phone,
							 @RequestParam String extras,
							 @RequestParam double price,
							 @RequestParam("file") MultipartFile photo) {
				
		Court c = entityManager.find(Court.class, id);
		
		c.setDescription(description);
		c.setName(name);
		c.setPhone(phone);
		c.setExtras(extras);
		c.setPrice(price);
		
		if (!photo.isEmpty()) {
			try {
				byte[] bytes = photo.getBytes();
				c.setPhoto(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }	
		
		return "home";
	}
	
}
