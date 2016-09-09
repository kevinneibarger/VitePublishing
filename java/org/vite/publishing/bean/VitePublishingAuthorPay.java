/**
 * 
 */
package org.vite.publishing.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Kevin Neibarger
 *
 */
@Entity
@Table (name = "v_a_author_pay")
public class VitePublishingAuthorPay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long paidId;
	private long authorId;
	private Timestamp endOfMonth;
	private String dollarAmt;
	private String paidOut;
	private Timestamp paidDate;
	private String transactionId;
	private VitePublishingAuthor viteAuthor;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PAID_ID", unique = true, nullable = false)
	public long getPaidId() {
		return paidId;
	}
	public void setPaidId(long paidId) {
		this.paidId = paidId;
	}
	
	@Column(name = "AUTHOR_ID", unique = true, nullable = false)
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AUTHOR_ID", insertable = false, updatable = false)
	public VitePublishingAuthor getViteAuthor() {
		return viteAuthor;
	}
	
	@Column(name = "END_OF_MONTH", unique = true, nullable = false)
	public Timestamp getEndOfMonth() {
		return endOfMonth;
	}
	public void setEndOfMonth(Timestamp endOfMonth) {
		this.endOfMonth = endOfMonth;
	}
	
	@Column(name = "DOLLAR_AMT", unique = true, nullable = false, length = 50)
	public String getDollarAmt() {
		return dollarAmt;
	}
	public void setDollarAmt(String dollarAmt) {
		this.dollarAmt = dollarAmt;
	}
	
	@Column(name = "PAID_OUT", unique = true, nullable = false, length = 20)
	public String getPaidOut() {
		return paidOut;
	}
	public void setPaidOut(String paidOut) {
		this.paidOut = paidOut;
	}
	
	@Column(name = "PAID_DATE", unique = true, nullable = false)
	public Timestamp getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Timestamp paidDate) {
		this.paidDate = paidDate;
	}
	
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false, length = 10)
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String toString() {
		
		return "Paid ID: "+paidId+"\nAuthor ID: "+authorId+"\nEnd of Month: "+endOfMonth+"\nDollar Amount: "+dollarAmt+
			   "\nPaid Out: "+paidOut+"\nPaid Date: "+paidDate+"\nTransaction ID: "+transactionId;	
	}
	public void setViteAuthor(VitePublishingAuthor viteAuthor) {
		this.viteAuthor = viteAuthor;
	}
	
	
}
