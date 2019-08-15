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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")})
public class Employee implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pic", fetch = FetchType.LAZY)
    private List<Mom> momList;

//    @Basic(optional = false)
//    @NotNull
    @Column(name = "isactive")
    private boolean isactive;

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
//    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
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
//    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actionby", fetch = FetchType.LAZY)
    private List<Approval> approvalList;
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Employeemeeting> employeemeetingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pic", fetch = FetchType.LAZY)
    private List<Followup> followupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pic", fetch = FetchType.LAZY)
    private List<Meeting> meetingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Meeting> meetingList1;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String name, String lastname, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Employee(Integer id, String name, String lastname, String phone, String email, String password, Role role, boolean isactive) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isactive = isactive;
    }

    public Employee(String name, String lastname, String phone, String email, String password, Role role, boolean isactive) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isactive = isactive;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Approval> getApprovalList() {
        return approvalList;
    }

    public void setApprovalList(List<Approval> approvalList) {
        this.approvalList = approvalList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @XmlTransient
    public List<Employeemeeting> getEmployeemeetingList() {
        return employeemeetingList;
    }

    public void setEmployeemeetingList(List<Employeemeeting> employeemeetingList) {
        this.employeemeetingList = employeemeetingList;
    }

    @XmlTransient
    public List<Followup> getFollowupList() {
        return followupList;
    }

    public void setFollowupList(List<Followup> followupList) {
        this.followupList = followupList;
    }

    @XmlTransient
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    @XmlTransient
    public List<Meeting> getMeetingList1() {
        return meetingList1;
    }

    public void setMeetingList1(List<Meeting> meetingList1) {
        this.meetingList1 = meetingList1;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Employee[ id=" + id + " ]";
    }

    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Mom> getMomList() {
        return momList;
    }

    public void setMomList(List<Mom> momList) {
        this.momList = momList;
    }
    
}
