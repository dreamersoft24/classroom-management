/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.admission.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ammar
 */
@Entity
@Table(name = "token_processing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TokenProcessingEntity.findAll", query = "SELECT t FROM TokenProcessingEntity t"),
    @NamedQuery(name = "TokenProcessingEntity.findByTokenProcessingId", query = "SELECT t FROM TokenProcessingEntity t WHERE t.tokenProcessingId = :tokenProcessingId"),
    @NamedQuery(name = "TokenProcessingEntity.findByProcessingDate", query = "SELECT t FROM TokenProcessingEntity t WHERE t.processingDate = :processingDate"),
    @NamedQuery(name = "TokenProcessingEntity.findByTokenProcessingStatus", query = "SELECT t FROM TokenProcessingEntity t WHERE t.tokenProcessingStatus = :tokenProcessingStatus")})
public class TokenProcessingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "token_processing_id")
    private Integer tokenProcessingId;
    @Size(max = 45)
    @Column(name = "processing_date")
    private String processingDate;
    @Size(max = 45)
    @Column(name = "token_processing_status")
    private String tokenProcessingStatus;
    @JoinColumn(name = "token_token_id", referencedColumnName = "token_id")
    @ManyToOne(optional = false)
    private TokenEntity tokenTokenId;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserEntity userUserId;

    public TokenProcessingEntity() {
    }

    public TokenProcessingEntity(Integer tokenProcessingId) {
        this.tokenProcessingId = tokenProcessingId;
    }

    public Integer getTokenProcessingId() {
        return tokenProcessingId;
    }

    public void setTokenProcessingId(Integer tokenProcessingId) {
        this.tokenProcessingId = tokenProcessingId;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public String getTokenProcessingStatus() {
        return tokenProcessingStatus;
    }

    public void setTokenProcessingStatus(String tokenProcessingStatus) {
        this.tokenProcessingStatus = tokenProcessingStatus;
    }

    public TokenEntity getTokenTokenId() {
        return tokenTokenId;
    }

    public void setTokenTokenId(TokenEntity tokenTokenId) {
        this.tokenTokenId = tokenTokenId;
    }

    public UserEntity getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(UserEntity userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenProcessingId != null ? tokenProcessingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TokenProcessingEntity)) {
            return false;
        }
        TokenProcessingEntity other = (TokenProcessingEntity) object;
        if ((this.tokenProcessingId == null && other.tokenProcessingId != null) || (this.tokenProcessingId != null && !this.tokenProcessingId.equals(other.tokenProcessingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.admission.entity.TokenProcessingEntity[ tokenProcessingId=" + tokenProcessingId + " ]";
    }
    
}
