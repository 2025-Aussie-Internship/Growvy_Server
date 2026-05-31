package com.growvy.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobSeekerProfileUpdateRequest {

    // User
    private String name;
    private String email;
    private JobSeekerSignUpRequest.Gender gender;
    private String phone;
    private Long profileImageId;

    // JobSeekerProfile
    private String homeAddress;
    private String career;
    private String bio;

    // Interest
    private List<Long> interestIds;
}