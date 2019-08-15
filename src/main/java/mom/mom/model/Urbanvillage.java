/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "urbanvillage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urbanvillage.findAll", query = "SELECT u FROM Urbanvillage u")
    , @NamedQuery(name = "Urbanvillage.findById", query = "SELECT u FROM Urbanvillage u WHERE u.id = :id")
    , @NamedQuery(name = "Urbanvillage.findByName", query = "SELECT u FROM Urbanvillage u WHERE u.name = :name")
    , @NamedQuery(name = "Urbanvillage.findByPostalcode", query = "SELECT u FROM Urbanvillage u WHERE u.postalcode = :postalcode")})
public class Urbanvillage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 7)
    @Column(name = "postalcode")
    private String postalcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urbanvillage", fetch = FetchType.LAZY)
    private List<Customer> customerList;
    @JoinColumn(name = "subdistrict", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdistrict subdistrict;

    public Urbanvillage() {
    }

    public Urbanvillage(Integer id) {
        this.id = id;
    }

    public Urbanvillage(Integer id, String name, String postalcode) {
        this.id = id;
        this.name = name;
        this.postalcode = postalcode;
    }

    public Urbanvillage(String name, String postalcode, Subdistrict subdistrict) {
        this.name = name;
        this.postalcode = postalcode;
        this.subdistrict = subdistrict;
    }

    public Urbanvillage(Integer id, String name, String postalcode, Subdistrict subdistrict) {
        this.id = id;
        this.name = name;
        this.postalcode = postalcode;
        this.subdistrict = subdistrict;
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

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Subdistrict getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(Subdistrict subdistrict) {
        this.subdistrict = subdistrict;
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
        if (!(object instanceof Urbanvillage)) {
            return false;
        }
        Urbanvillage other = (Urbanvillage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Urbanvillage[ id=" + id + " ]";
    }
    
}
