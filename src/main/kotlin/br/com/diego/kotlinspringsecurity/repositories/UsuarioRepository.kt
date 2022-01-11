package br.com.diego.kotlinspringsecurity.repositories

import br.com.diego.kotlinspringsecurity.dominio.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmail(email: String?) : Usuario?

}