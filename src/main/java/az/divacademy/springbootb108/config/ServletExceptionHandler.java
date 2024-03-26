package az.divacademy.springbootb108.config;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
@Component
public class ServletExceptionHandler extends OncePerRequestFilter {

  private final HandlerExceptionResolver resolver;

  public ServletExceptionHandler(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver){
    this.resolver = resolver;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request,response);
    }catch (ExpiredJwtException | MalformedJwtException ex){
      resolver.resolveException(request,response,null,ex);
      ex.getMessage();
    }

  }
}
