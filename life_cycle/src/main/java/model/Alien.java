package model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="tbl_alien")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alien {
	@Id
	private int aid;
	private String name;
	private String color;
	
	public Alien() {
		
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return aid + " - " + name + " - " + color;
	}
	
}
