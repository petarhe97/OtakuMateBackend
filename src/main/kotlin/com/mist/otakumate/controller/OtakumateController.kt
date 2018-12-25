package com.mist.otakumate.controller

import com.google.gson.JsonObject
import com.mist.otakumate.AniChartRequest.AniChartService
import com.mist.otakumate.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OtakumateController {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name : String) : String {
        val thing = AniChartService.testRequest()
        //return Greeting("Hello $name $thing")
        return thing["data"].toString()
    }
}