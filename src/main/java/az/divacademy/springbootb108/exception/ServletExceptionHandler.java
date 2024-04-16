package az.divacademy.springbootb108.exception;

import az.divacademy.springbootb108.service.impl.JwtServiceImpl;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
@Component
public class ServletExceptionHandler extends OncePerRequestFilter {

  private final HandlerExceptionResolver resolver;
  private final JwtServiceImpl jwtService;
  private final UserDetailsService userDetailsService;

  public ServletExceptionHandler(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver,
      JwtServiceImpl jwtService, UserDetailsService userDetailsService){
    this.resolver = resolver;
    this.jwtService = jwtService;
    this.userDetailsService = userDetailsService;
  }
//Catch Token Expired
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (MalformedJwtException ex) {
      resolver.resolveException(request, response, null, ex);
    }

  }
}
