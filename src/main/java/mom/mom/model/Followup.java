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
import javax.persistence.Lob;
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
@Table(name = "followup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f")
    , @NamedQuery(name = "Followup.findById", query = "SELECT f FROM Followup f WHERE f.id = :id")
    , @NamedQuery(name = "Followup.findByName", query = "SELECT f FROM Followup f WHERE f.name = :name")
    , @NamedQuery(name = "Followup.findByTargetdate", query = "SELECT f FROM Followup f WHERE f.targetdate = :targetdate")})
public class Followup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "targetdate")
    @Temporal(TemporalType.DATE)
    private Date targetdate;
//    @Basic(optional = false)
//    @NotNull
    @Lob
//    @Size(min = 1, max = 65535)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "pic", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee pic;
    @JoinColumn(name = "mom", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mom mom;

    public Followup() {
    }

    public Followup(Integer id) {
        this.id = id;
    }

    public Followup(Integer id, String name, Date targetdate, String notes) {
        this.id = id;
        this.name = name;
        this.targetdate = targetdate;
        this.notes = notes;
    }

    public Followup(Integer id, String name, Date targetdate, String notes, Employee pic, Mom mom) {
        this.id = id;
        this.name = name;
        this.targetdate = targetdate;
        this.notes = notes;
        this.pic = pic;
        this.mom = mom;
    }

    public Followup(String name, Date targetdate, String notes, Employee pic, Mom mom) {
        this.name = name;
        this.targetdate = targetdate;
        this.notes = notes;
        this.pic = pic;
        this.mom = mom;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTargetdate() {
        return targetdate;
    }

    public void setTargetdate(Date targetdate) {
        this.targetdate = targetdate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
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
        if (!(object instanceof Followup)) {
            return false;
        }
        Followup other = (Followup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Followup[ id=" + id + " ]";
    }
    
}
