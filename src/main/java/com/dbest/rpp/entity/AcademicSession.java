/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "academic_session")
@NamedQueries({
    @NamedQuery(name = "AcademicSession.findAll", query = "SELECT a FROM AcademicSession a"),
    @NamedQuery(name = "AcademicSession.findById", query = "SELECT a FROM AcademicSession a WHERE a.id = :id"),
    @NamedQuery(name = "AcademicSession.findBySession", query = "SELECT a FROM AcademicSession a WHERE a.session = :session"),
    @NamedQuery(name = "AcademicSession.findByDateCreated", query = "SELECT a FROM AcademicSession a WHERE a.dateCreated = :dateCreated"),
    @NamedQuery(name = "AcademicSession.findByLastModified", query = "SELECT a FROM AcademicSession a WHERE a.lastModified = :lastModified")})
public class AcademicSession implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "session")
    private String session;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<EntryYear> entryYearList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
 

    public AcademicSession() {
    }

    public AcademicSession(Integer id) {
        this.id = id;
    }

    public AcademicSession(Integer id, String session, Date dateCreated) {
        this.id = id;
        this.session = session;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicSession)) {
            return false;
        }
        AcademicSession other = (AcademicSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.AcademicSession[ id=" + id + " ]";
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @XmlTransient
    public List<EntryYear> getEntryYearList() {
        return entryYearList;
    }

    public void setEntryYearList(List<EntryYear> entryYearList) {
        this.entryYearList = entryYearList;
    }
    
}
