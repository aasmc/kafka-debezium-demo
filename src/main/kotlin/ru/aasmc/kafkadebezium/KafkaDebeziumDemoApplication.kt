package ru.aasmc.kafkadebezium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaDebeziumDemoApplication

fun main(args: Array<String>) {
    runApplication<KafkaDebeziumDemoApplication>(*args)
}
