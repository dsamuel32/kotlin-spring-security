package br.com.seguranca.kotlinspringsecurity.apresentacao

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ Paths.AMBIENTE_SEGURO ], produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class AmbienteSerguro {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun ambiete() = mutableSetOf("ambiente" to "seguro")

}