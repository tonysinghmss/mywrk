package mywrk.dao.model;

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

@Entity
@Table(name = "privileges", schema = "mywrk")
public class Privileges implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6230488157600645134L;
	private Long privilegeId;
	private String privilegeName;
	private Set<RolesPrivileges> rolesprivilegeses = new HashSet<>(0);
	public Privileges(){}
	public Privileges(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privileges", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	public Set<RolesPrivileges> getRolesprivilegeses() {
		return rolesprivilegeses;
	}
	public void setRolesprivilegeses(Set<RolesPrivileges> rolesprivilegeses) {
		this.rolesprivilegeses = rolesprivilegeses;
	}
		
}
