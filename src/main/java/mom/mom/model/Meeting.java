/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "meeting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meeting.findAll", query = "SELECT m FROM Meeting m")
    , @NamedQuery(name = "Meeting.findById", query = "SELECT m FROM Meeting m WHERE m.id = :id")
    , @NamedQuery(name = "Meeting.findByName", query = "SELECT m FROM Meeting m WHERE m.name = :name")
    , @NamedQuery(name = "Meeting.findByProject", query = "SELECT m FROM Meeting m WHERE m.project = :project")
    , @NamedQuery(name = "Meeting.findByDate", query = "SELECT m FROM Meeting m WHERE m.date = :date")
    , @NamedQuery(name = "Meeting.findByTime", query = "SELECT m FROM Meeting m WHERE m.time = :time")
    , @NamedQuery(name = "Meeting.findByType", query = "SELECT m FROM Meeting m WHERE m.type = :type")})
public class Meeting implements Serializable {

//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "location")
    private String location;

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
//    @Size(min = 1, max = 50)
    @Column(name = "project")
    private String project;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
    @Column(name = "time")
    private String time;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Mom> momList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Employeemeeting> employeemeetingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Customermeeting> customermeetingList;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "pic", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee pic;
    @JoinColumn(name = "manager", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee manager;
    @JoinColumn(name = "activation", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Activation activation;

    public Meeting() {
    }

    public Meeting(Integer id) {
        this.id = id;
    }

    public Meeting(String location, Integer id, String name, String project, Date date, String time, String type, Customer customer, Employee pic, Employee manager, Activation activation) {
        this.location = location;
        this.id = id;
        this.name = name;
        this.project = project;
        this.date = date;
        this.time = time;
        this.type = type;
        this.customer = customer;
        this.pic = pic;
        this.manager = manager;
        this.activation = activation;
    }

    public Meeting(String location, String name, String project, Date date, String time, String type, Customer customer, Employee pic, Employee manager, Activation activation) {
        this.location = location;
        this.name = name;
        this.project = project;
        this.date = date;
        this.time = time;
        this.type = type;
        this.customer = customer;
        this.pic = pic;
        this.manager = manager;
        this.activation = activation;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Mom> getMomList() {
        return momList;
    }

    public void setMomList(List<Mom> momList) {
        this.momList = momList;
    }

    @XmlTransient
    public List<Employeemeeting> getEmployeemeetingList() {
        return employeemeetingList;
    }

    public void setEmployeemeetingList(List<Employeemeeting> employeemeetingList) {
        this.employeemeetingList = employeemeetingList;
    }

    @XmlTransient
    public List<Customermeeting> getCustomermeetingList() {
        return customermeetingList;
    }

    public void setCustomermeetingList(List<Customermeeting> customermeetingList) {
        this.customermeetingList = customermeetingList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
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
        if (!(object instanceof Meeting)) {
            return false;
        }
        Meeting other = (Meeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Meeting[ id=" + id + " ]";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
