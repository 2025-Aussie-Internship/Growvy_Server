package com.growvy.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;
    private boolean registered;
}

