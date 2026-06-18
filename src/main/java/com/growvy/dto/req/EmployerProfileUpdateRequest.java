package com.growvy.dto.req;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployerProfileUpdateRequest {

    // User
    private String name;
    private String email;
    private EmployerSignUpRequest.Gender gender;
    private String phone;
    private Long profileImageId;

    // EmployerProfile
    private String companyName;
    private String businessAddress;
}