package br.com.diego.kotlinspringsecurity.components.security

import br.com.diego.kotlinspringsecurity.services.UsuarioService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWT (private val usuarioService: UsuarioService) {

    @Value(value = "\${tempoExpiracao}")
    private var tempoExpiracao: Long = 0

    @Value(value = "\${secret}")
    private lateinit var secret: String

    fun gerarToken(userName: String, authorities: MutableCollection<out GrantedAuthority>): String {
        return Jwts.builder()
            .setSubject(userName)
            .claim("role", authorities)
            .setExpiration(Date(System.currentTimeMillis() + tempoExpiracao))
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
            .compact()
    }

    fun isValido(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun getAuthentication(token: String?) : Authentication {
        val userName = Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body.subject
        val usuario = usuarioService.loadUserByUsername(userName)
        return UsernamePasswordAuthenticationToken(userName, null, usuario.authorities)
    }
}