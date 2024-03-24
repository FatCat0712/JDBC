package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_orderdetails")
public class OrderDetails {
	@Id
	private int id;
	private String tenSanPham;
	private int soLuong;
	private double donGia;
	private double tongTien;
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="donhang_id")
	private Orders donHang;
	
	public OrderDetails() {
		
	}

	public OrderDetails(int id, String tenSanPham, int soLuong, double donGia, double tongTien,Orders donHang) {
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tongTien = tongTien;
		this.donHang = donHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Orders getDonHang() {
		return donHang;
	}

	public void setDonHang(Orders donHang) {
		this.donHang = donHang;
	}

	@Override
	public String toString() {
		return id + " - " + tenSanPham + " - " + soLuong + " - " + donGia + " - " + tongTien;
	}
	
	
	
	
	
}
