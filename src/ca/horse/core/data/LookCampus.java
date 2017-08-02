package ca.horse.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="look_campus", schema="campus")
public class LookCampus  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="cd")
	private String cd;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
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
}
