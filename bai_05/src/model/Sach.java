package model;

public class Sach {
     private int id;
     private String tenSach;
     private float giaBan;
     private int namXuatBan;
     
     public Sach() {
    	 
     }
     
     public Sach(int id, String tenSach, float giaBan, int namXuatBan) {
		super();
		this.id = id;
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namXuatBan = namXuatBan;
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


	public float getGiaBan() {
		return giaBan;
	}


	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}


	public int getNamXuatBan() {
		return namXuatBan;
	}


	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
     
     
     
  
}
