package com.example.examejee.bean;

import com.example.examejee.model.Employee;
import com.example.examejee.model.EmployeeProjectAssignment;
import com.example.examejee.model.Project;
import com.example.examejee.Repository.EmployeeRepository;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ManagedBean
@SessionScoped
@Component
public class EmployeeBean implements Serializable {
    private Integer id;
    private String name;
    private String email;

    private Employee employee;

    private List<Employee> employees;

    private List<String> employeeNames;
    private String selectedEmployee;
    private List<Project> projects;
    private List<String> projectNames;
    private List<String> selectedProjects;
    private int percentageImplication;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void affectProject() {
        Optional<Employee> optionalEmployee = employeeRepository.findByName(selectedEmployee);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            List<Project> selectedProject = getProjectsByName(selectedProjects);

            for (Project project : selectedProject) {
                if (!isEmployeeAssignedToProject(employee, project)) {
                    EmployeeProjectAssignment assignment = new EmployeeProjectAssignment();
                    assignment.setEmployee(employee);
                    assignment.setProject(project);
                    assignment.setAffectationPercentage(percentageImplication);
                    // Save the assignment (you'll need a repository or service for EmployeeProjectAssignment)
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Project '" + project.getName() + "' is already assigned to the employee.", "Project '" + project.getName() + "' is already assigned to the employee."));
                    return;
                }
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Projects assigned successfully!", "Projects assigned successfully!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selected employee not found!", "Selected employee not found!"));
        }
    }

    private List<Project> getProjectsByName(List<String> projectNames) {
        List<Project> projects = new ArrayList<>();
        for (String projectName : projectNames) {
            Project project = getProjectByName(projectName);
            projects.add(project);
        }
        return projects;
    }

    private Project getProjectByName(String projectName) {
        // Implement the logic to get a Project by its name (possibly using a ProjectRepository)
        return null;
    }

    private boolean isEmployeeAssignedToProject(Employee employee, Project project) {
        // Implement the logic to check if an employee is assigned to a project
        return false;
    }

    @PostConstruct
    public void init() {
        employees = employeeRepository.findAll();
        employeeNames = employees.stream().map(Employee::getName).collect(Collectors.toList());
        // Initialize projects and projectNames similarly
    }

    // Getter and Setter methods

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(List<String> employeeNames) {
        this.employeeNames = employeeNames;
    }

    public String getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(String selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public List<String> getSelectedProjects() {
        return selectedProjects;
    }

    public void setSelectedProjects(List<String> selectedProjects) {
        this.selectedProjects = selectedProjects;
    }

    public int getPercentageImplication() {
        return percentageImplication;
    }

    public void setPercentageImplication(int percentageImplication) {
        this.percentageImplication = percentageImplication;
    }
}
