package br.com.diego.kotlinspringsecurity.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["login"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class LoginController {



}