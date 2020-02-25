package repositories

import javax.inject.Singleton
import models.Product


@Singleton
class ProductRepository {

    private val products = Seq(
        Product(1, "Name 1", Seq(1, 2), 120000.0, Seq(3, 4)),
        Product(2, "Name 2", Seq(1, 2), 120000.0, Seq(3, 4)),
        Product(3, "Name 3", Seq(1, 2), 120000.0, Seq(3, 4)),
        Product(4, "Name 4", Seq(1, 2), 120000.0, Seq(3, 4)),
        Product(5, "Name 5", Seq(1, 2), 120000.0, Seq(3, 4))
    )

    def create(name: String, colors: Seq[Int], price: Double, categories: Seq[Int]): Product = {
        Product(1, name, colors, price, categories)
    }

    def getProducts(): Seq[Product] = {
        products
    }

}
