package com.solvestack.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@Component
public class ClerkJwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        System.out.println("Auth header: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                String[] parts = token.split("\\.");
                System.out.println("JWT parts count: " + parts.length);

                // Add padding if needed
                String base64Payload = parts[1];
                int padding = base64Payload.length() % 4;
                if (padding > 0) {
                    base64Payload += "=".repeat(4 - padding);
                }

                byte[] decodedBytes = Base64.getUrlDecoder().decode(base64Payload);
                String payload = new String(decodedBytes, StandardCharsets.UTF_8);
                System.out.println("Payload: " + payload);

                String userId = payload.split("\"sub\":\"")[1].split("\"")[0];
                System.out.println("Extracted userId: " + userId);
                request.setAttribute("userId", userId);
            } catch (Exception e) {
                System.out.println("JWT decode error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No Authorization header found");
        }

        filterChain.doFilter(request, response);
    }
}