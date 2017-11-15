package hello;

/*
created by PopoPenguin on 11/14/17
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //fluid library chaining methods
        http
                //you can only see these pages before you can authenticated
                .authorizeRequests()
                //anyone who types can go there
                .antMatchers("/", "/home").permitAll()
                //if they make a request it must be authenticated
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //direct to login page
                .loginPage("/login")
                //anyone can get to login
                .permitAll()
                .and()
                .logout()
                //anyone can logout
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
