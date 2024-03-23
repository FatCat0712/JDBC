package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student extends Person{
	private double diemTrungBinh;
	public Student(String id, String hoTen, Date ngaySinh,double diemTrungBinh) {
		super(id, hoTen, ngaySinh);
		this.diemTrungBinh = diemTrungBinh;
		
	}
	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	

	
	
}
