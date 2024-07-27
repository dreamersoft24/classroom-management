/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.admission.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ammar
 */
@Entity
@Table(name = "token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TokenEntity.findAll", query = "SELECT t FROM TokenEntity t"),
    @NamedQuery(name = "TokenEntity.findByTokenId", query = "SELECT t FROM TokenEntity t WHERE t.tokenId = :tokenId"),
    @NamedQuery(name = "TokenEntity.findByApplicationNumber", query = "SELECT t FROM TokenEntity t WHERE t.applicationNumber = :applicationNumber"),
    @NamedQuery(name = "TokenEntity.findByStudentName", query = "SELECT t FROM TokenEntity t WHERE t.studentName = :studentName"),
    @NamedQuery(name = "TokenEntity.findByStudentContact", query = "SELECT t FROM TokenEntity t WHERE t.studentContact = :studentContact"),
    @NamedQuery(name = "TokenEntity.findByTokenDate", query = "SELECT t FROM TokenEntity t WHERE t.tokenDate = :tokenDate"),
    @NamedQuery(name = "TokenEntity.findByTokenStatus", query = "SELECT t FROM TokenEntity t WHERE t.tokenStatus = :tokenStatus"),
    @NamedQuery(name = "TokenEntity.findByTokenNumber", query = "SELECT t FROM TokenEntity t WHERE t.tokenNumber = :tokenNumber")})
public class TokenEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "token_id")
    private Integer tokenId;
    @Size(max = 45)
    @Column(name = "application_number")
    private String applicationNumber;
    @Size(max = 45)
    @Column(name = "student_name")
    private String studentName;
    @Size(max = 45)
    @Column(name = "student_contact")
    private String studentContact;
    @Size(max = 45)
    @Column(name = "token_date")
    private String tokenDate;
    @Size(max = 45)
    @Column(name = "token_status")
    private String tokenStatus;
    @Size(max = 45)
    @Column(name = "token_number")
    private String tokenNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tokenTokenId")
    private List<TokenProcessingEntity> tokenProcessingEntityList;
    @JoinColumn(name = "department_department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private DepartmentEntity departmentDepartmentId;

    public TokenEntity() {
    }

    public TokenEntity(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(String tokenDate) {
        this.tokenDate = tokenDate;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    @XmlTransient
    public List<TokenProcessingEntity> getTokenProcessingEntityList() {
        return tokenProcessingEntityList;
    }

    public void setTokenProcessingEntityList(List<TokenProcessingEntity> tokenProcessingEntityList) {
        this.tokenProcessingEntityList = tokenProcessingEntityList;
    }

    public DepartmentEntity getDepartmentDepartmentId() {
        return departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(DepartmentEntity departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenId != null ? tokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TokenEntity)) {
            return false;
        }
        TokenEntity other = (TokenEntity) object;
        if ((this.tokenId == null && other.tokenId != null) || (this.tokenId != null && !this.tokenId.equals(other.tokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.admission.entity.TokenEntity[ tokenId=" + tokenId + " ]";
    }
    
}
