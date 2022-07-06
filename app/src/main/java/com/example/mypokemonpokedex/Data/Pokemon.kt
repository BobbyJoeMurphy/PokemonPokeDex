package com.example.Data

import java.io.Serializable
//data classes
data class Pokemon(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>

): Serializable