package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_author")
public class Author {
	@Id
	private String id;
	private String name;
	private Date dateOfBirth;
	private String nationality;
	public Author() {
		
	}
	public Author(String id, String name, Date dateOfBirth, String nationality) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String toString() {
		return id + " - " + name + " - " + nationality;
	}
	
	
	
	
	
	
	
}
