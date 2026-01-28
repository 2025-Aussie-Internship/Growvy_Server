package com.growvy.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobPostResponse {
    private String title;
    private String companyName;
    private String startTime;
    private String endTime;
    private List<String> tags;
}
