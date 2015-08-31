package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CUSTOMERSPRACTICE database table.
 * 
 */
@Entity
@NamedQuery(name="Customerspractice.findAll", query="SELECT c FROM Customerspractice c")
public class Customerspractice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String customerid;

	private String city;

	private String company;

	private BigDecimal companyid;

	private String emailaddress;

	private String firstname;

	private String fullname;

	private String lastname;

	@Column(name="\"POSITION\"")
	private String position;

	@Column(name="\"STATE\"")
	private String state;

	private String streetaddress;

	private String title;

	private BigDecimal zipcode;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITYID")
	private City cityBean;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATEID")
	private State stateBean;

	public Customerspractice() {
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public BigDecimal getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(BigDecimal companyid) {
		this.companyid = companyid;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetaddress() {
		return this.streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(BigDecimal zipcode) {
		this.zipcode = zipcode;
	}

	public City getCityBean() {
		return this.cityBean;
	}

	public void setCityBean(City cityBean) {
		this.cityBean = cityBean;
	}

	public State getStateBean() {
		return this.stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}