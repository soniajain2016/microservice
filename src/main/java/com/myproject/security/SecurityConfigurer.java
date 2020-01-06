package com.myproject.security;

import com.myproject.exception.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity

public class SecurityConfigurer extends WebSecurityConfigurerAdapter {


  @Autowired
  private MyAccessDeniedHandler access;

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwtSetUri;

    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.cors().and()
                .csrf()
                .disable()
              .authorizeRequests().
                antMatchers("/users").authenticated()
                .and().oauth2ResourceServer().jwt() .and()
                .authenticationEntryPoint((request, response, e) -> {
                    String json = String.format("{\"messageeee eee\": \"%s\"}", "ssssss");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                }).accessDeniedHandler(access);


    }


    public JwtDecoder jwtDecoder() {
        return new NimbusJwtDecoderJwkSupport(jwtSetUri);
    }


}