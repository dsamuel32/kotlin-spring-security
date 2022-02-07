package br.com.diego.kotlinspringsecurity.dominio

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "pemissions")
data class Permission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
) : GrantedAuthority {
    override fun getAuthority() = name
}