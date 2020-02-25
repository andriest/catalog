package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._


class ProductControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

    "ApiController" should {

        "render get products" in {
            val request = FakeRequest(GET, "/v1/products")
            val products = route(app, request).get

            status(products) mustBe OK
            contentType(products) mustBe Some("application/json")
        }

        "render create product" in {
            val data = ProductData("Produk 1", Seq(1, 2), 12000.0, Seq(3, 4))
            val json = Json.toJson(data)
            val request = FakeRequest(POST, "/v1/products").withJsonBody(json)
            val product = route(app, request).get

            status(product) mustBe CREATED
            contentType(product) mustBe Some("application/json")
            contentAsString(product) mustBe "1"
        }

    }

}
