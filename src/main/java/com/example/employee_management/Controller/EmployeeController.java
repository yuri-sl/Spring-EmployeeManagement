package com.example.employee_management.Controller;

import com.example.employee_management.model.Employee;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();
    private int nextId = 1;
    public EmployeeController(){
        employeeList.add(new Employee(nextId++,"Dazai Osamu","IT",150.00, "osamu.dazai@gmail.com"));
        employeeList.add(new Employee(nextId++,"Akutagawa Ryuunosuke","IT",100.00, "akutagawa.mafia@gmail.com"));
        employeeList.add(new Employee(nextId++,"Kunikida","IT",130.00, "Kunikida.dectective@gmail.com"));
        employeeList.add(new Employee(nextId++,"Edogawa Ranpo","IT",120.00, "Ranpo.dectective@gmail.com"));
    }
    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeList);
        return "employees/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/add";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employeeInput){
        employeeInput.setId(nextId++);
        employeeList.add(employeeInput);
        return "redirect:/employees";
    }


}
