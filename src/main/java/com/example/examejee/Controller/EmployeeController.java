package com.example.examejee.Controller;

import com.example.examejee.model.Employee;
import com.example.examejee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee-list";
    }

    @PostMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeRepository.deleteById(Long.valueOf(id));
        return "redirect:/employees";
    }
}
