package br.com.zup.zupacademy.daniel.proposta.common.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;

import java.util.Collection;
import java.util.HashSet;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{


    private static class RoleAndScopeAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

        @Override
        public Collection<GrantedAuthority> convert(Jwt jwt) {
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
            jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
            grantedAuthorities.addAll(jwtGrantedAuthoritiesConverter.convert(jwt));
            jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("scope");
            jwtGrantedAuthoritiesConverter.setAuthorityPrefix("SCOPE_");
            grantedAuthorities.addAll(jwtGrantedAuthoritiesConverter.convert(jwt));
            return grantedAuthorities;
        }
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        Converter<Jwt, Collection<GrantedAuthority>> converter = new RoleAndScopeAuthoritiesConverter();
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
        return jwtAuthenticationConverter;
    }


    // Configurações de Autorização (diz quem pode acessar cada url, perfis de aceso etc)
    @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                        .antMatchers(HttpMethod.GET,"/proposta/**").hasAuthority("SCOPE_proposta:read")
                        .antMatchers(HttpMethod.POST,"/proposta/**").hasAuthority("SCOPE_proposta:write")
                        .antMatchers(HttpMethod.POST,"/biometria/**").hasAuthority("SCOPE_biometria:write")
                        .antMatchers(HttpMethod.POST,"/bloqueio-cartao/**").hasAuthority("SCOPE_bloqueio-cartao:write")
                        .antMatchers(HttpMethod.GET, "/actuator/prometheus").permitAll()
                        .antMatchers(HttpMethod.GET, "/actuator/**").hasAuthority("ROLE_metrics")
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer().jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter());
    }
}
