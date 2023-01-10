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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "current_session")
@NamedQueries({
    @NamedQuery(name = "CurrentSession.findAll", query = "SELECT c FROM CurrentSession c"),
    @NamedQuery(name = "CurrentSession.findById", query = "SELECT c FROM CurrentSession c WHERE c.id = :id"),
    @NamedQuery(name = "CurrentSession.findByResultOpeningDate", query = "SELECT c FROM CurrentSession c WHERE c.resultOpeningDate = :resultOpeningDate"),
    @NamedQuery(name = "CurrentSession.findByResultClosingDate", query = "SELECT c FROM CurrentSession c WHERE c.resultClosingDate = :resultClosingDate"),
    @NamedQuery(name = "CurrentSession.findByDateCreated", query = "SELECT c FROM CurrentSession c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "CurrentSession.findByLastModified", query = "SELECT c FROM CurrentSession c WHERE c.lastModified = :lastModified")})
public class CurrentSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result_opening_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultOpeningDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result_closing_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultClosingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session",fetch=FetchType.EAGER)
    private List<Result> resultList;
    @JoinColumn(name = "session", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcademicSession session;
    @JoinColumn(name = "semester", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Semester semester;

    public CurrentSession() {
    }

    public CurrentSession(Integer id) {
        this.id = id;
    }

    public CurrentSession(Integer id, Date resultOpeningDate, Date resultClosingDate, Date dateCreated) {
        this.id = id;
        this.resultOpeningDate = resultOpeningDate;
        this.resultClosingDate = resultClosingDate;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getResultOpeningDate() {
        return resultOpeningDate;
    }

    public void setResultOpeningDate(Date resultOpeningDate) {
        this.resultOpeningDate = resultOpeningDate;
    }

    public Date getResultClosingDate() {
        return resultClosingDate;
    }

    public void setResultClosingDate(Date resultClosingDate) {
        this.resultClosingDate = resultClosingDate;
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


    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public AcademicSession getSession() {
        return session;
    }

    public void setSession(AcademicSession session) {
        this.session = session;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
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
        if (!(object instanceof CurrentSession)) {
            return false;
        }
        CurrentSession other = (CurrentSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.CurrentSession[ id=" + id + " ]";
    }
    
}
