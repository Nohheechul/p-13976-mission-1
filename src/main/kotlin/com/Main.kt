package com

import com.controller.WiseSayingController
import com.service.WiseSayingService
import kotlin.run

fun main() {
    val wiseSayingService = WiseSayingService()
    val wiseSayingController = WiseSayingController(wiseSayingService)

    val app = App(wiseSayingController)
    app.run()
}