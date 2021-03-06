package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Logins generated by hbm2java
 */
@Entity
@Table(name = "logins", schema = "mywrk")
public class Logins implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3093763378845870599L;
	private Long loginId;
	private Users users;
	private String userName;
	//private String passwordSalt;
	private String passwordHash;

	public Logins() {
	}

	public Logins(Long loginId) {
		this.loginId = loginId;
	}

	public Logins(Long loginId, Users users, String userName,
			 String passwordHash) {
		this.loginId = loginId;
		this.users = users;
		this.userName = userName;
		//this.passwordSalt = passwordSalt;
		this.passwordHash = passwordHash;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id", nullable = false)
	public Long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	@OneToOne(fetch = FetchType.LAZY, optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name = "related_user_id")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*@Column(name = "password_salt")
	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
*/
	@Column(name = "password_hash", length=60)
	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
