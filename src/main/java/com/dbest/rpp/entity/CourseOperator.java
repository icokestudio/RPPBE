/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.entity;

import com.dbest.rpp.util.PasswordHash;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "course_operator")
@NamedQueries({
    @NamedQuery(name = "CourseOperator.findAll", query = "SELECT c FROM CourseOperator c"),
    @NamedQuery(name = "CourseOperator.findById", query = "SELECT c FROM CourseOperator c WHERE c.id = :id"),
    @NamedQuery(name = "CourseOperator.findByStaffId", query = "SELECT c FROM CourseOperator c WHERE c.staffId = :staffId"),
    @NamedQuery(name = "CourseOperator.findByFirstname", query = "SELECT c FROM CourseOperator c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "CourseOperator.findByLastname", query = "SELECT c FROM CourseOperator c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "CourseOperator.findByEmailAddress", query = "SELECT c FROM CourseOperator c WHERE c.emailAddress = :emailAddress"),
    @NamedQuery(name = "CourseOperator.findByPassword", query = "SELECT c FROM CourseOperator c WHERE c.password = :password"),
    @NamedQuery(name = "CourseOperator.findByDateCreated", query = "SELECT c FROM CourseOperator c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "CourseOperator.findByLastModified", query = "SELECT c FROM CourseOperator c WHERE c.lastModified = :lastModified")})
public class CourseOperator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "staff_id")
    private String staffId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_address")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @OneToMany(mappedBy = "operator",fetch = FetchType.EAGER)
    private Set<Course> courseList;
    @Column(name = "is_blocked")
    @NotNull
    private Boolean isBlocked;

    public CourseOperator() {
    }

    public CourseOperator(Integer id) {
        this.id = id;
    }

    public CourseOperator(Integer id, String staffId, String firstname, String lastname, String emailAddress, String password, Date dateCreated) {
        this.id = id;
        this.staffId = staffId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
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
        if (!(object instanceof CourseOperator)) {
            return false;
        }
        CourseOperator other = (CourseOperator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.CourseOperator[ id=" + id + " ]";
    }
    
}
