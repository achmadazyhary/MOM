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
@Table(name = "customermeeting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customermeeting.findAll", query = "SELECT c FROM Customermeeting c")
    , @NamedQuery(name = "Customermeeting.findById", query = "SELECT c FROM Customermeeting c WHERE c.id = :id")})
public class Customermeeting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "meeting", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Meeting meeting;

    public Customermeeting() {
    }

    public Customermeeting(Integer id) {
        this.id = id;
    }

    public Customermeeting(Integer id, Customer customer, Meeting meeting) {
        this.id = id;
        this.customer = customer;
        this.meeting = meeting;
    }

    public Customermeeting(Customer customer, Meeting meeting) {
        this.customer = customer;
        this.meeting = meeting;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Customermeeting)) {
            return false;
        }
        Customermeeting other = (Customermeeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Customermeeting[ id=" + id + " ]";
    }
    
}
