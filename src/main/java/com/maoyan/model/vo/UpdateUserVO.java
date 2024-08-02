package com.maoyan.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserVO {
    private Long id;
    private String username;
    private String password;
}
