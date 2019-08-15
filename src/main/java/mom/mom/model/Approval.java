/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approval.findAll", query = "SELECT a FROM Approval a")
    , @NamedQuery(name = "Approval.findById", query = "SELECT a FROM Approval a WHERE a.id = :id")
    , @NamedQuery(name = "Approval.findByDateby", query = "SELECT a FROM Approval a WHERE a.dateby = :dateby")
    , @NamedQuery(name = "Approval.findByNoteby", query = "SELECT a FROM Approval a WHERE a.noteby = :noteby")})
public class Approval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "dateby")
    @Temporal(TemporalType.DATE)
    private Date dateby;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "noteby")
    private String noteby;
    @JoinColumn(name = "actionby", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee actionby;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
    @JoinColumn(name = "mom", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mom mom;

    public Approval() {
    }

    public Approval(Integer id) {
        this.id = id;
    }

    public Approval(Integer id, Date dateby, String noteby) {
        this.id = id;
        this.dateby = dateby;
        this.noteby = noteby;
    }

    public Approval(Integer id, Date dateby, String noteby, Employee actionby, Status status, Mom mom) {
        this.id = id;
        this.dateby = dateby;
        this.noteby = noteby;
        this.actionby = actionby;
        this.status = status;
        this.mom = mom;
    }

    public Approval(Date dateby, String noteby, Employee actionby, Status status, Mom mom) {
        this.dateby = dateby;
        this.noteby = noteby;
        this.actionby = actionby;
        this.status = status;
        this.mom = mom;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateby() {
        return dateby;
    }

    public void setDateby(Date dateby) {
        this.dateby = dateby;
    }

    public String getNoteby() {
        return noteby;
    }

    public void setNoteby(String noteby) {
        this.noteby = noteby;
    }

    public Employee getActionby() {
        return actionby;
    }

    public void setActionby(Employee actionby) {
        this.actionby = actionby;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Mom getMom() {
        return mom;
    }

    public void setMom(Mom mom) {
        this.mom = mom;
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
        if (!(object instanceof Approval)) {
            return false;
        }
        Approval other = (Approval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Approval[ id=" + id + " ]";
    }
    
}
