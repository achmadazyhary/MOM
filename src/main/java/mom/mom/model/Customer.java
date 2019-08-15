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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByPic", query = "SELECT c FROM Customer c WHERE c.pic = :pic")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "pic")
    private String pic;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Customermeeting> customermeetingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Meeting> meetingList;
    @JoinColumn(name = "province", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Province province;
    @JoinColumn(name = "district", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private District district;
    @JoinColumn(name = "subdistrict", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdistrict subdistrict;
    @JoinColumn(name = "urbanvillage", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Urbanvillage urbanvillage;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String name, String pic, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(Integer id, String name, String pic, String phone, String email, String address, Province province, District district, Subdistrict subdistrict, Urbanvillage urbanvillage) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.province = province;
        this.district = district;
        this.subdistrict = subdistrict;
        this.urbanvillage = urbanvillage;
    }

    public Customer(String name, String pic, String phone, String email, String address, Province province, District district, Subdistrict subdistrict, Urbanvillage urbanvillage) {
        this.name = name;
        this.pic = pic;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.province = province;
        this.district = district;
        this.subdistrict = subdistrict;
        this.urbanvillage = urbanvillage;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Customermeeting> getCustomermeetingList() {
        return customermeetingList;
    }

    public void setCustomermeetingList(List<Customermeeting> customermeetingList) {
        this.customermeetingList = customermeetingList;
    }

    @XmlTransient
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Subdistrict getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(Subdistrict subdistrict) {
        this.subdistrict = subdistrict;
    }

    public Urbanvillage getUrbanvillage() {
        return urbanvillage;
    }

    public void setUrbanvillage(Urbanvillage urbanvillage) {
        this.urbanvillage = urbanvillage;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Customer[ id=" + id + " ]";
    }
    
}
