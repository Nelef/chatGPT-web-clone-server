package com.yeong.chatgpt_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatgptServerApplication

fun main(args: Array<String>) {
	runApplication<ChatgptServerApplication>(*args)
}
