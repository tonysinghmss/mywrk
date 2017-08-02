package mywrk.dao.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privileges", schema = "mywrk")
public class Privileges implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6230488157600645134L;
	private Long privilegeId;
	private String privilegeName;
	private Set<Roles> roles = new HashSet<>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "privilege_id", nullable = false)
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	@Column(name = "privilege_name")
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
	@ManyToMany(mappedBy = "privileges")
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
}
