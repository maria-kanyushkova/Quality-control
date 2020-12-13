const allProductsPath = "http://91.210.252.240:9010/api/products"
const addProductPath = "http://91.210.252.240:9010/api/addproduct"
const editProductPath = "http://91.210.252.240:9010/api/editproduct"
const deleteProductPath = "http://91.210.252.240:9010/api/deleteproduct?id="

const MAX_TIMEOUT = 10000
const STATUS_CREATED = 1
const STATUS_SUCCESSFUL_DELETE = 1
const STATUS_UNSUCCESSFUL_DELETE = 0
const STATUS_SUCCESSFUL_EDIT = 1
const STATUS_UNSUCCESSFUL_EDIT = 0
const NON_EXISTENT_PRODUCT_ID = 0

module.exports = {
    allProductsPath,
    addProductPath,
    editProductPath,
    deleteProductPath,

    MAX_TIMEOUT,
    STATUS_CREATED,
    STATUS_SUCCESSFUL_DELETE,
    STATUS_UNSUCCESSFUL_DELETE,
    STATUS_SUCCESSFUL_EDIT,
    STATUS_UNSUCCESSFUL_EDIT,
    NON_EXISTENT_PRODUCT_ID
}