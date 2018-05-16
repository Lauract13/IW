package es.ucm.fdi.iw.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.ucm.fdi.iw.LocalData;
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
    
	@RequestMapping(value = "/login-admin", method = RequestMethod.POST)
	@Transactional
	public String login(@RequestParam String Email,
						@RequestParam String Password, Model m, HttpSession session) {
		User u = entityManager.find(User.class, Email);
	
		session.setAttribute("user", u.getLogin());	
		
		if(u.getPassword().equals(Password)) {
			return "home";
		}else {
			return "login-admin";
		}
			
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
	
	@RequestMapping(value="/addCourt", method=RequestMethod.POST)
    public String addCourt(@RequestParam String name,
    						@RequestParam String description,
    						@RequestParam String dir,
    						@RequestParam String prhone,
    						@RequestParam String extras,
    						@RequestParam double price, Model m){
        
		Court c = new Court();
		
		Query q = entityManager.createNamedQuery("select * from court where name =:n").setParameter("n", name);
		
		if(q.getResultList().isEmpty()) {
			c.setDescription(description);
			c.setDir(dir);
			c.setExtras(extras);
			c.setName(name);
			c.setPhone(prhone);
			c.setPrice(price);
		}		
		entityManager.persist(c);
		
		return "home";
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
							 @RequestParam double price) {
				
		Court c = entityManager.find(Court.class, id);
		
		c.setDescription(description);
		c.setName(name);
		c.setPhone(phone);
		c.setExtras(extras);
		c.setPrice(price);
		
		return "home";
	}
	
}
