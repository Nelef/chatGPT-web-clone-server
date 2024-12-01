package com.yeong.chatgpt_server.repository

import com.yeong.chatgpt_server.entity.History
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository : JpaRepository<History, Long>
