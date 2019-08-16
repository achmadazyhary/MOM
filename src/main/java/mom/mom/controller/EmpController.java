/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import mom.mom.interfaceserviceimplement.ActivationServiceImplement;
import mom.mom.interfaceserviceimplement.ApprovalServiceImplement;
import mom.mom.interfaceserviceimplement.CustomerServiceImplement;
import mom.mom.interfaceserviceimplement.EmployeeServiceImplement;
import mom.mom.interfaceserviceimplement.EmployeemeetingServiceImplement;
import mom.mom.interfaceserviceimplement.FollowupServiceImplement;
import mom.mom.interfaceserviceimplement.MeetingServiceImplement;
import mom.mom.interfaceserviceimplement.MomServiceImplement;
import mom.mom.interfaceserviceimplement.RoleServiceImplement;
import mom.mom.model.Activation;
import mom.mom.model.Approval;
import mom.mom.model.Customer;
import mom.mom.model.Employee;
import mom.mom.model.Meeting;
import mom.mom.model.Employeemeeting;
import mom.mom.model.Followup;
import mom.mom.model.Mom;
import mom.mom.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Bella
 */
@Controller
public class EmpController {
    
    @Autowired
    public MeetingServiceImplement msi;
    
    @Autowired
    public CustomerServiceImplement csi;
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @Autowired
    public RoleServiceImplement rsi;
    
    @Autowired
    public EmployeemeetingServiceImplement emsi;
    
    @Autowired
    public MomServiceImplement momsi;
    
    @Autowired
    public FollowupServiceImplement fsi;
    
    @Autowired
    public ApprovalServiceImplement asi;
    
    @Autowired
    public ActivationServiceImplement acsi;
    
    @Autowired
    private JavaMailSender javaMailSender;

    public String currentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        return nama;
    }
    
    
    @GetMapping("/headerE")
    public String headerE(Model model){
        model.addAttribute("employee", esi.findByEmail(currentUserName()).getName());
        return "headerE";
    }
    
    @GetMapping("/pic")
    public String pic(Model model){
        model.addAttribute("employee", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("picId", esi.findByEmail(currentUserName()).getId());
        return "pic";
    }
    
    @GetMapping("/manager")
    public String manager(Model model){
        model.addAttribute("employee", esi.findByEmail(currentUserName()).getName());
        return "manager";
    }
    
    @GetMapping("/pic/meetingform")
    public String meetingform(Model model){
        model.addAttribute("meeting", msi.findAll());
        model.addAttribute("customer", csi.findAll());
        model.addAttribute("emp", esi.findAll());
        model.addAttribute("employee", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("picId", esi.findByEmail(currentUserName()).getId());
        return "meetingform";
    }
    

    
    @PostMapping("/pic/meetingform/save")
    public String saveMeeting(@RequestParam(value = "name") String name,
            @RequestParam(value = "project") String project,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "customer") int customer,
            @RequestParam(value = "manager") int manager,
            @RequestParam(value = "pic") int pic,
            @RequestParam(value = "location") String location
            ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int activation = 1;
        Meeting meeting = new Meeting(location, name, project, parsedDate, time,
                type, new Customer(customer), new Employee(pic), new Employee(manager), 
                new Activation(activation));
        msi.save(meeting);

        
        
        return "redirect:/pic/meeting2";
    }
    
    @PostMapping("/pic/meeting/edit")
    public String editMeeting(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "project") String project,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "customer") int customer,
            @RequestParam(value = "manager") int manager,
            @RequestParam(value = "pic") int pic,
            @RequestParam(value = "location") String location
    ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int activation=1;
        Meeting meeting = new Meeting(location, id, name, project, parsedDate, 
                time, type, new Customer(customer), new Employee(pic), 
                new Employee(manager), new Activation(activation));
        msi.save(meeting);
        return "redirect:/pic/meeting2";
    }
    @PostMapping("/pic/meeting/softdelete")
    public String softDeleteMeeting(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "project") String project,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "customer") int customer,
            @RequestParam(value = "manager") int manager,
            @RequestParam(value = "pic") int pic
    ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String active = "nonactive";
//        Meeting meeting = new Meeting(id, name, project, parsedDate, time, type, active, new Customer(customer), new Employee(manager), new Employee(pic));
//        msi.save(meeting);
        return "redirect:/pic/meeting2";
    }
    
    @GetMapping("/pic/meeting2")
    public String meeting2(Model model){
        model.addAttribute("employee", esi.findByEmail(currentUserName()).getName());
        int id = esi.findByEmail(currentUserName()).getId();
        model.addAttribute("meeting", msi.findByPic(id));
        model.addAttribute("customer", csi.findAll());
        model.addAttribute("employeemeeting", emsi.findAll());
        model.addAttribute("emp", esi.findAll());
        return "meeting2";
    }
            
    @PostMapping("/pic/meeting/saveattendees")
    public String saveAttendees(@RequestParam(value = "id") int id,
            @RequestParam(value = "employee") int employee
            ){
        Employeemeeting em = new Employeemeeting(new Employee (employee), new Meeting(id));
        emsi.save(em);
        return "redirect:/pic/meeting2";
    }
    
    @PostMapping("/pic/meeting2/sendmail")
    public String sendEmailToAttendees(@RequestParam(value = "meeting") String meeting,
        @RequestParam(value = "project") String project,
        @RequestParam(value = "name") String name,
        @RequestParam(value = "lastName") String lastName,
        @RequestParam(value = "email") String email,
        @RequestParam(value = "date") String date,
        @RequestParam(value = "time") String time,
        @RequestParam(value = "location") String location,
        @RequestParam(value = "manager") String manager,
        @RequestParam(value = "pic") String pic,
        @RequestParam(value = "picLastName") String picLastName
    ) throws MessagingException{
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(email);
            helper.setSubject("Meeting Invitation - "+meeting);
            helper.setText("Dear "+name+" "+lastName+", you are invited to "
                    + meeting+" that will be held on "+date+ ", at "+time+", in "+
                            location+". This meeting is chaired by "+pic+" "+
                    picLastName+". "+ "Please come ontime. "+""
                            + "Best regards, "+ pic+" "+picLastName);
        javaMailSender.send(msg);
        return "redirect:/pic/meeting2";
    }
    
    
    
    @PostMapping("/pic/meeting2/sendmailcust")
    public String sendEmailToCustomer(@RequestParam(value = "meeting") String meeting,
        @RequestParam(value = "project") String project,
        @RequestParam(value = "date") String date,
        @RequestParam(value = "time") String time,
        @RequestParam(value = "location") String location,
        @RequestParam(value = "type") String type,
        @RequestParam(value = "custCompany") String custCompany,
        @RequestParam(value = "custPic") String custPic,
        @RequestParam(value = "custEmail") String custEmail,
        @RequestParam(value = "manager") String manager,
        @RequestParam(value = "pic") String pic,
        @RequestParam(value = "picLastName") String picLastName
    ) throws MessagingException{
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setTo(custEmail);
            helper.setSubject("Meeting Invitation - "+meeting);
            helper.setText("Dear "+custPic+" from "+custCompany+", you are invited to "
                    + meeting+", for "+project+", that will be held on "+date+ ", at "+time+", in "+
                            location+". This meeting is chaired by "+pic+" "+
                    picLastName+" from PT. Mitra Integrasi Informatika. "+ "Please come ontime. "+""
                            + "Best regards, "+ pic+" "+picLastName);
        javaMailSender.send(msg);
        return "redirect:/meeting2";
    }
    
    
    @GetMapping("/pic/mom")
    public String mom(Model model){
        model.addAttribute("emp", esi.findByEmail(currentUserName()).getName());
        model.addAttribute("picId", esi.findByEmail(currentUserName()).getId());
        model.addAttribute("followup", fsi.findAll());
        
        model.addAttribute("employee", esi.findAll());
        int id = esi.findByEmail(currentUserName()).getId();
        model.addAttribute("mom", momsi.findByPic(id));
        model.addAttribute("meeting", msi.findByPic(id));
        return "mom";
    }

    
    
    @PostMapping("/pic/mom/save")
    public String saveMom(@RequestParam(value = "desc") String meetingdesc,
            @RequestParam(value = "meeting") int meeting,
            @RequestParam(value = "pic") int pic
            ){
        int status = 1;
        Mom mom = new Mom(meetingdesc, new Meeting(meeting), new Status(status), new Employee(pic));
        
               
        momsi.save(mom);
        
        String active = "active";
        
        
        return "redirect:/pic/mom";
    }
    @PostMapping("/pic/mom/edit")
    public String editMom(@RequestParam(value = "id") int id,
            @RequestParam(value = "desc") String meetingdesc,
            @RequestParam(value = "meetingId") int meetingId,
            @RequestParam(value = "statusId") int statusId,
            @RequestParam(value = "pic") int pic
            ){
        Mom mom = new Mom(id, meetingdesc, new Meeting (meetingId), new Status(1), new Employee(pic));
        momsi.save(mom);
        return "redirect:/pic/mom";
    }
    
    @PostMapping("/pic/mom/savefollowup")
    public String saveFollowup(@RequestParam(value = "action") String action,
            @RequestParam(value = "targetdate") String targetdate,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "pic") int pic,
            @RequestParam(value = "momId") int mom
            ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(targetdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Followup followup = new Followup(action, parsedDate, note, new Employee(pic), new Mom(mom));
        fsi.save(followup);
        return "redirect:/pic/mom";
    }
    
    @PostMapping("/pic/mom/sendmail")
    public String sendEmailToManager(@RequestParam(value = "meetingName") String meetingName,
        @RequestParam(value = "picName") String picName,
        @RequestParam(value = "picLastName") String picLastName,
        @RequestParam(value = "managerName") String managerName,
        @RequestParam(value = "managerEmail") String managerEmail,
        @RequestParam(value = "meetingDate") String meetingDate,
        @RequestParam(value = "meetingTime") String meetingTime
    ) throws MessagingException{
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(managerEmail);
        helper.setSubject(meetingName+" MOM (Submitted)");
        helper.setText("Dear "+ managerName+", I've submitted "
                + "the MOM for the "+meetingName+" meeting "
                + "that was held in "+meetingDate+" "+meetingTime
                +". I hope you follow up soon. Thank You. "+""
                  + "            "
                        + "         "
                        + "           "
                        + "       "
                        + "      "+
                "Best regards, "+""
                        + "         "
                        + "  "
                        + picName +" "+picLastName
        
        
        );
       
        javaMailSender.send(msg);
        return "redirect:/pic/mom";
    }
    
    @GetMapping("/pic/followup/delete/{id}")
    public String deleteFollowup(@PathVariable(value = "id") int id){
        fsi.delete(id);
        return "redirect:/pic/mom";
    }
    
    @GetMapping("/manager/approval")
    public String approval(Model model){
        model.addAttribute("mom", momsi.findAll());
        model.addAttribute("followup", fsi.findAll());
        model.addAttribute("meeting", msi.findAll());
        model.addAttribute("employee", esi.findAll());
        return "approval";
    }
    @GetMapping("/manager/approvalhistory")
    public String approvalhistory(Model model){
        model.addAttribute("mom", momsi.findAll());
        model.addAttribute("followup", fsi.findAll());
        model.addAttribute("meeting", msi.findAll());
        model.addAttribute("employee", esi.findAll());
        return "approvalhistory";
    }
    
    @PostMapping("/manager/approval/update")
    public String updateApproval(@RequestParam(value = "id") int id,
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "meetingId") int meetingId,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "managerId") int actionby,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "picId") int picId,
            @RequestParam(value = "picEmail") String picEmail,
            @RequestParam(value = "picName") String picName,
            @RequestParam(value = "picLastName") String picLastName,
            @RequestParam(value = "statusName") String statusName,
            @RequestParam(value = "meetingName") String meetingName,
            @RequestParam(value = "managerName") String managerName,
            @RequestParam(value = "managerLastName") String managerLastName,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "location") String location
            ) throws MessagingException{
            int stat=0;
            if("Approve".equals(status)){
                stat=2;
            }else if("Reject".equals(status)){
                stat=3;
            }
            Mom mom = new Mom(id, desc, new Meeting(meetingId), new Status(stat), new Employee(picId));
            
            
            Date dateToday = new Date();

             Approval approval = new Approval(dateToday, note, new Employee (actionby),
                     new Status(stat), new Mom(id));
            momsi.save(mom);
            asi.save(approval);
            
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(picEmail);
            helper.setSubject("MOM Follow Up - "+meetingName);
            helper.setText("Dear "+picName+" "+picLastName+", your Minutes of Meeting"
                    + " of "+meetingName+" has been "+status+" by the manager / project manager, "
                            + managerName+" "+managerLastName+" on "+dateToday+". Notes : "+note+".");
            javaMailSender.send(msg);
            
            

        return "redirect:/manager/approval";
    }
    
//    @PostMapping("/manager/report")
//    public String report(@RequestParam(value = "id") int id,
//            @RequestParam(value = "meetingId") int meetingId
//            ){
//        model.addAttribut
//        return "report";
//    }
}
