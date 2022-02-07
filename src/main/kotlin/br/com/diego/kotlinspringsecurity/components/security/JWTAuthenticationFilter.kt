package br.com.diego.kotlinspringsecurity.components.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(private val jwt: JWT) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        val jwtToken = extractToken(token)

        if (jwt.isValid(jwtToken)) {
            SecurityContextHolder.getContext().authentication = jwt.getAuthentication(jwtToken)
        }
        filterChain.doFilter(request, response)
    }

    private fun extractToken(token: String?) : String? {
        return token?.let { jwt ->
            jwt.startsWith("Bearer ")
            jwt.substring(7, jwt.length)
        }
    }

}
