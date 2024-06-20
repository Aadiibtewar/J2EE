package manytoone_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class College {
	@Id
	private int id ;
	private String name;
	private double fees;
	
}
