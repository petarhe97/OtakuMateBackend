package com.mist.otakumate.controller

import com.mist.otakumate.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OtakumateController {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name : String) : Greeting {
        return Greeting("Hello $name")
    }
}