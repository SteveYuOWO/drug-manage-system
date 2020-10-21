package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.dto.PurchaseDto;
import com.steveyu.drugmanagesystem.entity.Purchase;
import com.steveyu.drugmanagesystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchase")
public class PurchaseApi {
    @Autowired
    PurchaseService purchaseService;
    @PostMapping
    public String savePurchase(@RequestBody PurchaseDto purchaseDto) {
        purchaseService.savePurchase(purchaseDto);
        return "插入成功";
    }

    @GetMapping("{userId}")
    public List<Purchase> getAllPurchasesByUserId(@PathVariable("userId") int userId) {
        return purchaseService.getAllPurchasesByUserId(userId);
    }

    @DeleteMapping("{id}")
    public String deletePurchaseById(@PathVariable("id") int id) {
        return purchaseService.deletePurchaseById(id) ? "删除成功": "删除失败";
    }
}
