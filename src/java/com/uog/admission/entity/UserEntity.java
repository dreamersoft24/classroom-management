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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserEntity.findByUserName", query = "SELECT u FROM UserEntity u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserEntity.findByUserDesignation", query = "SELECT u FROM UserEntity u WHERE u.userDesignation = :userDesignation"),
    @NamedQuery(name = "UserEntity.findByUserPhone", query = "SELECT u FROM UserEntity u WHERE u.userPhone = :userPhone"),
    @NamedQuery(name = "UserEntity.findByUserPasword", query = "SELECT u FROM UserEntity u WHERE u.userPasword = :userPasword")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 45)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 45)
    @Column(name = "user_designation")
    private String userDesignation;
    @Size(max = 45)
    @Column(name = "user_phone")
    private String userPhone;
    @Size(max = 45)
    @Column(name = "user_pasword")
    private String userPasword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserId")
    private List<TokenProcessingEntity> tokenProcessingEntityList;
    @JoinColumn(name = "department_department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private DepartmentEntity departmentDepartmentId;

    public UserEntity() {
    }

    public UserEntity(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPasword() {
        return userPasword;
    }

    public void setUserPasword(String userPasword) {
        this.userPasword = userPasword;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.admission.entity.UserEntity[ userId=" + userId + " ]";
    }
    
}
