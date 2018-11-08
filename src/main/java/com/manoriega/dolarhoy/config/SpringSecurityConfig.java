//package com.manoriega.dolarhoy.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import sun.security.util.Password;
//
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
//
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        User.UserBuilder user = User.builder().passwordEncoder(encoder::encode);
//
//        build.inMemoryAuthentication().withUser(user.username("admin").password("1234").roles("ADMIN", "USER"))
//                .withUser(user.username("manuel").password("1313").roles("USER"));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/","/dolar/**", "/css/**", "/js/**", "/images/**").permitAll()
//                .antMatchers("form").hasAnyRole("ADMIN").anyRequest().authenticated();
//    }
//}
