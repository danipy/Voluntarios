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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ONG")
public class Ong extends User {

	private static final long serialVersionUID = 4858219109180608729L;

	public Ong(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	public Ong(String username, String password,
			Collection<GrantedAuthority> authorities) {
		super(username, password, authorities);
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

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CV_REQUIRED")
	private boolean cvRequired; // 1 SI, 0 NO

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATED", nullable = false)
	@CreatedDate
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_MODIFIED", nullable = false)
	private Date dateModified;

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

	public boolean getCvRequired() {
		return cvRequired;
	}

	public void setCvRequired(boolean cvRrequired) {
		this.cvRequired = cvRrequired;
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
}
