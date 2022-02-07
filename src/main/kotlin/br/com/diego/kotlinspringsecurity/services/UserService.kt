package br.com.diego.kotlinspringsecurity.services

import br.com.diego.kotlinspringsecurity.dominio.dtos.UserDTO
import br.com.diego.kotlinspringsecurity.repositories.UsuarioRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class UserService (private val userRepository: UsuarioRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String?) =
        userRepository.findByEmail(email) ?: throw EntityNotFoundException("Username: $email not found.")

    fun getUser() : UserDTO {
        val auth = SecurityContextHolder.getContext().authentication
        val user = loadUserByUsername(auth.name)
        return UserDTO(user.name, user.email)
    }

}