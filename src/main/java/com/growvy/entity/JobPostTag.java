package com.growvy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_post_tags")
@Getter
@Setter
public class JobPostTag {

    @EmbeddedId // 복합 PK (FK 두 개를 하나의 PK로)
    private JobPostTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobPostId")
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    private Interest interest;
}



