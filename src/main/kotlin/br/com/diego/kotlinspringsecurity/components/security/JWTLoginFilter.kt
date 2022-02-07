package br.com.diego.kotlinspringsecurity.components.security

import br.com.diego.kotlinspringsecurity.dominio.dtos.CredencialDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTLoginFilter(
    private val authManager: AuthenticationManager,
    private val jwt: JWT
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val(user, password) = ObjectMapper().readValue(request?.inputStream, CredencialDTO::class.java)
        val token = UsernamePasswordAuthenticationToken(user, password)
        return authManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val user = (authResult?.principal as UserDetails)
        val token = jwt.genareteToken(user.username, user.authorities)
        response?.addHeader("Authorization", "Barear $token")
    }
}