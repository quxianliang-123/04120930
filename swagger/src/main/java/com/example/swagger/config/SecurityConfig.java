//package com.example.swagger.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfig {

//    private final KeycloakLogoutHandler keycloakLogoutHandler;
//
//    SecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler) {
//        this.keycloakLogoutHandler = keycloakLogoutHandler;
//    }

//	@Bean
//	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/**")
//				.permitAll()
//				.anyRequest()
//				.authenticated();
//		//    http.oauth2Login()
//		//        .and()
//		//        .logout()
//		//        .addLogoutHandler(keycloakLogoutHandler)
//		//        .logoutSuccessUrl("/");
//		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//		return http.build();
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//		return http.getSharedObject(AuthenticationManagerBuilder.class)
//				.build();
//	}
//}

//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Autowired
//    private SecurityAuthenticationProvider authenticationProvider;

//    @Autowired
//    private KeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter;
//
//    @Autowired
//    private KeycloakPreAuthActionsFilter keycloakPreAuthActionsFilter;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    @Bean
//    public KeycloakConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Bean
//    public FilterRegistrationBean keycloakAuthenticationProcessingFilterRegistrationBean(
//            KeycloakAuthenticationProcessingFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setEnabled(true);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean keycloakPreAuthActionsFilterRegistrationBean(
//            KeycloakPreAuthActionsFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setEnabled(true);
//        return registrationBean;
//    }
//
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new NullAuthenticatedSessionStrategy();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        http
////                .anyRequest().permitAll();
//    	
//        http.authorizeRequests()
//        .antMatchers("/*")
//        .permitAll();
//        
//        http
//                //.addFilterBefore(mySecurityInterceptor, FilterSecurityInterceptor.class)
//                .addFilterBefore(keycloakAuthenticationProcessingFilter, FilterSecurityInterceptor.class)
//                .addFilterBefore(keycloakPreAuthActionsFilter, KeycloakAuthenticationProcessingFilter.class);
//    }
