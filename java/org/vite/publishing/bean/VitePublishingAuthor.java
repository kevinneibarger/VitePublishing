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
@Table (name = "v_a_author")
public class VitePublishingAuthor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long authorId;
	private String facebookId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private Timestamp lastLogin;
	private String photoUrl;
	private String authorBio;
	private String paymentType;
	private String paymentUser;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AUTHOR_ID", unique = true, nullable = false)
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "FACEBOOK_ID", unique = true, nullable = false, length = 50)
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	@Column(name = "EMAIL_ADDR", unique = true, nullable = false, length = 250)
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(name = "FIRST_NAME", unique = true, nullable = false, length = 250)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME", unique = true, nullable = false, length = 250)
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
	
	@Column(name = "PHOTO_URL", unique = true, nullable = false, length = 250)
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Column(name = "AUTHOR_BIO", unique = true, nullable = false, length = 10)
	public String getAuthorBio() {
		return authorBio;
	}
	public void setAuthorBio(String authorBio) {
		this.authorBio = authorBio;
	}
	
	@Column(name = "PAYMENT_TYPE", unique = true, nullable = false, length = 50)
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "PAYMENT_USER", unique = true, nullable = false, length = 250)
	public String getPaymentUser() {
		return paymentUser;
	}
	public void setPaymentUser(String paymentUser) {
		this.paymentUser = paymentUser;
	}
	
	public String toString() {
		
		return "Author ID: "+authorId+"\nFacebook ID: "+facebookId+"\nEmail Address: "+emailAddress+
			   "\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nLast Login: "+lastLogin+
			   "\nPhoto: "+photoUrl+"\nAuthor BIO: "+authorBio+"\nPayment Type: "+paymentType+
			   "\nPayment User: "+paymentUser;
	}
}
