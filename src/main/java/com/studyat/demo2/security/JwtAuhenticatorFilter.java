package com.studyat.demo2.security;

import com.studyat.demo2.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuhenticatorFilter extends OncePerRequestFilter
{
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwtToken= extractJwtFromRequest(request);
            if (StringUtils.hasText(jwtToken)&& jwtTokenProvider.validateToken(jwtToken)){
                Long id =jwtTokenProvider.getUSerIdFromJWT(jwtToken);
                UserDetails user= userDetailsService.loadUserByıd(id);
                if (user!=null){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }

            }
        }catch (Exception e){
            return ;
        }
        filterChain.doFilter(request,response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearer=request.getHeader("Authorization");
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")){
            return bearer.substring("Bearer".length()+1);

        }
        return null;
    }
}
