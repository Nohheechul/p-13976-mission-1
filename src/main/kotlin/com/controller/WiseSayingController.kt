package com.controller

import com.Rq
import com.service.WiseSayingService

class WiseSayingController(
    private val wiseSayingService: WiseSayingService
) {
    fun actionWrite(rq: Rq) {
        print("명언 : ")
        val content = readlnOrNull()?.trim() ?: ""
        print("작가 : ")
        val author = readlnOrNull()?.trim() ?: ""

        val quote = wiseSayingService.add(content, author)
        println("${quote.id}번 명언이 등록되었습니다.")
    }

    fun actionList(rq: Rq) {
        val list = wiseSayingService.findAll()
        println("번호 / 작가 / 명언")
        println("----------------------")
        list.asReversed().forEach {
            println("${it.id} / ${it.author} / ${it.content}")
        }
    }

    fun actionDelete(rq: Rq) {
        val id = rq.getIntParam("id", 0)
        if (id == 0) {
            println("id를 입력해주세요.")
            return
        }

        if (wiseSayingService.delete(id)) {
            println("${id}번 명언이 삭제되었습니다.")
        } else {
            println("${id}번 명언은 존재하지 않습니다.")
        }
    }

    fun actionModify(rq: Rq) {
        val id = rq.getIntParam("id", 0)
        if (id == 0) {
            println("id를 입력해주세요.")
            return
        }

        val quote = wiseSayingService.findById(id)
        if (quote == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${quote.content}")
        print("명언 : ")
        val newContent = readlnOrNull()?.trim() ?: quote.content

        println("작가(기존) : ${quote.author}")
        print("작가 : ")
        val newAuthor = readlnOrNull()?.trim() ?: quote.author

        wiseSayingService.update(id, newContent, newAuthor)
    }
}