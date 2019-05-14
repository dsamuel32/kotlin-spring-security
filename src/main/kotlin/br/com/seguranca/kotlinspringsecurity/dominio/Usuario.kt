package br.com.seguranca.kotlinspringsecurity.dominio

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class Usuario (
        var nome: String = "dev",
        var senha: String = "dev",
        var login: String = "dev",
        var permissoes: MutableSet<Permissao> = mutableSetOf()
): UserDetails {


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.permissoes
    }

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = this.login

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = this.senha

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

}