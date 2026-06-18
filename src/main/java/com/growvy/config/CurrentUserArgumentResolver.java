package com.growvy.config;

import com.growvy.annotation.CurrentUser;
import com.growvy.entity.User;
import com.growvy.repository.UserRepository;
import com.growvy.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class CurrentUserArgumentResolver
        implements HandlerMethodArgumentResolver {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {

        HttpServletRequest request =
                webRequest.getNativeRequest(HttpServletRequest.class);

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Authorization 헤더가 없습니다.");
        }

        String jwt = header.replace("Bearer ", "").trim();

        // 🟢 파이어베이스 검증기 대신, 백엔드 자체 토큰 파서를 사용하도록 변경!
        String firebaseUid =
                jwtUtil.getFirebaseUidFromBackendToken(jwt);

        return userRepository.findByFirebaseUid(firebaseUid)
                .orElseThrow(() ->
                        new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }
}