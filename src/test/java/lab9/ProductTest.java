package lab9;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import java.util.LinkedHashSet;

class ProductTest {
    private static Controller controller;
    private static final LinkedHashSet<Integer> productIds = new LinkedHashSet<>();

    ProductTest() {
        controller = new Controller();
    }

    private void addProductId(Integer id) {
        productIds.add(id);
    }

    private Integer getLastId() {
        if (!productIds.isEmpty()) {
            return productIds.stream().skip(productIds.size() - 1).findFirst().get();
        }
        return 0;
    }

    @Test
    void getProducts_ReturnsAllProducts() {
        controller.getProducts();
        System.out.println("All products returned");
    }

    @Test
    void addProduct_ZeroPrice_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectZeroPrice());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with zero price added, key " + productId);
    }

    @Test
    void addProduct_NegativePrice_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectNegativePrice());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with negative price added, key " + productId);
    }

    @Test
    void editProduct_ChangeNegativePriceOnPositivePrice_ReturnsProductCreated() {
        JSONObject object = TestData.getJsonObjectPositivePrice();
        Integer productId = getLastId();

        JSONObject updateObject = TestData.getChangeValueObject(object, productId);
        controller.editProduct(updateObject);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));

        System.out.println("Product with negative price edited on product with positive price, key " + productId);
    }

    @Test
    void addProduct_OverflowPrice_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectOverflowPrice());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with overflow price added, key " + productId);
    }

    @Test
    void addProduct_MinCategoryId_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectMinCategoryId());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with min category_id added, key " + productId);
    }

    @Test
    void addProduct_StatusZero_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectStatusZero());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with status zero added, key " + productId);
    }

    @Test
    void addProduct_EmptyTitle_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectEmptyTitle());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with empty title added, key " + productId);
    }

    @Test
    void addProduct_ExistsAlias_ReturnsProductCreated() {
        Integer productId = controller.addProduct(TestData.getJsonObjectExistsAlias());
        addProductId(productId);
        TestData.getJsonObjectZeroPrice().equals(controller.getProductById(productId));
        System.out.println("Product with alias added, key " + productId);
    }

    @Test
    void deleteCreatedProduct_Product_ReturnsProductDeleted() {
        for (Integer id: productIds) {
            controller.deleteProduct(id);
            System.out.println("Product removed, key " + id);
        }
    }
}