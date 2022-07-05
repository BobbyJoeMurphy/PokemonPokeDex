package com.example.Data

import com.example.Data.Result
import java.io.Serializable

data class Pokemon(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>

): Serializable