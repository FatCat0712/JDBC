package model;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee {
	@Id
	private String id;
	private String hoTen;
	private Date ngaySinh;
	@ManyToMany(mappedBy = "danhSachNhanVien")
	private Set<Meeting> danhSachCuocHop = new TreeSet<Meeting>();
	public Employee() {
		
	}
	public Employee(String id, String hoTen, Date ngaySinh) {
		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
	
}
