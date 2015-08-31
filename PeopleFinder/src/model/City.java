package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CITIES database table.
 * 
 */
@Entity
@Table(name="CITIES")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long cityid;

	private String cityname;

	//bi-directional many-to-one association to Customerspractice
	@OneToMany(mappedBy="cityBean")
	private List<Customerspractice> customerspractices;

	public City() {
	}

	public long getCityid() {
		return this.cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public List<Customerspractice> getCustomerspractices() {
		return this.customerspractices;
	}

	public void setCustomerspractices(List<Customerspractice> customerspractices) {
		this.customerspractices = customerspractices;
	}

	public Customerspractice addCustomerspractice(Customerspractice customerspractice) {
		getCustomerspractices().add(customerspractice);
		customerspractice.setCityBean(this);

		return customerspractice;
	}

	public Customerspractice removeCustomerspractice(Customerspractice customerspractice) {
		getCustomerspractices().remove(customerspractice);
		customerspractice.setCityBean(null);

		return customerspractice;
	}

}