package com.example.security.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Author：盛年华
 * @Date：2018/8/15 9:11
 * @Description:
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        /*spring 5.0 之后需要 加密， 否则 登录报错 */
       /* auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("forezp").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");*/
       /*创建多个用户角色 的时候 需要调用此方法。 可以重写 userDetailsService() 方法， 也可以实现 UserDetailsService 接口 */
        auth.userDetailsService(userDetailsService());
    }

    /*
    * 在设置多个对象时，需要返回加密对象。 可以设置 一些对称加密算法。需要实现 PasswordEncoder 接口
    *  security 默认推荐使用 BCryptPasswordEncoder 为加密方式。
    * */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* hasRole 表示为可以访问路径的 角色   permitAll 表示开放所设置的 路径 */
        http.authorizeRequests()
                .antMatchers("/css/**","index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }

    /* */
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("forezp").password(new BCryptPasswordEncoder().encode("123456")).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER").build());
        return manager;
    }
}
