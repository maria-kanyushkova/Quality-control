const fetch = require('node-fetch');
const {allProductsPath, addProductPath, editProductPath, deleteProductPath} = require('./config.js')

class Controller {
    async getAllProducts() {
        const response = await fetch(allProductsPath, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        return await response.json();
    }

    async getProduct(productId) {
        let products = await this.getAllProducts()
        return products.find(p => p.id == productId)
    }

    async addProduct(data) {
        const response = await fetch(addProductPath, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return await response.json();
    }

    async editProduct(data) {
        const response = await fetch(editProductPath, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return await response.json();
    }

    async deleteProduct(id) {
        const response = await fetch(deleteProductPath + id, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        return await response.json();
    }
}

module.exports = Controller