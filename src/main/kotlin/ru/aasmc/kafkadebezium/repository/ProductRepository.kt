package ru.aasmc.kafkadebezium.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.aasmc.kafkadebezium.model.Product

interface ProductRepository: JpaRepository<Product, Long> {
}