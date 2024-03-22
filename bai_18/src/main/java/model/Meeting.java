package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_meeting")
public class Meeting {
	@Id
	@GeneratedValue
	private int id;
	private String tenCuocHop;
	private Date thoiGian;
	private String diaDiem;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="meeting_employee",
				joinColumns = {@JoinColumn(name="meeting_id" )}, 
				inverseJoinColumns = {@JoinColumn(name="employee_id")})
	private Set<Employee> danhSachNhanVien = new HashSet<Employee>();
	
	public Meeting() {
		
	}
	public Meeting(int id, String tenCuocHop, Date thoiGian, String diaDiem) {
		this.id = id;
		this.tenCuocHop = tenCuocHop;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenCuocHop() {
		return tenCuocHop;
	}
	public void setTenCuocHop(String tenCuocHop) {
		this.tenCuocHop = tenCuocHop;
	}
	public Date getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public void addEmployee(Employee object) {
		danhSachNhanVien.add(object);
	}
	
	
	
}
