package com.service

import java.util.LinkedList

data class WiseSaying(var id: Int, var content: String, var author: String)

class WiseSayingService {
    private val sayings = LinkedList<WiseSaying>()
    private var lastId = 0

    fun add(content: String, author: String): WiseSaying {
        val quote = WiseSaying(++lastId, content, author)
        sayings.add(quote)
        return quote
    }

    fun findAll(): List<WiseSaying> = sayings

    fun findById(id: Int): WiseSaying? = sayings.find { it.id == id }

    fun delete(id: Int): Boolean {
        val target = findById(id)
        return if (target != null) {
            sayings.remove(target)
            true
        } else {
            false
        }
    }

    fun update(id: Int, content: String, author: String): Boolean {
        val target = findById(id)
        return if (target != null) {
            target.content = content
            target.author = author
            true
        } else {
            false
        }
    }
}