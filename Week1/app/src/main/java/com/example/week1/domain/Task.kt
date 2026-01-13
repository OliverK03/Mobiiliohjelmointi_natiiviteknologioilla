package com.example.week1.domain

import java.time.LocalDate

enum class TaskPriority {
    LOW,
    MEDIUM,
    HIGH
}

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val priority: TaskPriority,
    val dueDate: LocalDate,
    val done: Boolean
)

val mockTasks: List<Task> = listOf(
    Task(
        id = 1L,
        title = "Siivoa keittiö",
        description = "Pese tiskit ja pyyhi tasot.",
        priority = TaskPriority.MEDIUM,
        dueDate = LocalDate.now().plusDays(1),
        done = false
    ),
    Task(
        id = 2L,
        title = "Käy kaupassa",
        description = "Osta maitoa, leipää ja kahvia.",
        priority = TaskPriority.LOW,
        dueDate = LocalDate.now().plusDays(2),
        done = false
    ),
    Task(
        id = 3L,
        title = "Projektiraportti",
        description = "Viimeistele kouluprojektin raportti.",
        priority = TaskPriority.HIGH,
        dueDate = LocalDate.now(),
        done = true
    ),
    Task(
        id = 4L,
        title = "Lenkki",
        description = "30 minuutin juoksulenkki.",
        priority = TaskPriority.MEDIUM,
        dueDate = LocalDate.now().plusDays(3),
        done = false
    ),
    Task(
        id = 5L,
        title = "Soita mummolle",
        description = "Kuulumisten vaihto.",
        priority = TaskPriority.LOW,
        dueDate = LocalDate.now().plusDays(1),
        done = true
    )
)
