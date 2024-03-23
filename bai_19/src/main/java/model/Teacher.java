package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_teacher")
public class Teacher extends Person{
	private String monPhuTrach;

	public Teacher(String id, String hoTen, Date ngaySinh, String monPhuTrach) {
		super(id, hoTen, ngaySinh);
		this.monPhuTrach = monPhuTrach;
	}

	public String getMonPhuTrach() {
		return monPhuTrach;
	}

	public void setMonPhuTrach(String monPhuTrach) {
		this.monPhuTrach = monPhuTrach;
	}
	
}
