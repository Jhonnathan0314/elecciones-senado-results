package com.elecciones.senado.results.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomHeaderFilter extends OncePerRequestFilter {

    private static final String REQUIRED_HEADER = "From-Official-Page";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getHeader(REQUIRED_HEADER) == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unauthorized access");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
