package com.growvy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_seeker_interests")
@Getter
@Setter
public class JobSeekerInterest {

    @EmbeddedId // 복합 PK (FK 두 개를 하나의 PK로)
    private JobSeekerInterestId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobSeekerId")
    @JoinColumn(name = "job_seeker_id")
    private JobSeekerProfile jobSeekerProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    private Interest interest;
}



