package br.com.diego.kotlinspringsecurity.config

import br.com.diego.kotlinspringsecurity.components.security.JWT
import br.com.diego.kotlinspringsecurity.components.security.JWTAuthenticationFilter
import br.com.diego.kotlinspringsecurity.components.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val userDetailsService: UserDetailsService,
    private val jwt: JWT
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http
            ?.csrf()?.disable()
            ?.authorizeRequests()
            ?.antMatchers("/users")?.hasAnyAuthority("READ")
            ?.antMatchers(HttpMethod.POST,"/login")?.permitAll()
            ?.anyRequest()?.authenticated()
            ?.and()
            ?.addFilterBefore(JWTLoginFilter(authManager = authenticationManager(), jwt = jwt), UsernamePasswordAuthenticationFilter().javaClass)
            ?.addFilterBefore(JWTAuthenticationFilter(jwt = jwt), UsernamePasswordAuthenticationFilter().javaClass)
            ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun bCryptPasswordEncoder() = BCryptPasswordEncoder()
}