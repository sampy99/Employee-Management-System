package com.empManagement.empManagement.controller;

import com.empManagement.empManagement.entity.employee;
import com.empManagement.empManagement.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller

public class employeeController {





    @Autowired
    private employeeService service;



    @GetMapping("/")
    public String home(){
        return "/pages/landing_page";
    }

    @GetMapping("/landing_page")
    public String Lhome(){
        return "/pages/landing_page";
    }


@GetMapping("/employee_register")
    public String employeeRegister() {
    return "/pages/employeeRegister";
    }

    @GetMapping("/logout")
    public String logout() {
        return "auth-login";
    }

    @RequestMapping(path = {"/","/search"})
    public String home(employee employee, Model model, String keyword) {
        if(keyword!=null) {
            List<employee> list = service.getByKeyword(keyword);
            model.addAttribute("employee", list);
        }else {
            List<employee> list = service.getAllemployees();
            model.addAttribute("employee", list);}
        return "/pages/employeeDetails";
    }



    @GetMapping("/employee_details")
    public ModelAndView employeeDetails() {
        List<employee>list = service.getAllemployees();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/employeeDetails");
        m.addObject("employee",list);
        return new ModelAndView("/pages/employeeDetails","employee",list);
    }

    @PostMapping("/save")
    public String addemployee(@ModelAttribute employee b){
        service.save(b);
        return "redirect:/employee_details";
    }



    @RequestMapping("/editemployee/{id}")
    public String editemployee(@PathVariable("id") int id,Model model) {
        employee b=service.getemployeeById(id);
        model.addAttribute("employee",b);
        return "/pages/employeeEdit";
    }
    @RequestMapping("/deleteemployee/{id}")
    public String deleteemployee(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/employee_details";
    }



}
