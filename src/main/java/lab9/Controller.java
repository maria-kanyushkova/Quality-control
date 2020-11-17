package lab9;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.json.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Controller {
    private static final String BASE_PATH  = "http://52.136.215.164:9000/api";
    private static final String ALL_PRODUCTS = "/products";
    private static final String DELETE_BY_ID = "/deleteproduct";
    private static final String ADD_PRODUCT = "/addproduct";
    private static final String EDIT_PRODUCT = "/editproduct";

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_PATH)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();

    void getProducts() {
        given()
                .spec(requestSpecification)
                .when()
                .get(ALL_PRODUCTS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    Integer addProduct(JSONObject object) {
        ResponseBodyExtractionOptions responseBodyExtractionOptions = given()
                .spec(requestSpecification)
                .body(object.toString())
                .when()
                .post(ADD_PRODUCT)
                .then()
                .body("status", equalTo(1))
                .extract().body();

        return responseBodyExtractionOptions.path("id");
    }

    private Collection<Product> getAllGoods() {
        return given()
                .spec(requestSpecification)
                .get(ALL_PRODUCTS)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<Product>>() {
                });
    }

    Product getProductById(Integer id) {
        Collection<Product> products = getAllGoods();
        return products.stream().filter(i -> i.getId().equals(id.toString())).findFirst().orElseThrow();
    }

    void editProduct(JSONObject object) {
        given()
                .spec(requestSpecification)
                .body(object.toString())
                .when()
                .post(EDIT_PRODUCT)
                .then()
                .body("status", equalTo(1))
                .extract().body();
    }

    void deleteProduct(Integer id) {
        given()
                .spec(requestSpecification)
                .param("id", id)
                .when()
                .get(DELETE_BY_ID)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
