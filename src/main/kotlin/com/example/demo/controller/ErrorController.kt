package com.example.demo.controller

import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*


@RestController
class ErrorController {
    @GetMapping("/error")
    fun commonError() : Any {
        return "oh,happen some errors!"
    }
}