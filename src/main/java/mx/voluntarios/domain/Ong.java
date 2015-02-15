package mx.voluntarios.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ONG")
public class Ong {

	@Id
	@Column(name = "ONG_ID")
	private Long id;

	@Column(name = "ONG_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CV")
	private short cv; // 1 SI, 0 NO

	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ONG_VOL", joinColumns = { @JoinColumn(name = "ONG_ID") },
				inverseJoinColumns = { @JoinColumn(name = "VOL_ID") })
	private Set<Volunteer> volunteers = new HashSet<Volunteer>(0);

	@OneToMany(mappedBy = "ong", fetch = FetchType.LAZY)
	private Set<Event> events = new HashSet<Event>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public short getCv() {
		return cv;
	}

	public void setCv(short cv) {
		this.cv = cv;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(Set<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Ong [id=" + id + ", name=" + name + ", description="
				+ description + ", address=" + address + ", cv=" + cv
				+ ", dateOfReg=" + dateCreated + "]";
	}
}
