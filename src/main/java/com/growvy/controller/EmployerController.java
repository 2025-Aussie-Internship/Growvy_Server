package com.growvy.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.growvy.dto.req.EmployerSignUpRequest;
import com.growvy.dto.req.JobSeekerSignUpRequest;
import com.growvy.dto.res.AuthResponse;
import com.growvy.dto.res.SignUpResponse;
import com.growvy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employer")
public class EmployerController {

    private final AuthService authService;

//    @PostMapping("/")
//    public ResponseEntity<AuthResponse> login(
//            @RequestHeader("Authorization") String header
//    ) throws FirebaseAuthException {
//
//        String firebaseToken = header.replace("Bearer ", "");
//
//        return ResponseEntity.ok(authService.login(firebaseToken));
//    }

    @PostMapping("/post")
    public ResponseEntity<SignUpResponse> jobseekerSignup(
            @RequestHeader("Authorization") String header,
            @RequestBody JobSeekerSignUpRequest request
    ) {
        String jwt = header.replace("Bearer ", "").trim();
        authService.jobseekerSignUp(jwt, request);
        return ResponseEntity.ok(new SignUpResponse(true));
    }
}

