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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "VOL")
public class Volunteer {
	@Id
	@Column(name = "VOL_ID")
	private Long id;

	@Column(name = "VOL_NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CITY")
	private String city;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "EXP")
	private int exp;

	@Column(name = "LVL")
	private int lvl;

	@Column(name = "DATE_CREATED")
	@CreatedDate
	private Date dateCreated;

	@ManyToMany(mappedBy = "volunteers")
	private Set<Ong> ongs = new HashSet<Ong>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EVNT_VOL", joinColumns = { @JoinColumn(name = "VOL_ID") },
				inverseJoinColumns = { @JoinColumn(name = "EVNT_ID") })
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Ong> getOngs() {
		return ongs;
	}

	public void setOngs(Set<Ong> ongs) {
		this.ongs = ongs;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Volunteer [name=" + name + ", lastName=" + lastName
				+ ", username=" + username + ", email=" + email + ", city="
				+ city + ", birthday=" + birthday + ", exp=" + exp + ", lvl="
				+ lvl + ", dateCreated=" + dateCreated + "]";
	}
}
