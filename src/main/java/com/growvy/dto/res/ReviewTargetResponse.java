package com.growvy.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewTargetResponse {
    private Long targetUserId;
    private String name;
    private String profileImage;
    private boolean isReviewed;
}
