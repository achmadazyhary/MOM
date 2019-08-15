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
@Table(name = "subdistrict")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdistrict.findAll", query = "SELECT s FROM Subdistrict s")
    , @NamedQuery(name = "Subdistrict.findById", query = "SELECT s FROM Subdistrict s WHERE s.id = :id")
    , @NamedQuery(name = "Subdistrict.findByName", query = "SELECT s FROM Subdistrict s WHERE s.name = :name")})
public class Subdistrict implements Serializable {

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
    @JoinColumn(name = "district", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private District district;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdistrict", fetch = FetchType.LAZY)
    private List<Customer> customerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdistrict", fetch = FetchType.LAZY)
    private List<Urbanvillage> urbanvillageList;

    public Subdistrict() {
    }

    public Subdistrict(Integer id) {
        this.id = id;
    }

    public Subdistrict(Integer id, String name, District district) {
        this.id = id;
        this.name = name;
        this.district = district;
    }

    public Subdistrict(String name, District district) {
        this.name = name;
        this.district = district;
    }
    
    

    public Subdistrict(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<Urbanvillage> getUrbanvillageList() {
        return urbanvillageList;
    }

    public void setUrbanvillageList(List<Urbanvillage> urbanvillageList) {
        this.urbanvillageList = urbanvillageList;
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
        if (!(object instanceof Subdistrict)) {
            return false;
        }
        Subdistrict other = (Subdistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Subdistrict[ id=" + id + " ]";
    }
    
}
