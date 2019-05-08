package com.capgemini.onetomanyjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certificate {
	@Id
	private int certificateId;
	private String description;

	 /*
				 * (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
				 * 
				 * @JoinColumn(name = "personId")
				 */
	@ManyToOne
	private Person person;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(int certificateId, String description) {
		super();
		this.certificateId = certificateId;
		this.description = description;
	}

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public Person getPerson() { return person; }
	 */

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", description=" + description + ", person=" + person
				+ "]";
	}

}
