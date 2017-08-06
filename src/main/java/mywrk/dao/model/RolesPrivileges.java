package mywrk.dao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles_privileges", schema = "mywrk")
public class RolesPrivileges implements java.io.Serializable{
	
	private static final long serialVersionUID = 8326129618597552770L;
	private Long rlsPrivId;
	private Roles roles;
	private Privileges privileges;
	
	public RolesPrivileges() {
	}
	
	public RolesPrivileges(Long rlsPrivId){
		this.rlsPrivId = rlsPrivId;
	}
	
	public RolesPrivileges(Long rlsPrivId, Roles roles, Privileges privileges){
		this.rlsPrivId = rlsPrivId;
		this.roles = roles;
		this.privileges = privileges;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rlspriv_id", nullable = false)
	public Long getRlsPrivId() {
		return rlsPrivId;
	}

	public void setRlsPrivId(Long rlsPrivId) {
		this.rlsPrivId = rlsPrivId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "related_role_id")
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "related_privilege_id")
	public Privileges getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}	
}
