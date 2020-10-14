package info.infoPet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fulldata")
public class FullData {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String servicename;
	private String serviceid;
	private String organicode;
	@Id
	private String manageid;
	private String statecode;
	private String statename;
	private String tel;
	private String preaddress;
	private String roadaddress;
	private String roadpost;
	private String name;
	private String x;
	private String y;
		
}
