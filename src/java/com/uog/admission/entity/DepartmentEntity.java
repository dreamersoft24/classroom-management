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
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentEntity.findAll", query = "SELECT d FROM DepartmentEntity d"),
    @NamedQuery(name = "DepartmentEntity.findByDepartmentId", query = "SELECT d FROM DepartmentEntity d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "DepartmentEntity.findByDepartmentName", query = "SELECT d FROM DepartmentEntity d WHERE d.departmentName = :departmentName")})
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "department_id")
    private Integer departmentId;
    @Size(max = 45)
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentDepartmentId")
    private List<UserEntity> userEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentDepartmentId")
    private List<TokenEntity> tokenEntityList;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    @XmlTransient
    public List<TokenEntity> getTokenEntityList() {
        return tokenEntityList;
    }

    public void setTokenEntityList(List<TokenEntity> tokenEntityList) {
        this.tokenEntityList = tokenEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentEntity)) {
            return false;
        }
        DepartmentEntity other = (DepartmentEntity) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.admission.entity.DepartmentEntity[ departmentId=" + departmentId + " ]";
    }
    
}
