package org.example

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class MyWebSocketClient(serverUri: URI) : WebSocketClient(serverUri) {
    override fun onOpen(handshakedata: ServerHandshake?) {
        println("Connected to server")
        // Perform any actions you need after connection
    }

    override fun onMessage(message: String?) {
        println("Received message: $message")
        // Handle received messages here
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println("Connection closed by $reason")
        // Perform any cleanup tasks here
    }

    override fun onError(ex: Exception?) {
        println("Error occurred: ${ex?.message}")
        // Handle errors here
    }
}

fun main() {
    println("LOLOS1")
    val serverUri = URI("ws://localhost:8082/websocket")
    println("LOLOS2")
    val client = MyWebSocketClient(serverUri)
    println("LOLOS3")

    try {
        client.connect()
    } catch (e: Exception) {
        println("Failed to connect to server: ${e.message}")
    }
}
