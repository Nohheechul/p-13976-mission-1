package com

class Rq(command: String) {
    val action: String
    private val params: Map<String, String>

    init {
        val parts = command.split("?", limit = 2)
        action = parts[0]
        params = if (parts.size == 2) {
            parts[1].split("&").mapNotNull {
                val kv = it.split("=", limit = 2)
                if (kv.size == 2) kv[0] to kv[1] else null
            }.toMap()
        } else {
            emptyMap()
        }
    }

    fun getIntParam(name: String, default: Int): Int {
        return params[name]?.toIntOrNull() ?: default
    }
}