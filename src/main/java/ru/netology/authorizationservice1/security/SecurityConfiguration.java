package ru.netology.authorizationservice1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    на 3м спринге не через наследование, а через анатацию @EnableWebSecurity и создание бинов
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain (http) {}
//    и
//    @Bean
//    UserDetailsService users(user) {}

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan").password(encoder().encode("password"))
                .authorities("read")
                .and()
                .withUser("Petr").password(encoder().encode("password1"))
                .roles("READ","WRITE")
                .and()
                .withUser("Egor").password(encoder().encode("password2"))
                .roles("READ")
                .and()
                .withUser("Vasia").password(encoder().encode("password3"))
                .roles("READ","DELETE");


//        запрос логина и пароля из базы данных
//        auth.jdbcAuthentication().authoritiesByUsernameQuery().usersByUsernameQuery();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/authorize").hasAuthority("read")
//                .and()
//                .authorizeRequests().antMatchers("/registration").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/hello").hasAuthority("read")
//                .and().authorizeRequests().anyRequest().authenticated();
//    }
}
