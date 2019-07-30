package com.parkson.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author laxmareddy
 *
 */

@Entity
@Table(name = "MF11_M_COMPMAST")
public class CompanyMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Not Null")
	@Size(max = 3, message = "Max Lenght 3")
	@Column(name = "mf11_compCode", length = 3, nullable = false, unique = true)
	private String compCode;

	@NotNull(message = "Not Null")
	@Size(max = 3, message = "Max Lenght 3")
	@Column(name = "mf11_compCodeHRIS", length = 3, nullable = false, unique = true)
	private String compCodeHRIS;

	@Size(max = 70)
	@Column(name = "mf11_compName", length = 70)
	private String compName;

	@Size(max = 15)
	@Column(name = "mf11_compAbbrName", length = 15)
	private String compAbbrName;

	@Size(max = 20)
	@Column(name = "mf11_compRegNo", length = 20)
	private String compRegNo;

	@Size(max = 255)
	@Column(name = "mf11_compLogo")
	private String compLogo;

	@Column(name = "mf11_compActiveDate")
	private Date compActiveDate;

	@NotNull
	@Column(name = "mf11_isActive", nullable = false)
	private Boolean isActive;

	@NotNull
	@Column(name = "mf11_createdOn", nullable = false)
	private Date createdOn;

	@Size(max = 255)
	@NotNull
	@Column(name = "mf11_createdBy", nullable = false)
	private String createdBy;

	@NotNull
	@Column(name = "mf11_lastModifiedOn", nullable = false)
	private Date lastModifedOn;

	@Size(max = 255)
	@NotNull
	@Column(name = "mf11_lastModifiedBy", nullable = false)
	private String lastModifedBy;

	@Size(max = 255)
	@Column(name = "mf11_deactivatedBy")
	private String deactivatedBy;

	@Column(name = "mf11_deactivatedOn")
	private Date deactivatedOn;

	@Size(max = 255)
	@Column(name = "mf11_reactivatedBy")
	private String reactivatedBy;

	@Column(name = "mf11_reactivatedOn")
	private Date reactivatedOn;

	@PrePersist
	protected void onCreate() {
		this.createdOn = new Date();
		this.lastModifedOn = new Date();
		this.isActive = true;
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastModifedOn = new Date();
	}

	public String getCompCode() {
		return compCode;
	}

	public CompanyMaster compCode(String compCode) {
		this.compCode = compCode;
		return this;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getCompCodeHRIS() {
		return compCodeHRIS;
	}

	public CompanyMaster compCodeHRIS(String compCodeHRIS) {
		this.compCodeHRIS = compCodeHRIS;
		return this;
	}

	public void setCompCodeHRIS(String compCodeHRIS) {
		this.compCodeHRIS = compCodeHRIS;
	}

	public String getCompName() {
		return compName;
	}

	public CompanyMaster compName(String compName) {
		this.compName = compName;
		return this;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAbbrName() {
		return compAbbrName;
	}

	public CompanyMaster compAbbrName(String compAbbrName) {
		this.compAbbrName = compAbbrName;
		return this;
	}

	public void setCompAbbrName(String compAbbrName) {
		this.compAbbrName = compAbbrName;
	}

	public String getCompRegNo() {
		return compRegNo;
	}

	public CompanyMaster compRegNo(String compRegNo) {
		this.compRegNo = compRegNo;
		return this;
	}

	public void setCompRegNo(String compRegNo) {
		this.compRegNo = compRegNo;
	}

	public String getCompLogo() {
		return compLogo;
	}

	public CompanyMaster compLogo(String compLogo) {
		this.compLogo = compLogo;
		return this;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	public Date getCompActiveDate() {
		return this.compActiveDate;
	}

	public CompanyMaster compActiveDate(Date compActiveDate) {
		this.compActiveDate = compActiveDate;
		return this;
	}

	public void setCompActiveDate(Date compActiveDate) {
		this.compActiveDate = compActiveDate;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public CompanyMaster createdOn(Date createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public CompanyMaster createdBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifedOn() {
		return lastModifedOn;
	}

	public CompanyMaster lastModifedOn(Date lastModifedOn) {
		this.lastModifedOn = lastModifedOn;
		return this;
	}

	public void setLastModifedOn(Date lastModifedOn) {
		this.lastModifedOn = lastModifedOn;
	}

	public String getLastModifedBy() {
		return lastModifedBy;
	}

	public CompanyMaster lastModifedBy(String lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
		return this;
	}

	public void setLastModifedBy(String lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
	}

	public String getDeactivatedBy() {
		return deactivatedBy;
	}

	public CompanyMaster deactivatedBy(String deactivatedBy) {
		this.deactivatedBy = deactivatedBy;
		return this;
	}

	public void setDeactivatedBy(String deactivatedBy) {
		this.deactivatedBy = deactivatedBy;
	}

	public Date getDeactivatedOn() {
		return deactivatedOn;
	}

	public CompanyMaster deactivatedOn(Date deactivatedOn) {
		this.deactivatedOn = deactivatedOn;
		return this;
	}

	public void setDeactivatedOn(Date deactivatedOn) {
		this.deactivatedOn = deactivatedOn;
	}

	public String getReactivatedBy() {
		return reactivatedBy;
	}

	public CompanyMaster reactivatedBy(String reactivatedBy) {
		this.reactivatedBy = reactivatedBy;
		return this;
	}

	public void setReactivatedBy(String reactivatedBy) {
		this.reactivatedBy = reactivatedBy;
	}

	public Date getReactivatedOn() {
		return reactivatedOn;
	}

	public CompanyMaster reactivatedOn(Date reactivatedOn) {
		this.reactivatedOn = reactivatedOn;
		return this;
	}

	public void setReactivatedOn(Date reactivatedOn) {
		this.reactivatedOn = reactivatedOn;
	}

	@Override
	public String toString() {
		return "{\"CompanyMaster\":{" + "                        \"compCode\":\"" + compCode + "\""
				+ ",                        \"compCodeHRIS\":\"" + compCodeHRIS + "\""
				+ ",                        \"compName\":\"" + compName + "\""
				+ ",                        \"compAbbrName\":\"" + compAbbrName + "\""
				+ ",                        \"compRegNo\":\"" + compRegNo + "\""
				+ ",                        \"compLogo\":\"" + compLogo + "\""
				+ ",                        \"compActiveDate\":" + compActiveDate
				+ ",                        \"isActive\":\"" + isActive + "\""
				+ ",                        \"createdOn\":" + createdOn + ",                        \"createdBy\":\""
				+ createdBy + "\"" + ",                        \"lastModifedOn\":" + lastModifedOn
				+ ",                        \"lastModifedBy\":\"" + lastModifedBy + "\""
				+ ",                        \"deactivatedBy\":\"" + deactivatedBy + "\""
				+ ",                        \"deactivatedOn\":" + deactivatedOn
				+ ",                        \"reactivatedBy\":\"" + reactivatedBy + "\""
				+ ",                        \"reactivatedOn\":" + reactivatedOn + "}}";
	}
}
