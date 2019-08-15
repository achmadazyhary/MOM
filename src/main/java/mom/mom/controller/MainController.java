/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.controller;

import com.google.gson.Gson;
import mom.mom.interfaceserviceimplement.CustomerServiceImplement;
import mom.mom.interfaceserviceimplement.DistrictServiceImplement;
import mom.mom.interfaceserviceimplement.EmployeeServiceImplement;
import mom.mom.interfaceserviceimplement.MeetingServiceImplement;
import mom.mom.interfaceserviceimplement.ProvinceServiceImplement;
import mom.mom.interfaceserviceimplement.RoleServiceImplement;
import mom.mom.interfaceserviceimplement.StatusServiceImplement;
import mom.mom.interfaceserviceimplement.SubdistrictServiceImplement;
import mom.mom.interfaceserviceimplement.UrbanvillageServiceImplement;
import mom.mom.model.Customer;
import mom.mom.model.District;
import mom.mom.model.Employee;
import mom.mom.model.Province;
import mom.mom.model.Role;
import mom.mom.model.Status;
import mom.mom.model.Subdistrict;
import mom.mom.model.Urbanvillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HARRY-PC
 */
@Controller
public class MainController {
    
    @Autowired
    public EmployeeServiceImplement esi;
    
    @Autowired
    public CustomerServiceImplement csi;
    
    @Autowired
    public RoleServiceImplement rsi;
    
    @Autowired
    public StatusServiceImplement ssi;
    
    @Autowired
    public ProvinceServiceImplement psi;
    
    @Autowired
    public DistrictServiceImplement dsi;
    
    @Autowired
    public SubdistrictServiceImplement sdsi;
    
    @Autowired
    public UrbanvillageServiceImplement usi;
    
    @Autowired
    public MeetingServiceImplement msi;
    
    @GetMapping("/dashboard")
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = {"/", "", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    //Start Controller Employee
    @GetMapping("/admin/employee")
    public String employee(Model model){
        model.addAttribute("employee", esi.findAll());
        model.addAttribute("role", rsi.findAll());
        return "employee";
    }
    
    @PostMapping("/admin/employee/save")
    public String saveEmployee(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "isactive") boolean isctive,
            @RequestParam(value = "role")int role){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String chip = passwordEncoder.encode(password);
        Employee employee = new Employee(name, lastName, phone, email, chip, new Role(role), isctive);
        esi.save(employee);
        return "redirect:/admin/employee";
    }
    
    @PostMapping("/admin/employee/edit")
    public String editEmployee(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "isactive") boolean isctive,
            @RequestParam(value = "role")int role){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String chip = passwordEncoder.encode(password);
        Employee employee = new Employee(id, name, lastName, phone, email, chip, new Role(role), isctive);
        esi.save(employee);
        return "redirect:/admin/employee";
    }
    
    @GetMapping("/admin/employee/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        esi.delete(id);
        return "redirect:/admin/employee";
    }
    //End Controller Employee
    
    //Start Controller Customer
    @GetMapping("/admin/customer")
    public String customer(Model model){
        model.addAttribute("customer", csi.findAll());
        model.addAttribute("province", psi.findAll());
        model.addAttribute("district", dsi.findAll());
        model.addAttribute("subdistrict", sdsi.findAll());
        model.addAttribute("urbanvillage", usi.findAll());
        return "customer";
    }
    
    @GetMapping("/admin/loadDistrict/{id}")
    public String loadDistrict(@PathVariable(value = "id") int id){
        Gson gson = new Gson();
        return gson.toJson(csi.findById(id).get().getDistrict());
    }
    
    @PostMapping("/admin/customer/save")
    public String saveCustomer(@RequestParam(value = "name")String name,
            @RequestParam(value = "pic")String pic,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "province")int province,
            @RequestParam(value = "district")int district,
            @RequestParam(value = "subdistrict")int subdistrict,
            @RequestParam(value = "urbanvillage")int urbanvillage){
        Customer customer = new Customer(name, pic, phone, email, address, 
                new Province(province), 
                new District(district), 
                new Subdistrict(subdistrict), 
                new Urbanvillage(urbanvillage));
        csi.save(customer);
        return "redirect:/admin/customer";
    }
    
    @PostMapping("/admin/customer/edit")
    public String editCustomer(@RequestParam(value = "id") int id,
            @RequestParam(value = "name")String name,
            @RequestParam(value = "pic")String pic,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "province")int province,
            @RequestParam(value = "district")int district,
            @RequestParam(value = "subdistrict")int subdistrict,
            @RequestParam(value = "urbanvillage")int urbanvillage){
        Customer customer = new Customer(id, name, pic, phone, email, address, 
                new Province(province), 
                new District(district), 
                new Subdistrict(subdistrict), 
                new Urbanvillage(urbanvillage));
        csi.save(customer);
        return "redirect:/admin/customer";
    }
    
    @GetMapping("/admin/customer/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        csi.delete(id);
        return "redirect:/admin/customer";
    }
    //End Controller Customer
    
    // Start Controller Role
    @GetMapping("/admin/role")
    public String role(Model model){
        model.addAttribute("role", rsi.findAll());
        return "role";
    }
    
    @PostMapping("/admin/role/save")
    public String saveRole(@RequestParam(value = "name") String name){
        Role role = new Role(name);
        rsi.save(role);
        return "redirect:/admin/role";
    }
    
    @PostMapping("/admin/role/edit")
    public String editRole(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Role role = new Role(id, name);
        rsi.save(role);
        return "redirect:/admin/role";
    }
    
    @GetMapping("/admin/role/delete/{id}")
    public String deleteRole(@PathVariable(value = "id") int id){
        rsi.delete(id);
        return "redirect:/admin/role";
    }
    //End Controller Role
    
    //Start Controller Status
    @GetMapping("/admin/status")
    public String status(Model model){
        model.addAttribute("status", ssi.findAll());
        return "status";
    }
    
    @PostMapping("/admin/status/save")
    public String saveStatus(@RequestParam(value = "name") String name){
        Status status = new Status(name);
        ssi.save(status);
        return "redirect:/admin/status";
    }
    
    @PostMapping("/admin/status/edit")
    public String editStatus(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Status status = new Status(id, name);
        ssi.save(status);
        return "redirect:/admin/status";
    }
    
    @GetMapping("/admin/status/delete/{id}")
    public String deleteStatus(@PathVariable(value = "id") int id){
        ssi.delete(id);
        return "redirect:/admin/status";
    }
    //End Controller Status
    
    //Start Controller Province
    @GetMapping("/admin/province")
    public String province(Model model){
        model.addAttribute("province", psi.findAll());
        return "province";
    }
    
    @PostMapping("/admin/province/save")
    public String saveProvince(@RequestParam(value = "name") String name){
        Province province = new Province(name);
        psi.save(province);
        return "redirect:/admin/province";
    }
    
    @PostMapping("/admin/province/edit")
    public String editProvince(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name){
        Province province = new Province(id, name);
        psi.save(province);
        return "redirect:/admin/province";
    }
    
    @GetMapping("/admin/province/delete/{id}")
    public String deleteProvince(@PathVariable(value = "id") int id){
        psi.delete(id);
        return "redirect:/admin/province";
    }
    //End Controller Province
    
    //Start Controller District
    @GetMapping("/admin/district")
    public String district(Model model){
        model.addAttribute("district", dsi.findAll());
        model.addAttribute("province", psi.findAll());
        return "district";
    }
    
    @PostMapping("/admin/district/save")
    public String saveDistrict(@RequestParam(value = "name") String name, 
            @RequestParam(value = "province") int province){
        District district = new District(name, new Province(province));
        dsi.save(district);
        return "redirect:/admin/district";
    }
    
    @PostMapping("/admin/district/edit")
    public String editDistrict(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "province") int province){
        District district = new District(id, name, new Province(province));
        dsi.save(district);
        return "redirect:/admin/district";
    }
    
    @GetMapping("/admin/district/delete/{id}")
    public String deleteDistrict(@PathVariable(value = "id") int id){
        dsi.delete(id);
        return "redirect:/admin/district";
    }
    //End Controller District
    
    //Start Controller Sub-District
    @GetMapping("/admin/subdistrict")
    public String subdistrict(Model model){
        model.addAttribute("subdistrict", sdsi.findAll());
        model.addAttribute("district", dsi.findAll());
        return "subdistrict";
    }
    
    @PostMapping("/admin/subdistrict/save")
    public String saveSubdistrict(@RequestParam(value = "name") String name, 
            @RequestParam(value = "district") int district){
        Subdistrict subdistrict = new Subdistrict(name, new District(district));
        sdsi.save(subdistrict);
        return "redirect:/admin/subdistrict";
    }
    
    @PostMapping("/subdistrict/edit")
    public String editSubdistrict(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "district") int district){
        Subdistrict subdistrict = new Subdistrict(id, name, new District(district));
        sdsi.save(subdistrict);
        return "redirect:/admin/subdistrict";
    }
    
    @GetMapping("/admin/subdistrict/delete/{id}")
    public String deleteSubdistrict(@PathVariable(value = "id") int id){
        sdsi.delete(id);
        return "redirect:/admin/subdistrict";
    }
    //End Controller Sub-District
    
    //Start Controller Urban-Village
    @GetMapping("/admin/urbanvillage")
    public String urbanvillage(Model model){
        model.addAttribute("urbanvillage", usi.findAll());
        model.addAttribute("subdistrict", sdsi.findAll());
        return "urbanvillage";
    }
    
    @PostMapping("/admin/urbanvillage/save")
    public String saveUrbanvillage(@RequestParam(value = "name") String name,
            @RequestParam(value = "postalcode") String postalCode,
            @RequestParam(value = "subdistrict") int subdistrict){
        Urbanvillage urbanvillage = new Urbanvillage(name, postalCode, new Subdistrict(subdistrict));
        usi.save(urbanvillage);
        return "redirect:/admin/urbanvillage";
    }
    
    @PostMapping("/admin/urbanvillage/edit")
    public String editUrbanvillage(@RequestParam(value = "id") int id, 
            @RequestParam(value = "name") String name,
            @RequestParam(value = "postalcode") String postalCode,
            @RequestParam(value = "subdistrict") int subdistrict){
        Urbanvillage urbanvillage = new Urbanvillage(id, name, postalCode, new Subdistrict(subdistrict));
        usi.save(urbanvillage);
        return "redirect:/admin/urbanvillage";
    }
    
    @GetMapping("/admin/urbanvillage/delete/{id}")
    public String deleteUrbanvillage(@PathVariable(value = "id") int id){
        usi.delete(id);
        return "redirect:/admin/urbanvillage";
    }
    //End Controller Urban-Village
    
}
