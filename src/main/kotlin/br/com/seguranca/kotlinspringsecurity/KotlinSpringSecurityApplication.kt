package br.com.seguranca.kotlinspringsecurity

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class KotlinSpringSecurityApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringSecurityApplication>(*args)
}
