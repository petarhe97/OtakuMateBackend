package com.mist.otakumate.AniChartRequest

import com.github.kittinunf.fuel.Fuel
import com.google.gson.JsonObject
import com.google.gson.JsonParser

object AniChartService {

    fun testRequest() : JsonObject {
        val id = 15125

        val testerino = "{\"query\":\"\\nquery (${'$'}id: Int) {\\n  Media (id: ${'$'}id, type: ANIME) { \\n    id\\n    title { \\n      romaji \\n      english \\n      native \\n    } \\n  } \\n}\",\"variables\":{\"id\":15125}}"

        val (_, response, _) = Fuel.post("https://graphql.anilist.co")
                .jsonBody(testerino)
                .also{ print(it) }
                .response()

        if (response.statusCode == 200) {
            return JsonParser().parse(String(response.data)).asJsonObject
        } else {
            return JsonParser().parse(String(response.data)).asJsonObject
            //throw Exception("status code : ${response.statusCode}")
        }

    }
}