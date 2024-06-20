package manytomany_bi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int sid;
	private String name;
	private long phone;
	private String address;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "sid"),inverseJoinColumns = @JoinColumn(name = "cid"))
	List<Course>courses;
	
}
