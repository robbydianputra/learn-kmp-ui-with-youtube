package com.bagicode.belajarkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform