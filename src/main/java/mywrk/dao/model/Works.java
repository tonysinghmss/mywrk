package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Works generated by hbm2java
 */
@Entity
@Table(name = "works", schema = "mywrk")
public class Works implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876957384681698989L;
	private Long workId;
	private WorkCategory workCategory;
	private WorkStatus workStatus;
	private Date workCreatedOn;
	private Set<Orderlineitems> orderlineitemses = new HashSet<Orderlineitems>(
			0);

	public Works() {
	}

	public Works(Long workId) {
		this.workId = workId;
	}

	public Works(Long workId, WorkCategory workCategory, WorkStatus workStatus,
			Date workCreatedOn, Set<Orderlineitems> orderlineitemses) {
		this.workId = workId;
		this.workCategory = workCategory;
		this.workStatus = workStatus;
		this.workCreatedOn = workCreatedOn;
		this.orderlineitemses = orderlineitemses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_id", nullable = false)
	public Long getWorkId() {
		return this.workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_work_category_id")
	public WorkCategory getWorkCategory() {
		return this.workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_work_status_id")
	public WorkStatus getWorkStatus() {
		return this.workStatus;
	}

	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "work_created_on", length = 29)
	public Date getWorkCreatedOn() {
		return this.workCreatedOn;
	}

	public void setWorkCreatedOn(Date workCreatedOn) {
		this.workCreatedOn = workCreatedOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "works")
	public Set<Orderlineitems> getOrderlineitemses() {
		return this.orderlineitemses;
	}

	public void setOrderlineitemses(Set<Orderlineitems> orderlineitemses) {
		this.orderlineitemses = orderlineitemses;
	}

}
