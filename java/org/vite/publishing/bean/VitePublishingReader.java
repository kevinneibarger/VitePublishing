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
import javax.persistence.Table;

/**
 * @author Kevin Neibarger
 *
 */
@Entity
@Table (name = "v_r_reader")
public class VitePublishingReader  implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long readerId;
	private String facebookId;
	private String emailAddr;
	private String firstName;
	private String lastName;
	private Timestamp lastLogin;
	private String ipAddress;
	private String deviceType;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "READER_ID", unique = true, nullable = false)
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	
	@Column(name = "FACEBOOK_ID", unique = true, nullable = false)
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	@Column(name = "EMAIL_ADDR", unique = true, nullable = false, length = 250)
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	@Column(name = "FIRST_NAME", unique = true, nullable = false, length = 100)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME", unique = true, nullable = false, length = 100)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "LAST_LOGIN", unique = true, nullable = false)
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Column(name = "IP_ADDRESS", unique = true, nullable = false, length = 50)
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAdress) {
		this.ipAddress = ipAdress;
	}
	
	@Column(name = "DEVICE_TYPE", unique = true, nullable = false, length = 50)
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String toString() {	
		return "Facebook ID: "+facebookId+"\nEmail Address: "+emailAddr+"\nFirst Name: "
		+firstName+"\nLast Name: "+lastName+"\nLast Login: "+lastLogin+"\nIP Address: "
		+ipAddress+"\nDevice Type: "+deviceType;
	}

}
