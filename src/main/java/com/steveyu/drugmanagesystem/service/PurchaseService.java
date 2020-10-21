package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.DrugDao;
import com.steveyu.drugmanagesystem.dao.PurchaseDao;
import com.steveyu.drugmanagesystem.dao.UserDao;
import com.steveyu.drugmanagesystem.dto.PurchaseDto;
import com.steveyu.drugmanagesystem.entity.Purchase;
import com.steveyu.drugmanagesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    DrugDao drugDao;

    @Autowired
    UserDao userDao;

    public void savePurchase(PurchaseDto purchaseDto) {
        purchaseDao.save(new Purchase()
                .setDrug(drugDao.findById(purchaseDto.getDrugId()).get())
                .setUser(userDao.findById(purchaseDto.getUserId()).get()));
    }

    public List<Purchase> getAllPurchasesByUserId(int userId) {
        Optional<User> userOptional = userDao.findById(userId);
        return purchaseDao.findAll(Example.of(new Purchase().setUser(userOptional.get())));
    }

    public boolean deletePurchaseById(Integer id) {
        Optional<Purchase> purchaseOptional = purchaseDao.findById(id);
        if(purchaseOptional.isEmpty()) return false;
        System.out.println("---" + id);
        purchaseDao.deleteById(id);
        return true;
    }
}
