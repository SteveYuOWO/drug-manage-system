package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.DrugCommentDao;
import com.steveyu.drugmanagesystem.dao.DrugDao;
import com.steveyu.drugmanagesystem.dao.UserDao;
import com.steveyu.drugmanagesystem.dto.DrugCommentDto;
import com.steveyu.drugmanagesystem.entity.Drug;
import com.steveyu.drugmanagesystem.entity.DrugComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugCommentService {
    @Autowired
    DrugCommentDao drugCommentDao;

    @Autowired
    DrugDao drugDao;

    @Autowired
    UserDao userDao;

    public void saveDrugComment(DrugCommentDto drugCommentDto) {
        drugCommentDao.save(new DrugComment()
                .setFrom(userDao.findById(drugCommentDto.getUserId()).get())
                .setTo(drugDao.findById(drugCommentDto.getDrugId()).get())
                .setMessage(drugCommentDto.getMessage()));
    }

    public List<DrugComment> getAllDrugCommentsByDrugId(Integer drugId) {
        Drug drug = drugDao.findById(drugId).get();
        return drugCommentDao.findAll(Example.of(new DrugComment().setTo(drug)));
    }

    public boolean deleteDrugCommentById(Integer id) {
        Optional<DrugComment> drugCommentOptional = drugCommentDao.findById(id);
        if(drugCommentOptional.isEmpty()) return false;
        drugCommentDao.deleteById(id);
        return true;
    }

    public List<DrugComment> getAllDrugCOmments() {
        return drugCommentDao.findAll();
    }
}
