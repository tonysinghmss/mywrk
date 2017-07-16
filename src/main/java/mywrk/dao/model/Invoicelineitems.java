package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Invoicelineitems generated by hbm2java
 */
@Entity
@Table(name = "invoicelineitems", schema = "mywrk")
public class Invoicelineitems implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641481235071097697L;
	private Long invoicelineitemId;
	private Invoices invoices;
	private BigDecimal price;
	private Set<Orderlineitems> orderlineitemses = new HashSet<Orderlineitems>(
			0);

	public Invoicelineitems() {
	}

	public Invoicelineitems(long invoicelineitemId) {
		this.invoicelineitemId = invoicelineitemId;
	}

	public Invoicelineitems(long invoicelineitemId, Invoices invoices,
			BigDecimal price, Set<Orderlineitems> orderlineitemses) {
		this.invoicelineitemId = invoicelineitemId;
		this.invoices = invoices;
		this.price = price;
		this.orderlineitemses = orderlineitemses;
	}

	@Id
	@Column(name = "invoicelineitem_id", nullable = false)
	public long getInvoicelineitemId() {
		return this.invoicelineitemId;
	}

	public void setInvoicelineitemId(long invoicelineitemId) {
		this.invoicelineitemId = invoicelineitemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_invoice_id")
	public Invoices getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}

	@Column(name = "price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoicelineitems")
	public Set<Orderlineitems> getOrderlineitemses() {
		return this.orderlineitemses;
	}

	public void setOrderlineitemses(Set<Orderlineitems> orderlineitemses) {
		this.orderlineitemses = orderlineitemses;
	}

}
