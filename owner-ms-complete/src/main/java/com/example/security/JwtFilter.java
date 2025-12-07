package com.example.security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private CustomOwnerDetailsService ownerDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String auth = req.getHeader("Authorization");

        if(auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            if(jwt.validate(token)){
                String username = jwt.getUsername(token);
                var ud = ownerDetails.loadUserByUsername(username);
                SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities()));
            }
        }

        chain.doFilter(req, res);
    }
}
