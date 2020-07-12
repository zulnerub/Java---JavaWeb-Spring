package bg.softuni.security.config;

import bg.softuni.security.user.DemoUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final DemoUserDetailsService demoUserDetailsService;


    public SecurityConfiguration(PasswordEncoder passwordEncoder,
                                 DemoUserDetailsService demoUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.demoUserDetailsService = demoUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(demoUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/h2_console/**", "/home").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .and()
                .formLogin();

        //h2 magic, TODO: delete me
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
