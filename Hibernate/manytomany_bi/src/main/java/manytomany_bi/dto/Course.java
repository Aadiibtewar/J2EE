package manytomany_bi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Course {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cid;
	private String name;
	private double fees;
	private double duration;
	
	@ManyToMany(mappedBy = "courses")
	List<Student>students;
}
