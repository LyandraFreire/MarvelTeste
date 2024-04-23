package com.example.marveltestitau.utils

import java.security.MessageDigest


fun generateHash(
    timestamp: String,
    publicKey: String,
    privateKey: String
): String {
    val hashInput = "$timestamp$privateKey$publicKey"
    val digest = MessageDigest.getInstance("MD5").digest(hashInput.toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}