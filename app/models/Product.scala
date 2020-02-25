package models

import play.api.libs.json.Json


case class Product(id: Int, name: String, colors: Seq[Int], price: Double, categories: Seq[Int])


object Product {
    implicit val format = Json.format[Product]
}
