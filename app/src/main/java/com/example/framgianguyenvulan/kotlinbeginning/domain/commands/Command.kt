package com.example.framgianguyenvulan.kotlinbeginning.domain.commands

interface Command<out T> {
    fun execute(): T
}