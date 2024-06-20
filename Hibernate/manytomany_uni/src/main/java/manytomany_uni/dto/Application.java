package manytomany_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Application {
	@Id
	private int id;
	private String name;
	private String company;
	
}
