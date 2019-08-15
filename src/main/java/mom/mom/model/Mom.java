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
import javax.persistence.Lob;
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
@Table(name = "mom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mom.findAll", query = "SELECT m FROM Mom m")
    , @NamedQuery(name = "Mom.findById", query = "SELECT m FROM Mom m WHERE m.id = :id")})
public class Mom implements Serializable {



    @JoinColumn(name = "pic", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee pic;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
    @Lob
//    @Size(min = 1, max = 65535)
    @Column(name = "meetingdesc")
    private String meetingdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mom", fetch = FetchType.LAZY)
    private List<Approval> approvalList;
    @JoinColumn(name = "meeting", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Meeting meeting;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mom", fetch = FetchType.LAZY)
    private List<Followup> followupList;

    public Mom() {
    }

    public Mom(Integer id) {
        this.id = id;
    }

    public Mom(Integer id, String meetingdesc) {
        this.id = id;
        this.meetingdesc = meetingdesc;
    }

    public Mom(Employee pic) {
        this.pic = pic;
    }

    public Mom( Integer id, String meetingdesc, Meeting meeting, Status status, Employee pic) {
        this.pic = pic;
        this.id = id;
        this.meetingdesc = meetingdesc;
        this.meeting = meeting;
        this.status = status;
    }

    public Mom(String meetingdesc, Meeting meeting, Status status, Employee pic) {
        this.pic = pic;
        this.meetingdesc = meetingdesc;
        this.meeting = meeting;
        this.status = status;
    }

    

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeetingdesc() {
        return meetingdesc;
    }

    public void setMeetingdesc(String meetingdesc) {
        this.meetingdesc = meetingdesc;
    }

    @XmlTransient
    public List<Approval> getApprovalList() {
        return approvalList;
    }

    public void setApprovalList(List<Approval> approvalList) {
        this.approvalList = approvalList;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlTransient
    public List<Followup> getFollowupList() {
        return followupList;
    }

    public void setFollowupList(List<Followup> followupList) {
        this.followupList = followupList;
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
        if (!(object instanceof Mom)) {
            return false;
        }
        Mom other = (Mom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mom.mom.model.Mom[ id=" + id + " ]";
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
    }

    
}
