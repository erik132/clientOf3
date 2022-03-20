package erik.soekov.clientOf3.security.config;

import erik.soekov.clientOf3.general.constants.LinkLib;
import erik.soekov.clientOf3.security.service.RedTapeAirlinesUserDetailsService;
import erik.soekov.clientOf3.security.service.RedTapeAirlinesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/security/registration*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/security/login").defaultSuccessUrl(LinkLib.defaultGreetings).permitAll()
                .and().logout().permitAll();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new RedTapeAirlinesUserDetailsService();
    }

    @Bean
    public RedTapeAirlinesUserService redTapeAirlinesUserService(){
        return new RedTapeAirlinesUserDetailsService();
    }
}
