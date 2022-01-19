package br.com.diego.kotlinspringsecurity.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val nome: String,
    val password: String,
    val email: String,
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarios_permissoes")
    val permissoes: Set<Permissao> = mutableSetOf()
)