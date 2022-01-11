package br.com.diego.kotlinspringsecurity.services

import br.com.diego.kotlinspringsecurity.dominio.Usuario
import br.com.diego.kotlinspringsecurity.dominio.security.UsuarioAutenticado
import br.com.diego.kotlinspringsecurity.repositories.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(email) ?: throw EntityNotFoundException("Usuario com username: $email não encontrado.")
        return UsuarioAutenticado(usuario)
    }
}