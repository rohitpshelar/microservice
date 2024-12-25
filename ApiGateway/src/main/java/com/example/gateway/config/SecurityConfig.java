package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Client()
                .and()
                .oauth2ResourceServer()
                .jwt()
//                .authorizeExchange((exchanges) -> exchanges
//                        .anyExchange().authenticated())
//                .anyExchange()
//                .authenticated()
//                .and()
//                .oauth2Client()
//                .and()
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
                ;

        return serverHttpSecurity.build();

    }
}