package com.capgemini.onetomany.certificates;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.capgemini.onetomany.employee.Employee;

@Entity
public class Certificates {
	
	@Id
	private int CertificateId;
	private String CertificateName;
	@ManyToOne
	@JoinColumn(name = "EmployeeId")
	private Employee employee;
	public Certificates() {
		super();
	}
	
	public Certificates(int certificateId, String certificateName) {
		super();
		CertificateId = certificateId;
		CertificateName = certificateName;
	
	}
	
	public int getCertificateId() {
		return CertificateId;
	}
	
	public void setCertificateId(int certificateId) {
		CertificateId = certificateId;
	}
	
	public String getCertificateName() {
		return CertificateName;
	}
	
	public void setCertificateName(String certificateName) {
		CertificateName = certificateName;
	}

//	public Employee getEmployee() {
//		return employee;
//	}
//	
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	@Override
	public String toString() {
		return "Certificates [CertificateId=" + CertificateId + ", CertificateName=" + CertificateName + "]";
	}
	
	

}
