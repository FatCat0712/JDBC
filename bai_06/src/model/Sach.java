package model;

public class Sach {
	private int id;
	private String tenSach;
	private double giaBan;
	private int namSanXuat;
	
	public Sach() {
		
	}

	
	public Sach(String tenSach, double giaBan, int namSanXuat) {
		super();
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namSanXuat = namSanXuat;
	}




	public Sach(int id,String tenSach, double giaBan, int namSanXuat) {
		this.id = id;
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namSanXuat = namSanXuat;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}
	
	
	
	
}
