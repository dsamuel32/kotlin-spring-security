package br.com.seguranca.kotlinspringsecurity.service

import br.com.seguranca.kotlinspringsecurity.dominio.Permissao
import br.com.seguranca.kotlinspringsecurity.dominio.Usuario
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService : UserDetailsService {

    override fun loadUserByUsername(login: String?): UserDetails {
        val permissoes = mutableSetOf<Permissao>(Permissao(1, "ADM"))
        return Usuario(permissoes = permissoes)
    }

}