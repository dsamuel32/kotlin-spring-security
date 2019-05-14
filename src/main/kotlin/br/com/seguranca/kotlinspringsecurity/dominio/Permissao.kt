package br.com.seguranca.kotlinspringsecurity.dominio

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable

class Permissao (
        var id: Long,
        var descricao: String
) : GrantedAuthority, Serializable {
    override fun getAuthority(): String {
        return this.descricao
    }
}