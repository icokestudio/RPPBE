/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "grade_scale")
@NamedQueries({
    @NamedQuery(name = "GradeScale.findAll", query = "SELECT g FROM GradeScale g"),
    @NamedQuery(name = "GradeScale.findById", query = "SELECT g FROM GradeScale g WHERE g.id = :id"),
    @NamedQuery(name = "GradeScale.findByName", query = "SELECT g FROM GradeScale g WHERE g.name = :name"),
    @NamedQuery(name = "GradeScale.findByDateCreated", query = "SELECT g FROM GradeScale g WHERE g.dateCreated = :dateCreated"),
    @NamedQuery(name = "GradeScale.findByLastModified", query = "SELECT g FROM GradeScale g WHERE g.lastModified = :lastModified")})
public class GradeScale implements Serializable {

    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "date_created")
    private String dateCreated;
    @Size(max = 45)
    @Column(name = "last_modified")
    private String lastModified;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradeScale")
    private List<EntryYear> entryYearList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradeScale",fetch=FetchType.EAGER)
    private Set<Grade> gradeList;

    public GradeScale() {
    }

    public GradeScale(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public List<EntryYear> getEntryYearList() {
        return entryYearList;
    }

    public void setEntryYearList(List<EntryYear> entryYearList) {
        this.entryYearList = entryYearList;
    }

    public Set<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(Set<Grade> gradeList) {
        this.gradeList = gradeList;
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
        if (!(object instanceof GradeScale)) {
            return false;
        }
        GradeScale other = (GradeScale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.GradeScale[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
