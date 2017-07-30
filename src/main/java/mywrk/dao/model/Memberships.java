package mywrk.dao.model;

import javax.persistence.CascadeType;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Memberships generated by hbm2java
 */
@Entity
@Table(name = "memberships", schema = "mywrk")
public class Memberships implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6062640284426001733L;
	private Long membershipId;
	private Roles roles;
	private Users users;
	private String emailAddrs;
	private String phoneNumber;

	public Memberships() {
	}

	public Memberships(long membershipId) {
		this.membershipId = membershipId;
	}

	public Memberships(long membershipId, Roles roles, Users users,
			String emailAddrs, String phoneNumber) {
		this.membershipId = membershipId;
		this.roles = roles;
		this.users = users;
		this.emailAddrs = emailAddrs;
		this.phoneNumber = phoneNumber;
	}

	@Id
	@Column(name = "membership_id", nullable = false)
	public long getMembershipId() {
		return this.membershipId;
	}

	public void setMembershipId(long membershipId) {
		this.membershipId = membershipId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "related_role_id")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "related_user_id")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "email_addrs")
	public String getEmailAddrs() {
		return this.emailAddrs;
	}

	public void setEmailAddrs(String emailAddrs) {
		this.emailAddrs = emailAddrs;
	}

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
