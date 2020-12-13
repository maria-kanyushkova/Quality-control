const {it, describe, beforeEach, afterEach} = require("@jest/globals");

const {
    MAX_TIMEOUT,
    STATUS_CREATED,
    STATUS_SUCCESSFUL_DELETE,
    STATUS_UNSUCCESSFUL_DELETE,
    NON_EXISTENT_PRODUCT_ID,
    STATUS_SUCCESSFUL_EDIT,
    STATUS_UNSUCCESSFUL_EDIT,
} = require('./config.js')
const {defaultProduct} = require('./test-data.js')
const Controller = require("./controller.js");
const controller = new Controller();

describe('test Api', () => {
    it('чтение товаров', async () => {
        const products = await controller.getAllProducts()
        console.log(products)
        expect(products).not.toBeNull();
    }, MAX_TIMEOUT)

    describe('создание товара', () => {
        it('создание товара', async () => {
            const product = await controller.addProduct(defaultProduct)
            const expectedProduct = {
                ...defaultProduct,
                id: `${product.id}`
            }
            const receivedProduct = await controller.getProduct(product.id)
            await controller.deleteProduct(product.id)
            expect(receivedProduct).toStrictEqual(expectedProduct)
        }, MAX_TIMEOUT)

        it('создание существующего товара', async () => {
            const product1 = await controller.addProduct(defaultProduct)
            const product2 = await controller.addProduct(defaultProduct)
            const expectedProduct = {
                ...defaultProduct,
                id: `${product2.id}`,
                alias: defaultProduct.alias + "-0"
            }
            const receivedProduct = await controller.getProduct(product2.id)
            await controller.deleteProduct(product1.id)
            await controller.deleteProduct(product2.id)
            expect(receivedProduct).toStrictEqual(expectedProduct)
        }, MAX_TIMEOUT)
    })

    describe('удаление товара', () => {
        it('удаление существующего товара', async () => {
            const product = await controller.addProduct(defaultProduct)
            expect(product.status).toBe(STATUS_CREATED)
            const response = await controller.deleteProduct(product.id)
            expect(response.status).toBe(STATUS_SUCCESSFUL_DELETE)
        }, MAX_TIMEOUT)

        it('удаление не существующего товара', async () => {
            const response = await controller.deleteProduct(NON_EXISTENT_PRODUCT_ID)
            expect(response.status).toBe(STATUS_UNSUCCESSFUL_DELETE)
        }, MAX_TIMEOUT)
    })

    describe('редактирование', () => {
        it('несуществующего товара', async () => {
            const product = {
                ...defaultProduct,
                id: `${NON_EXISTENT_PRODUCT_ID}`
            }
            const response = await controller.editProduct(product)
            expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
        }, MAX_TIMEOUT)

        describe('существующего товара', () => {
            const NEW_EXIST_CATEGORY_ID = "5"
            const NEW_NON_EXIST_CATEGORY_ID = "0"

            const NEW_TITLE = "Product New"
            const NEW_EXIST_TITLE = "Product"
            const NEW_EMPTY_TITLE = ""

            const NEW_ALIAS = "product-89"
            const NEW_EXIST_ALIAS = "product"
            const NEW_EMPTY_ALIAS = ""

            const NEW_CONTENT = "<p>Lorem ipsum dolor sit</p>"
            const NEW_EMPTY_CONTENT = ""

            const NEW_PRICE = "89"
            const NEW_ZERO_PRICE = "0"
            const NEW_NEGATIVE_PRICE = "-89"
            const NEW_INFINITE_PRICE = `${Number.POSITIVE_INFINITY + 1}`

            const NEW_OLD_PRICE = "11"
            const NEW_ZERO_OLD_PRICE = "0"
            const NEW_NEGATIVE_OLD_PRICE = "-89"
            const NEW_INFINITE_OLD_PRICE = `${Number.POSITIVE_INFINITY + 1}`

            const NEW_EXIST_STATUS = "0"
            const NEW_NON_EXIST_STATUS = "2"

            const NEW_KEYWORDS = "keywords new"
            const NEW_EMPTY_KEYWORDS = ""

            const NEW_DESCRIPTION = "description new"
            const NEW_EMPTY_DESCRIPTION = ""

            const NEW_EXIST_HIT = "0"
            const NEW_NON_EXIST_HIT = "2"

            let productId = 0;

            beforeEach(async () => {
                const product = await controller.addProduct(defaultProduct)
                productId = product.id;
            })

            afterEach(async () => {
                await controller.deleteProduct(productId)
            })

            it('изменение категории на существующую (1, 15)', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    category_id: `${NEW_EXIST_CATEGORY_ID}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                console.log(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.category_id).toBe(NEW_EXIST_CATEGORY_ID)
            }, MAX_TIMEOUT)

            it('изменение категории на не существующую не (1, 15)', async () => {
                // TODO: статус обновления приходит 1, но продукта не существует после обновления, хотя он создавался
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    category_id: `${NEW_NON_EXIST_CATEGORY_ID}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение названия', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    title: `${NEW_TITLE}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.title).toBe(NEW_TITLE)
            }, MAX_TIMEOUT)

            it('изменение названия на существующее', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    title: `${NEW_EXIST_TITLE}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.title).toBe(NEW_EXIST_TITLE)
            }, MAX_TIMEOUT)

            it('изменение названия на пустое', async () => {
                // TODO: поле title должно быть обязательным, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    title: `${NEW_EMPTY_TITLE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение alias', async () => {
                // TODO: alias на свой изменить нельзя
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    alias: `${NEW_ALIAS}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.alias).toBe(NEW_ALIAS)
            }, MAX_TIMEOUT)

            it('изменение alias на существующий', async () => {
                // TODO: alias на свой изменить нельзя префикс "-0" не добавляется
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    alias: `${NEW_EXIST_ALIAS}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.alias).toBe(productData.alias + "-0")
            }, MAX_TIMEOUT)

            it('изменение alias на пустой', async () => {
                // TODO: поле alias должно быть обязательным, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    alias: `${NEW_EMPTY_ALIAS}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение контента', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    content: `${NEW_CONTENT}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.content).toBe(NEW_CONTENT)
            }, MAX_TIMEOUT)

            it('изменение контента на пустой', async () => {
                // TODO: поле content должно быть обязательным, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    content: `${NEW_EMPTY_CONTENT}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение цены', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    price: `${NEW_PRICE}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.price).toBe(NEW_PRICE)
            }, MAX_TIMEOUT)

            it('изменение цены на 0', async () => {
                // TODO: поле price должно быть больше 0, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    price: `${NEW_ZERO_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение цены на отрицательное', async () => {
                // TODO: поле price должно быть положительным числом, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    price: `${NEW_NEGATIVE_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение цены на бесконечность', async () => {
                // TODO: поле price не может быть бесконечным числом, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    price: `${NEW_INFINITE_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение старой цены', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    old_price: `${NEW_PRICE}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.old_price).toBe(NEW_PRICE)
            }, MAX_TIMEOUT)

            it('изменение старой цены на 0', async () => {
                // TODO: поле old_price должно быть больше 0, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    old_price: `${NEW_ZERO_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение старой цены на отрицательное', async () => {
                // TODO: поле old_price должно быть положительным числом, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    old_price: `${NEW_NEGATIVE_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение старой цены на бесконечность', async () => {
                // TODO: поле old_price не может быть бесконечным числом, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    old_price: `${NEW_INFINITE_PRICE}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение статуса на существующий (0, 1)', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    status: `${NEW_EXIST_STATUS}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.status).toBe(NEW_EXIST_STATUS)
            }, MAX_TIMEOUT)

            it('изменение статуса на не существующий не (0, 1)', async () => {
                // TODO: поле status не может быть не (0, 1), поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    status: `${NEW_NON_EXIST_STATUS}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение ключевых слов', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    keywords: `${NEW_KEYWORDS}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.keywords).toBe(NEW_KEYWORDS)
            }, MAX_TIMEOUT)

            it('изменение ключевых слов на пустоту', async () => {
                // TODO: поле keywords должно быть обязательным, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    keywords: `${NEW_EMPTY_KEYWORDS}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение описания', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    description: `${NEW_DESCRIPTION}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.description).toBe(NEW_DESCRIPTION)
            }, MAX_TIMEOUT)

            it('изменение описания на пустоту', async () => {
                // TODO: поле description должно быть обязательным, поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    description: `${NEW_EMPTY_DESCRIPTION}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)

            it('изменение hit на существующий (0, 1)', async () => {
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    hit: `${NEW_EXIST_HIT}`
                }
                const response = await controller.editProduct(productData)
                const product = await controller.getProduct(productId)
                expect(response.status).toBe(STATUS_SUCCESSFUL_EDIT)
                expect(product.hit).toBe(NEW_EXIST_HIT)
            }, MAX_TIMEOUT)

            it('изменение hit на не существующий не (0, 1)', async () => {
                // TODO: поле hit не может быть не (0, 1), поэтому статус редактирования должен приходить 0, а не 1
                const productData = {
                    ...defaultProduct,
                    id: `${productId}`,
                    hit: `${NEW_NON_EXIST_HIT}`
                }
                const response = await controller.editProduct(productData)
                expect(response.status).toBe(STATUS_UNSUCCESSFUL_EDIT)
            }, MAX_TIMEOUT)
        })
    })
})