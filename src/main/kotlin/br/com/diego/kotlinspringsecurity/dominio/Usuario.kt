package br.com.diego.kotlinspringsecurity.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "usuarios")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val nome: String,
    val senha: String,
    val email: String,
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_pemissoes",
        joinColumns = [ JoinColumn(name = "usuario_id")],
        inverseJoinColumns = [ JoinColumn(name = "permissao_id") ]
    )
    val permissoes: Set<Permissao> = mutableSetOf()
) : UserDetails {

    override fun getAuthorities() = this.permissoes

    override fun getPassword() = this.senha

    override fun getUsername() = this.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}