package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.entity.Drug;
import com.steveyu.drugmanagesystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/drug")
public class DrugApi {
    @Autowired
    DrugService drugService;

    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }
    @PostMapping
    public String saveDrug(@RequestBody Drug drug) {
        drugService.saveDrug(drug);
        return "插入成功";
    }
    @GetMapping("{id}")
    public Optional<Drug> getDrugById(@PathVariable("id") Integer id) {
        return drugService.getDrugById(id);
    }

    @DeleteMapping("{id}")
    public String deleteDrugById(@PathVariable("id") Integer id) {
        return drugService.deleteDrugById(id) ? "删除成功": "删除失败";
    }
}
