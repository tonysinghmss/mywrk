package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Set<RolesPrivileges> rolesprivilegeses = new HashSet<>(0);

	public Roles() {
	}

	public Roles(Long roleId) {
		this.roleId = roleId;
	}

	public Roles(Long roleId, String roleName, Set<Memberships> membershipses) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.membershipses = membershipses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	public Set<Memberships> getMembershipses() {
		return this.membershipses;
	}

	public void setMembershipses(Set<Memberships> membershipses) {
		this.membershipses = membershipses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	public Set<RolesPrivileges> getRolesprivilegeses() {
		return rolesprivilegeses;
	}

	public void setRolesprivilegeses(Set<RolesPrivileges> rolesprivilegeses) {
		this.rolesprivilegeses = rolesprivilegeses;
	}	
}
