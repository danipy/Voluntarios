package mx.voluntarios.domain;

import java.util.Collection;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "VOL")
public class Volunteer extends User {

	private static final long serialVersionUID = 7293666934494119763L;

	public Volunteer(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "SECOND_SURNAME")
	private String secondSurname;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "EXP")
	private int exp;

	@Column(name = "LVL")
	private int lvl;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATED", nullable = false)
	@CreatedDate
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_MODIFIED", nullable = false)
	private Date dateModified;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
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

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	@Column(name = "ACCOUNT_ENABLED")
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

	@Override
	@Column(name = "ACCOUNT_EXPIRED")
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isAccountNonExpired();
	}

	@Override
	@Column(name = "ACCOUNT_LOCKED")
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccountNonLocked();
	}

	@Override
	@Column(name = "CREDENTIALS_EXPIRED")
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.isCredentialsNonExpired();
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
}
