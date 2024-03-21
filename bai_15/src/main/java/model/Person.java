package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name="person_id")
	private int id;
	private String name;
	private Date dateOfBirth;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="spouse_id")
	private Person spouse;
	
	public Person() {
		
	}

	public Person(String name, Date dateOfBirth, Person spouse) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.spouse = spouse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	public String toString() {
		return id + " - " + name + " - " + dateOfBirth.toString();
	}
	
	
	
	
	
	
}

