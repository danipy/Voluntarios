package mx.voluntarios.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "EVNT")
public class Event implements Serializable {

	private static final long serialVersionUID = 5982190435139421910L;

	@Id
	@Column(name = "EVNT_ID")
	private Long id;

	@Column(name = "EVNT_NAME", length = 30)
	private String name;

	@Column(name = "EVNT_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "EVNT_TIME")
	private String time;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ONG_ID")
	private Ong ong;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "ADDRESS", length = 100)
	private String address;

	@Column(name = "LAT", length = 12)
	private String lat;

	@Column(name = "LNG", length = 12)
	private String lng;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATED", nullable = false)
	@CreatedDate
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_MODIFIED", nullable = false)
	private Date dateModified;

	@ManyToMany(mappedBy = "events")
	private Set<Volunteer> volunteers = new HashSet<Volunteer>(0);

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Set<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(Set<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}
}
