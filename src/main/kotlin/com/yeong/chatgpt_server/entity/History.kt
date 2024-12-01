package com.yeong.chatgpt_server.entity

import jakarta.persistence.*

@Entity
@Table(name = "history")
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(nullable = false)
    val value: String
)