package es.ucm.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;


@NamedQueries({
	@NamedQuery(name = "findCourtByName", query = "select c from Court c where c.name = :n"),
	@NamedQuery(name = "allCourts", query = "select c from Court c"),
	@NamedQuery(name = "findCourtById", query = "select c from Court c where c.id = :n")
})

@Entity
public class Court {

	private long id;
	private String name;
	@Size(min=1, max=1000)
	private String description;
	private String dir;
	private String phone;
	@Size(min=1, max=1000)
	private String extras;
	private double price;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}	
}
