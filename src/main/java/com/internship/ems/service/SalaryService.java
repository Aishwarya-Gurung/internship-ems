package com.internship.ems.service;

import com.internship.ems.Mapper.SalaryMapper;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;

    @Autowired
    private SalaryMapper salaryMapper;

    public SalaryDto saveSalary(SalaryDto salaryDto){
        Salary salaryModel = salaryMapper.dtoToModel( salaryDto );
        return  salaryMapper.modelToDto( salaryRepo.save(salaryModel) );
    }

    public SalaryDto getById(Long id){
        return salaryMapper.modelToDto( salaryRepo.findById(id).orElseThrow(EntityExistsException::new) );
    }

    public List<SalaryDto> getAll(){
        return salaryMapper.modelsToDtos( (List<Salary>) salaryRepo.findAll() );
    }

    public SalaryDto updateSalary(Long id, SalaryDto newSalaryDto){
        Salary salaryModel = salaryMapper.dtoToModel( newSalaryDto );

        Salary existingSalary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        existingSalary.setIssueDate(salaryModel.getIssueDate());
        existingSalary.setAmount(salaryModel.getAmount());
        existingSalary.setBonus(salaryModel.getBonus());
        salaryRepo.save(existingSalary);

        return salaryMapper.modelToDto( existingSalary );
    }

    public String deleteSalary(Long id){
        salaryRepo.deleteById(id);

        return "id" +id+" deleted!! ";
    }
}
