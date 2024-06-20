package manytomany_uni.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Application> list;
}
