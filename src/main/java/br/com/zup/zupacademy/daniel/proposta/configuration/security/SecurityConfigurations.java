package br.com.zup.zupacademy.daniel.proposta.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

    // Configurações de Autorização (diz quem pode acessar cada url, perfis de aceso etc)
    @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

        .antMatchers(HttpMethod.POST,"/proposta")
        .permitAll()

        .anyRequest()
        .authenticated()

        .and().csrf().disable() ;
    }
}
