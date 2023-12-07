package ru.aasmc.kafkadebezium.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "description", nullable = false)
    var description: String,
    @Column(name = "price", nullable = false)
    var price: BigDecimal
) {

    override fun toString(): String {
        return "Product [id=$id, name=$name, description=$description, price=$price]"
    }

}