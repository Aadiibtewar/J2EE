package manytoone_uni.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private int id ;
	private String name;
	private long phone;
	private String address;
	@ManyToOne(fetch = FetchType.LAZY)
	private College college;
	
}
