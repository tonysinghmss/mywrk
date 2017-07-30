package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", schema = "mywrk")
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5074527544635474973L;
	private Long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private Logins logins;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Memberships> membershipses = new HashSet<Memberships>(0);
	private Set<Payments> paymentses = new HashSet<Payments>(0);

	public Users() {
	}

	public Users(long userId) {
		this.userId = userId;
	}

	public Users(long userId, String firstName, String lastName,
			String userName, Set<Orders> orderses, Logins logins,
			Set<Memberships> membershipses, Set<Payments> paymentses) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.orderses = orderses;
		this.logins = logins;
		this.membershipses = membershipses;
		this.paymentses = paymentses;
	}

	@Id
	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "users", optional=false, cascade=CascadeType.ALL)
	public Logins getLogins() {
		return this.logins;
	}

	public void setLogins(Logins logins) {
		this.logins = logins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public Set<Memberships> getMembershipses() {
		return this.membershipses;
	}

	public void setMembershipses(Set<Memberships> membershipses) {
		this.membershipses = membershipses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Payments> getPaymentses() {
		return this.paymentses;
	}

	public void setPaymentses(Set<Payments> paymentses) {
		this.paymentses = paymentses;
	}

}
