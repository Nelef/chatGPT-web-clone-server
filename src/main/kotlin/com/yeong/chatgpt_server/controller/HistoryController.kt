package com.yeong.chatgpt_server.controller

import com.yeong.chatgpt_server.dto.CreateHistoryRequest
import com.yeong.chatgpt_server.entity.History
import com.yeong.chatgpt_server.service.HistoryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/histories")
class HistoryController(private val service: HistoryService) {

    @Operation(summary = "모든 기록 조회", description = "데이터베이스에 저장된 모든 기록을 조회합니다.")
    @GetMapping
    fun getAll(): List<History> = service.getAll()

    @Operation(summary = "ID로 기록 조회", description = "특정 ID를 사용하여 단일 기록을 조회합니다.")
    @Parameter(name = "id", description = "조회하려는 기록의 ID", required = true)
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): History = service.getById(id)

    @Operation(summary = "새 기록 생성", description = "새로운 기록을 데이터베이스에 생성합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "기록이 성공적으로 생성됨"),
            ApiResponse(responseCode = "400", description = "잘못된 요청")
        ]
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateHistoryRequest): History {
        return service.create(request)
    }
    @Operation(summary = "기존 기록 수정", description = "기존 기록의 key와 value를 수정합니다.")
    @PutMapping("/{id}")
    fun update(
        @Parameter(name = "id", description = "수정하려는 기록의 ID", required = true)
        @PathVariable id: Long,
        @RequestBody updatedHistory: History
    ): History = service.update(id, updatedHistory)

    @Operation(summary = "기록 삭제", description = "특정 ID를 사용하여 기록을 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @Parameter(name = "id", description = "삭제하려는 기록의 ID", required = true)
        @PathVariable id: Long
    ) = service.delete(id)
}