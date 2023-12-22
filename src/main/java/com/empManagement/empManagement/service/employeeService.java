package com.empManagement.empManagement.service;

import com.empManagement.empManagement.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empManagement.empManagement.repositary.employeeRepositary;

import java.util.List;

@Service
public class employeeService {

    @Autowired
    private employeeRepositary bRepo;

    public void save(employee b){
        bRepo.save(b);
    }



    public employee getemployeeById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }

    public List<employee> getAllemployees(){
        return bRepo.findAll();
    }

    public List<employee> getByKeyword(String keyword){
        return bRepo.findByKeyword(keyword);
    }





}
