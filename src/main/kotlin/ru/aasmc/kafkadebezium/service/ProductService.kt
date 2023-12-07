package ru.aasmc.kafkadebezium.service

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import ru.aasmc.kafkadebezium.model.Product
import ru.aasmc.kafkadebezium.repository.ProductRepository
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import kotlin.random.Random

private val log = LoggerFactory.getLogger(ProductService::class.java)

@Component
class ProductService(
    private val repository: ProductRepository
) : ApplicationRunner {
    val random = Random(System.currentTimeMillis())
    override fun run(args: ApplicationArguments?) {
        while (true) {
            val product = generateRandomProduct()
            val saved = repository.save(product)
            log.info("Successfully saved product: {}", saved)
            TimeUnit.SECONDS.sleep(1)
            if (saved.id!! % 10 == 0L) {
                val prev = repository.findById(saved.id!! - 1).get()
                prev.description = "Updated description. Prev description: ${prev.description}"
                repository.save(prev)
            }
        }
    }

    private fun generateRandomProduct(): Product {
        val randomPrice = random.nextDouble()
        val price = BigDecimal.valueOf(randomPrice)
        val randomNum = random.nextInt()
        val name = "Product $randomNum"
        val description = "Description $randomNum"
        return Product(name = name, description = description, price = price)
    }
}