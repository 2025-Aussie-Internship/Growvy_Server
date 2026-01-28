package com.growvy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROFILE 또는 BANNER
    @Enumerated(EnumType.STRING) // enum 저장 타입 지정
    @Column(nullable = false)
    private ImageType type;

    // 제목
    private String title;

    // URL
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    // 사용 여부
    @Column(name = "is_active")
    private boolean active;

    // 정렬 순서
    @Column(name = "sort_order")
    private Integer sortOrder;

    // 특정 값만 저장 가능
    public enum ImageType {
        PROFILE,
        BANNER
    }
}
