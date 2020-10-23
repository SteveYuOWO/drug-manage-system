package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.dto.DrugCommentDto;
import com.steveyu.drugmanagesystem.entity.DrugComment;
import com.steveyu.drugmanagesystem.service.DrugCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/drugcomment")
public class DrugCommentApi {
    @Autowired
    DrugCommentService drugCommentService;

    @PostMapping
    public String saveDrugComment(@RequestBody DrugCommentDto drugCommentDto) {
        drugCommentService.saveDrugComment(drugCommentDto);
        return "留言成功";
    }

    @GetMapping
    public List<DrugComment> getAllDrugComments() {
        return drugCommentService.getAllDrugCOmments();
    }
    @GetMapping("{drugId}")
    public List<DrugComment> getAllDrugCommentsByDrugId(@PathVariable("drugId") Integer drugId) {
        return drugCommentService.getAllDrugCommentsByDrugId(drugId);
    }

    @DeleteMapping("{id}")
    public String deleteDrugCommentById(@PathVariable("id") Integer id) {
        return drugCommentService.deleteDrugCommentById(id) ? "删除成功": "删除失败";
    }
}
