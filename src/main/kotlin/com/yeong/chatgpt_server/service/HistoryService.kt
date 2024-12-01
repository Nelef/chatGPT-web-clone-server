package com.yeong.chatgpt_server.service

import com.yeong.chatgpt_server.dto.CreateHistoryRequest
import com.yeong.chatgpt_server.entity.History
import com.yeong.chatgpt_server.repository.HistoryRepository
import org.springframework.stereotype.Service

@Service
class HistoryService(private val repository: HistoryRepository) {
    fun getAll(): List<History> = repository.findAll()
    fun getById(id: Long): History = repository.findById(id).orElseThrow { IllegalArgumentException("History not found") }
    fun create(request: CreateHistoryRequest): History {
        val history = History(
            name = request.name,
            value = request.value
        )
        return repository.save(history)
    }
    fun update(id: Long, updatedHistory: History): History {
        val existingHistory = getById(id)
        return repository.save(existingHistory.copy(name = updatedHistory.name, value = updatedHistory.value))
    }
    fun delete(id: Long) = repository.deleteById(id)
}