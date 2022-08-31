package com.example.studioghiblifilms.model

import java.io.Serializable

data class Film(
    val title: String,
    val originalTitle: String,
    val realeseDate: String,
    val photo: String,
    val link: String
): Serializable
