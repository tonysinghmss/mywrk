package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

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

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name = "roles", schema = "mywrk")
public class Roles implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3743803175820390081L;
	private Long roleId;
	private String roleName;
	private Set<Memberships> membershipses = new HashSet<Memberships>(0);
	private Set<Privileges> privileges = new HashSet<>(0);

	public Roles() {
	}

	public Roles(long roleId) {
		this.roleId = roleId;
	}

	public Roles(long roleId, String roleName, Set<Memberships> membershipses) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.membershipses = membershipses;
	}

	@Id
	@Column(name = "role_id", nullable = false)
	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<Memberships> getMembershipses() {
		return this.membershipses;
	}

	public void setMembershipses(Set<Memberships> membershipses) {
		this.membershipses = membershipses;
	}
	
	@ManyToMany
	@JoinTable(name="role_privileges",
				joinColumns=@JoinColumn(name="role_id", referencedColumnName = "roleId"),
				inverseJoinColumns=@JoinColumn(name="privilege_id", referencedColumnName = "roleId"))
	public Set<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privileges> privileges) {
		this.privileges = privileges;
	}
	
	
}
