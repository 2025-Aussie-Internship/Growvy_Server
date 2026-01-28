package com.growvy.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerInterestId implements Serializable {
    private Long jobSeekerId;
    private Long interestId;

    @Override
    // 자바는 객체가 다르면 다르다고 판단함 -> equals를 재정의 (값이 같으면 true로 판단)
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSeekerInterestId that = (JobSeekerInterestId) o;
        return Objects.equals(jobSeekerId, that.jobSeekerId) &&
                Objects.equals(interestId, that.interestId);
    }

    @Override
    // 해시도 같다고 판단하기
    public int hashCode() {
        return Objects.hash(jobSeekerId, interestId);
    }
}
