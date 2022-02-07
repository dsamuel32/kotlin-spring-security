package br.com.diego.kotlinspringsecurity.controllers

import br.com.diego.kotlinspringsecurity.services.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["users"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class UserController (private val userService: UserService) {

    @GetMapping
    fun getUser() = userService.getUser()

}