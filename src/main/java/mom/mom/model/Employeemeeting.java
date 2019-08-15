/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "employeemeeting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeemeeting.findAll", query = "SELECT e FROM Employeemeeting e")
    , @NamedQuery(name = "Employeemeeting.findById", query = "SELECT e FROM Employeemeeting e WHERE e.id = :id")})
public class Employeemeeting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "meeting", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Meeting meeting;

    public Employeemeeting() {
    }

    public Employeemeeting(Integer id) {
        this.id = id;
    }

    public Employeemeeting(Integer id, Employee employee, Meeting meeting) {
        this.id = id;
        this.employee = employee;
        this.meeting = meeting;
    }

    public Employeemeeting(Employee employee, Meeting meeting) {
        this.employee = employee;
        this.meeting = meeting;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
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
        if (!(object instanceof Employeemeeting)) {
            return false;
        }
        Employeemeeting other = (Employeemeeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Employeemeeting[ id=" + id + " ]";
    }
    
}
