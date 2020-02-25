package controllers

import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import repositories.ProductRepository


case class ProductData(name: String, colors: Seq[Int], price: Double, categories: Seq[Int])

object ProductData {
    implicit val format = Json.format[ProductData]
}


@Singleton
class ProductController @Inject()(cc: ControllerComponents,
                                  dataRepository: ProductRepository) extends AbstractController(cc) {

    def create = Action { implicit request =>
        val json = request.body.asJson.get
        val product = json.as[ProductData]
        val created = dataRepository.create(product.name, product.colors, product.price, product.categories)
        Created(Json.toJson(created.id))
    }

    def getProducts = Action { implicit request =>
        Ok(Json.toJson(dataRepository.getProducts()))
    }

}
