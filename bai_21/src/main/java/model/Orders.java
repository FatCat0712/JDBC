package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_orders")
public class Orders {
	@Id
	private int id;
	private String tenKhachHang;
	private Date ngayLap;
//	@OneToMany(mappedBy = "donHang",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "donHang",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<OrderDetails> danhSachChiTiet = new HashSet<OrderDetails>();
	
	public Orders() {
		
	}

	public Orders(int id, String tenKhachHang, Date ngayLap) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.ngayLap = ngayLap;
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

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public Set<OrderDetails> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(Set<OrderDetails> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

	

	public void setDanhSachChiTiet(HashSet<OrderDetails> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}
	public void addChiTietDonHang(OrderDetails object) {
		this.danhSachChiTiet.add(object);
	}

	@Override
	public String toString() {
		return id + " - " + tenKhachHang + " - " + ngayLap.toString();
	}
	
	
	
}
