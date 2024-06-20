package hibernate_student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student_info")
public class Student {
	@Id
	private int id;
	private String name;
	
	@Column(unique = true)
	private long phone;
	private double marks;
	private String address;
	
}
