package br.com.seguranca.kotlinspringsecurity.configuracao

import br.com.seguranca.kotlinspringsecurity.service.UsuarioService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.context.annotation.Primary











@Configuration
@EnableAuthorizationServer
@EnableWebSecurity
class AuthorizationServerConfiguration (
        @Qualifier("authenticationManagerBean")
        private val authenticationManager: AuthenticationManager,
        private val usuarioService: UsuarioService
) : AuthorizationServerConfigurerAdapter() {

    private val tokenStore = InMemoryTokenStore()

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
                .tokenStore(this.tokenStore)
                .authenticationManager(this.authenticationManager)
                .userDetailsService(this.usuarioService)
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients
                .inMemory()
                .withClient("clientapp")
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("USER")
                .scopes("read", "write")
                .resourceIds("restservice")
                .secret("123456")
    }

    @Bean
    @Primary
    fun tokenServices(): DefaultTokenServices {
        val tokenServices = DefaultTokenServices()
        tokenServices.setSupportRefreshToken(true)
        tokenServices.setTokenStore(this.tokenStore)
        return tokenServices
    }

}