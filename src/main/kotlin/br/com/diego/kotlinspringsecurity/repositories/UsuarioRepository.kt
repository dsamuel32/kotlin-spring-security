package br.com.diego.kotlinspringsecurity.repositories

import br.com.diego.kotlinspringsecurity.dominio.User
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String?) : User?

}