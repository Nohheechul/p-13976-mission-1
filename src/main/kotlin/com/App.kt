package com

import com.controller.WiseSayingController


class App(
    private val wiseSayingController: WiseSayingController,
) {
    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val input = readlnOrNull()?.trim() ?: continue
            val rq = Rq(input) // 요청 파서

            when (rq.action) {
                "종료" -> {
                    println("앱을 종료합니다.")
                    break
                }
                "등록" -> wiseSayingController.actionWrite(rq)
                "목록" -> wiseSayingController.actionList(rq)
                "삭제" -> wiseSayingController.actionDelete(rq)
                "수정" -> wiseSayingController.actionModify(rq)
                else -> println("알 수 없는 명령입니다.")
            }
        }
    }
}