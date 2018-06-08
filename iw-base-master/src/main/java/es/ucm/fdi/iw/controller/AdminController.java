package es.ucm.fdi.iw.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.ucm.fdi.iw.LocalData;
import es.ucm.fdi.iw.model.Admin;
import es.ucm.fdi.iw.model.Court;
import es.ucm.fdi.iw.model.Normal;
import es.ucm.fdi.iw.model.User;

@Controller	
@RequestMapping("admin")
public class AdminController {
	
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
    
  
    
    @GetMapping("/crear-admin")
	public String crearAdmin() {
		return "crear-admin";
	}
    
    @RequestMapping(value = "/newAdmin", method = RequestMethod.POST)
	@Transactional
	public String newCourt(
			@RequestParam String Nombre, 
			@RequestParam String Email,
			@RequestParam String Direccion,
			@RequestParam String Telefono,
			@RequestParam String Dni,
			@RequestParam String Workplace,
			@RequestParam String Job,@RequestParam String Password, Model m, HttpSession session) {
		
		
		Boolean errores = false;
		
		if (Nombre == "") {
			m.addAttribute("errorNombre", "Debe insertar un nombre");
			errores = true;
		}
		if (Direccion == "") {
			m.addAttribute("errorDireccion", "Debe insertar una dirección");
			errores = true;
		}
		if (Telefono == "") {
			m.addAttribute("errorTelefono", "Debe insertar un teléfono");
			errores = true;
		}
		if (Email == "") {
			m.addAttribute("errorEmail", "Debe insertar un email");
			errores = true;
		}
		if (Dni == "") {
			m.addAttribute("errorDni", "Debe insertar un dni");
			errores = true;
		}
		if (Workplace == "") {
			m.addAttribute("errorWorkplace", "Debe insertar un lugar de trabajo");
			errores = true;
		}
		if (Job == "") {
			m.addAttribute("errorJob", "Debe insertar un puesto de trabajo");
			errores = true;
		}
		if (errores) {
			return "crear-admin";
		}
		
		
		
		Admin a = new Admin();
		a.setLogin(Email);
		a.setPassword(Password);
		a.setDir(Direccion);
		a.setName(Nombre);
		a.setPhone(Telefono);
		a.setDni(Dni);
		a.setWorkplace(Workplace);
		a.setJob(Job);
		a.setRoles("ADMIN");
		
		
		entityManager.persist(a);
		
		session.setAttribute("admin", a.getLogin());
		
		
		return "redirect:/admin/listado-admins";
	}
	
    
	@SuppressWarnings("unchecked")
	@GetMapping("/listado-admins")
	public String admins(Model m) {
		
		List<Admin> admin = entityManager.createNamedQuery("allAdmins").getResultList();
		
		m.addAttribute("listAdmins", admin);
		return "listado-admins";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@Transactional
	public String addUser(
			@RequestParam String email, 
			@RequestParam String password, 
			@RequestParam(required=false) String isAdmin, Model m) {
		User u = new Normal();
		u.setLogin(email);
		u.setPassword(passwordEncoder.encode(password));
		u.setRoles("on".equals(isAdmin) ? "ADMIN,USER" : "USER");
		entityManager.persist(u);
		
		entityManager.flush();
		m.addAttribute("users", entityManager
				.createQuery("select u from User u").getResultList());
		
		return "admin";
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
	    	log.info("Error retrieving file: " + f + " -- " + ioe.getMessage());
	    }
	}
	
	/**
	 * Uploads a photo for a user
	 * @param id of user 
	 * @param photo to upload
	 * @return
	 */
	@RequestMapping(value="/photo/{id}", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("photo") MultipartFile photo,
    		@PathVariable("id") String id){
        if (!photo.isEmpty()) {
            try {
                byte[] bytes = photo.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(
                        		new FileOutputStream(localData.getFile("user", id)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + id + 
                		" into " + localData.getFile("user", id).getAbsolutePath() + "!";
            } catch (Exception e) {
                return "You failed to upload " + id + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload a photo for " + id + " because the file was empty.";
        }
	}
	
}
