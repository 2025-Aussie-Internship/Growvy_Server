package com.growvy.dto.req;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private Long targetUserId;
    private Integer rating;
    private String comment;
}
