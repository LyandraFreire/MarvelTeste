package com.example.marveltestitau.utils

import java.security.MessageDigest


object HashUtils {
    fun generateHash(timestamp: String = System.currentTimeMillis().toString()): String {
        val publicKey = "85fb293bdb9194854bc386c1a078e0a0"
        val privateKey = "63795f3895797417d2d8e2f85cb9f53be1824bb5"
        val hashInput = "$timestamp$privateKey$publicKey"
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(hashInput.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}