package com.steveyu.drugmanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrugCommentDto {
    Integer userId;
    Integer drugId;
    String message;
}
