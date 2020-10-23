package com.steveyu.drugmanagesystem.dto;

import com.steveyu.drugmanagesystem.entity.Admin;
import com.steveyu.drugmanagesystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto<T> {
    String loginType;
    T user;
    String message;
}
