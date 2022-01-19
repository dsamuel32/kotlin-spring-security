package br.com.diego.kotlinspringsecurity.dominio

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "pemissoes")
data class Permissao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val nome: String,
) : GrantedAuthority {
    override fun getAuthority() = nome
}