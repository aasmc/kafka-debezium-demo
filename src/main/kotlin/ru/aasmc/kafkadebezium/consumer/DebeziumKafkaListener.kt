package ru.aasmc.kafkadebezium.consumer

import debezium.`public$`.products.Value
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val log = LoggerFactory.getLogger(DebeziumKafkaListener::class.java)

@Service
class DebeziumKafkaListener {

    @KafkaListener(topics = ["debezium.public.products"], concurrency = "3")
    fun consumerDebeziumRecords(record: ConsumerRecord<String, Value>) {
        log.info("Consuming record from kafka. Key {}. Record {}. Partition: {}. Thread: {}",
            record.key(),
            record.value(),
            record.partition(),
            Thread.currentThread().name
        )
        val value = record.value()
        log.info("Value from record: {}", value)
    }

}