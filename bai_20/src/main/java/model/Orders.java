package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_orders")
public class Orders {
	@Id
	@GeneratedValue
	private int id;
	private String tenKhachHang;
	private Date ngayTao;
	@OneToMany(cascade = CascadeType.MERGE,mappedBy = "donHang")
	private Set<OrderDetails> danhSachchiTiet = new HashSet<OrderDetails>();
	public Orders() {
		
	}

	public Orders(int id, String tenKhachHang, Date ngayTao, Set<OrderDetails> danhSachchiTiet) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.ngayTao = ngayTao;
		this.danhSachchiTiet = danhSachchiTiet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	
	
	public Set<OrderDetails> getDanhSachchiTiet() {
		return danhSachchiTiet;
	}

	public void setDanhSachchiTiet(Set<OrderDetails> danhSachchiTiet) {
		this.danhSachchiTiet = danhSachchiTiet;
	}
	public void addDanhSachChiTiet(OrderDetails object) {
		this.danhSachchiTiet.add(object);
	}
	
	
	public String toString() {
		return id + " - " + tenKhachHang + " - " + ngayTao.toString();
	}
	

	

	
	
	
	
	
	
}
