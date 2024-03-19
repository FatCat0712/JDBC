package model;

public class User {
	private String taiKhoan;
	private String matKhau;
	private String hoTen;
	
	public User() {
		
	}

	public User(String taiKhoan, String matKhau, String hoTen) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String toString() {
		return taiKhoan + " - "+ matKhau + " - "+hoTen;
	}
	
	
}
