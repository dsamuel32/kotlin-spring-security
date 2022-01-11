package br.com.diego.kotlinspringsecurity.dominio.security

import br.com.diego.kotlinspringsecurity.dominio.Usuario
import org.springframework.security.core.userdetails.UserDetails

class UsuarioAutenticado (private val usuario: Usuario) : UserDetails {

    override fun getAuthorities() = null

    override fun getPassword() = this.usuario.password

    override fun getUsername() = this.usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}