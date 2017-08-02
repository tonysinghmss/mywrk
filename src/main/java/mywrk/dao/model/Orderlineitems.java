package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orderlineitems generated by hbm2java
 */
@Entity
@Table(name = "orderlineitems", schema = "mywrk")
public class Orderlineitems implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6394703388102294531L;
	private Long orderlineitemId;
	private Invoicelineitems invoicelineitems;
	private Orders orders;
	private Works works;
	private Integer orderNumber;
	private Boolean paid;

	public Orderlineitems() {
	}

	public Orderlineitems(Long orderlineitemId) {
		this.orderlineitemId = orderlineitemId;
	}

	public Orderlineitems(Long orderlineitemId,
			Invoicelineitems invoicelineitems, Orders orders, Works works,
			Integer orderNumber, Boolean paid) {
		this.orderlineitemId = orderlineitemId;
		this.invoicelineitems = invoicelineitems;
		this.orders = orders;
		this.works = works;
		this.orderNumber = orderNumber;
		this.paid = paid;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderlineitem_id", nullable = false)
	public Long getOrderlineitemId() {
		return this.orderlineitemId;
	}

	public void setOrderlineitemId(Long orderlineitemId) {
		this.orderlineitemId = orderlineitemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoicelineitem_id")
	public Invoicelineitems getInvoicelineitems() {
		return this.invoicelineitems;
	}

	public void setInvoicelineitems(Invoicelineitems invoicelineitems) {
		this.invoicelineitems = invoicelineitems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_order_id")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_work_id")
	public Works getWorks() {
		return this.works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	@Column(name = "order_number")
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "paid")
	public Boolean getPaid() {
		return this.paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

}
