package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATES database table.
 * 
 */
@Entity
@Table(name="STATES")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long stateid;

	private String statename;

	//bi-directional many-to-one association to Customerspractice
	@OneToMany(mappedBy="stateBean")
	private List<Customerspractice> customerspractices;

	public State() {
	}

	public long getStateid() {
		return this.stateid;
	}

	public void setStateid(long stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return this.statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public List<Customerspractice> getCustomerspractices() {
		return this.customerspractices;
	}

	public void setCustomerspractices(List<Customerspractice> customerspractices) {
		this.customerspractices = customerspractices;
	}

	public Customerspractice addCustomerspractice(Customerspractice customerspractice) {
		getCustomerspractices().add(customerspractice);
		customerspractice.setStateBean(this);

		return customerspractice;
	}

	public Customerspractice removeCustomerspractice(Customerspractice customerspractice) {
		getCustomerspractices().remove(customerspractice);
		customerspractice.setStateBean(null);

		return customerspractice;
	}

}