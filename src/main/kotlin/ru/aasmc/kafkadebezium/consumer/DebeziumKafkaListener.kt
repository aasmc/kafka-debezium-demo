package ru.aasmc.kafkadebezium.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service
import ru.aasmc.avro.AvroProduct

private val log = LoggerFactory.getLogger(DebeziumKafkaListener::class.java)

@Service
class DebeziumKafkaListener {

    @KafkaListener(topics = ["debezium.public.products"], concurrency = "3")
    fun consumerDebeziumRecords(
        record: AvroProduct,
        @Header(KafkaHeaders.RECEIVED_KEY) key: String,
        @Header(KafkaHeaders.RECEIVED_PARTITION) partition: Int
    ) {
        log.info(
            "Consuming record from kafka. Key {}. Record {}. Partition: {}. Thread: {}",
            key,
            record,
            partition,
            Thread.currentThread().name
        )
        log.info("Value from record: {}", record)
    }

}