package br.com.seguranca.kotlinspringsecurity.configuracao

import br.com.seguranca.kotlinspringsecurity.apresentacao.Paths
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer


@Configuration
@EnableResourceServer
@EnableWebSecurity
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId("restservice")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers(Paths.AMBIENTE_SEGURO).authenticated()
        http.headers().contentTypeOptions().disable()
    }

}