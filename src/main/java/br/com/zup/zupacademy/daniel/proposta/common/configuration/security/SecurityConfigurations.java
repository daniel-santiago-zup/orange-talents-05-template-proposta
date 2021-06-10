package br.com.zup.zupacademy.daniel.proposta.common.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

    // Configurações de Autorização (diz quem pode acessar cada url, perfis de aceso etc)
    @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                        .antMatchers(HttpMethod.GET,"/proposta/**").hasAuthority("SCOPE_proposta:read")
                        .antMatchers(HttpMethod.POST,"/proposta/**").hasAuthority("SCOPE_proposta:write")
                        .antMatchers(HttpMethod.POST,"/biometria/**").hasAuthority("SCOPE_biometria:write")
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
