package ru.aasmc.kafkadebezium.consumer

import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val log = LoggerFactory.getLogger(DebeziumKafkaListener::class.java)

@Service
class DebeziumKafkaListener {

    @KafkaListener(topics = ["debezium.public.products"], concurrency = "10")
    fun consumerDebeziumRecords(record: ConsumerRecord<String, GenericRecord>) {
        log.info("Consuming record from kafka. Key {}. Record {}. Partition: {}. Thread: {}",
            record.key(),
            record.value(),
            record.partition(),
            Thread.currentThread().name
        )
    }

}