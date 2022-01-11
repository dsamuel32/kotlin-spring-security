package br.com.diego.kotlinspringsecurity.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["usuarios"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class UsuarioController {

    @GetMapping
    fun getUsuario() : Map<String, String> {
        return mapOf("teste" to "teste")
    }

}