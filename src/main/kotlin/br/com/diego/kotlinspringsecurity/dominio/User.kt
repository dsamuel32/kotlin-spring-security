package br.com.diego.kotlinspringsecurity.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val name: String,
    @Column(name = "password")
    val passWord: String,
    val email: String,
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_pemissions",
        joinColumns = [ JoinColumn(name = "user_id")],
        inverseJoinColumns = [ JoinColumn(name = "permission_id") ]
    )
    val permissions: Set<Permission> = mutableSetOf()
) : UserDetails {

    override fun getAuthorities() = this.permissions

    override fun getPassword() = this.passWord

    override fun getUsername() = this.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}