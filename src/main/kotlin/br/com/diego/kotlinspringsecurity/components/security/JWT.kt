package br.com.diego.kotlinspringsecurity.components.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWT {

    @Value(value = "\${tempoExpiracao}")
    private var tempoExpiracao: Long = 0

    @Value(value = "\${secret}")
    private lateinit var secret: String

    fun gerarToken(userName: String): String {
        return Jwts.builder()
            .setSubject(userName)
            .setExpiration(Date(System.currentTimeMillis() + tempoExpiracao))
            .signWith(SignatureAlgorithm.ES512, secret.encodeToByteArray())
            .compact()
    }
}