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
@Table (name = "v_r_login_hist")
public class VitePublishingLoginHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long historyId;
	private long readerId;
	private VitePublishingReader reader;
	private Timestamp loginDate;
	
	public VitePublishingLoginHistory() {}
	
	public VitePublishingLoginHistory(long readerId) {
		this.readerId = readerId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HISTORY_ID", unique = true, nullable = false)
	public long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "READER_ID", referencedColumnName = "READER_ID", insertable = false, updatable = false)
	public VitePublishingReader getReader() {
		return reader;
	}

	public void setReader(VitePublishingReader reader) {
		this.reader = reader;
	}
	
	@Column(name = "READER_ID", unique = true, nullable = false, length = 50)
	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	@Column(name = "LOGIN_DATE")
	public Timestamp getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String toString() {
		return "VR_Login_Hist [history_id=" + historyId + ", reader_id=" + readerId
				+ ", login_date=" + loginDate +" Reader="+reader.toString()+ "]";
	}
}
