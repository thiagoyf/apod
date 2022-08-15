package com.thiagoyf.core_network.model

data class NetworkApod(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String,
    val url: String,
)