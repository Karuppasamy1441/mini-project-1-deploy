package com.EmployeeManagement.Application.Controller;

import com.EmployeeManagement.Application.Exception.EmailAlreadyExistsException;
import com.EmployeeManagement.Application.Exception.IdAlreadyExistsException;
import com.EmployeeManagement.Application.Service.EmoployeeService;
import com.EmployeeManagement.Application.Entity.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmoployeeService emoployeeService;

    @GetMapping("/homePage")
    public String  getAllEmployeeDetails(Model model){
        model.addAttribute("allEmployeeList",emoployeeService.getAllEmployeeDetails());
        return "index";
    }


    @GetMapping("/addNew")
    public String  addNewEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }

    @PostMapping("/save")
    public String addEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee,BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "newEmployee";
            }
            try {
                emoployeeService.addEmployeeDetails(employee);
            } catch (EmailAlreadyExistsException e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "newEmployee";
            }


        return "redirect:/homePage";
    }

    @GetMapping("/update/{id}")
    public String  addNewEmployee(@PathVariable long id, Model model){
        Employee employee=emoployeeService.getEmployeeDetailsById(id);
        model.addAttribute("employee",employee);
        return "update";
    }

    @GetMapping("/getEmployee/{id}")
    public String  getEmployeeById(@PathVariable Long  id,Model model){
        Employee employee=emoployeeService.getEmployeeDetailsById(id);

        model.addAttribute("employee",employee);
        return "read";
    }


    @GetMapping("deleteEmployee/{id}")
    public String  deleteEmployeeDetails(@PathVariable Long  id){
        emoployeeService.deleteEmployeeDetails(id);
        return "redirect:/homePage";
    }

}
