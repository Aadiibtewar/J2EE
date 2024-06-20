package jdbc_servlet;

public class Person {

	public Person() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String password;

	
//	public Person(int id, String name, String address, String phone, String email, String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.address = address;
//		this.phone = phone;
//		this.email = email;
//		this.password = password;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
