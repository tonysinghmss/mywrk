package mywrk.dao.model;

// Generated Jul 13, 2017 2:08:22 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Invoices generated by hbm2java
 */
@Entity
@Table(name = "invoices", schema = "mywrk")
public class Invoices implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5873999608636791349L;
	private Long invoiceId;
	private String invoiceDescription;
	private Set<Invoicelineitems> invoicelineitemses = new HashSet<Invoicelineitems>(
			0);
	private Set<Payments> paymentses = new HashSet<Payments>(0);

	public Invoices() {
	}

	public Invoices(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Invoices(long invoiceId, String invoiceDescription,
			Set<Invoicelineitems> invoicelineitemses, Set<Payments> paymentses) {
		this.invoiceId = invoiceId;
		this.invoiceDescription = invoiceDescription;
		this.invoicelineitemses = invoicelineitemses;
		this.paymentses = paymentses;
	}

	@Id
	@Column(name = "invoice_id", nullable = false)
	public long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "invoice_description")
	public String getInvoiceDescription() {
		return this.invoiceDescription;
	}

	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoices")
	public Set<Invoicelineitems> getInvoicelineitemses() {
		return this.invoicelineitemses;
	}

	public void setInvoicelineitemses(Set<Invoicelineitems> invoicelineitemses) {
		this.invoicelineitemses = invoicelineitemses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoices")
	public Set<Payments> getPaymentses() {
		return this.paymentses;
	}

	public void setPaymentses(Set<Payments> paymentses) {
		this.paymentses = paymentses;
	}

}