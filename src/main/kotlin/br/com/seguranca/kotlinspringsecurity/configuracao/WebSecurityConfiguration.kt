package br.com.seguranca.kotlinspringsecurity.configuracao

import br.com.seguranca.kotlinspringsecurity.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.NoOpPasswordEncoder


@Configuration
@EnableWebSecurity
class WebSecurityConfiguration (val usuarioService: UsuarioService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UsuarioService>(this.usuarioService)
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @SuppressWarnings("deprecation")
    @Bean
    fun passwordEncoder(): NoOpPasswordEncoder {
        return NoOpPasswordEncoder.getInstance() as NoOpPasswordEncoder
    }

}