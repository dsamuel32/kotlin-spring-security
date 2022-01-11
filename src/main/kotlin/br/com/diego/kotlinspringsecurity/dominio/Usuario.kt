package br.com.diego.kotlinspringsecurity.dominio

import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val nome: String,
    val password: String,
    val email: String
)