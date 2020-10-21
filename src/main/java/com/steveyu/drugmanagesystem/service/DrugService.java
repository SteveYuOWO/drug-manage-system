package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.DrugDao;
import com.steveyu.drugmanagesystem.entity.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    DrugDao drugDao;

    public List<Drug> getAllDrugs() {
        return drugDao.findAll();
    }

    public void saveDrug(Drug drug) {
        drugDao.save(drug);
    }

    public Optional<Drug> getDrugById(Integer id) {
        return drugDao.findById(id);
    }

    public boolean deleteDrugById(Integer id) {
        Optional<Drug> drugOptional = drugDao.findById(id);
        if(drugOptional.isEmpty()) return false;
        drugDao.delete(drugOptional.get());
        return true;
    }
}
