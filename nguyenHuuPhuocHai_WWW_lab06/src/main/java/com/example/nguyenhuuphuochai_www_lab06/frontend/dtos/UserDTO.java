package com.example.nguyenhuuphuochai_www_lab06.frontend.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String passwordHash;
}
