package com.example.ProjektB.config;

import com.example.ProjektB.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain )
            throws ServletException, IOException {
        String jwt = getJwtFromRequest( request );
        if ( jwt != null && jwtTokenProvider.validateToken( jwt ) ) {
            String username = jwtTokenProvider.getUserNameFromToken( jwt );
            UserDetails userDetails = customUserDetailsService.loadUserByUsername( username );
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities() );
            authenticationToken.setDetails( new WebAuthenticationDetailsSource() );
            SecurityContextHolder.getContext().setAuthentication( authenticationToken );
        }
        filterChain.doFilter( request, response );
    }

    private String getJwtFromRequest( HttpServletRequest request ) {
        String bearerToken = request.getHeader( "Authorization" );

        if ( bearerToken != null ) {
            return bearerToken.substring( 7 );
        }
        return null;
    }

}
