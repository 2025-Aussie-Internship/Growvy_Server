package com.growvy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.growvy.dto.req.EmployerSignUpRequest;
import com.growvy.dto.req.JobSeekerSignUpRequest;
import com.growvy.dto.res.AuthResponse;
import com.growvy.entity.EmployerProfile;
import com.growvy.entity.Image;
import com.growvy.entity.JobSeekerProfile;
import com.growvy.entity.User;
import com.growvy.repository.EmployerProfileRepository;
import com.growvy.repository.ImageRepository;
import com.growvy.repository.JobSeekerProfileRepository;
import com.growvy.repository.UserRepository;
import com.growvy.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final EmployerProfileRepository employerProfileRepository;
    private final JobSeekerProfileRepository jobseekerProfileRepository;
    private final JwtUtil jwtProvider;
    private final GeoService geoService;

}
