const fetch = require('node-fetch')

async function getData(url = '') {
    const response = await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    });
    return await response.json();
}

getData('http://localhost:4545/currency/usd')
    .then((data) => {
        console.log(data);
    });

getData('http://localhost:4545/currency/eur')
    .then((data) => {
        console.log(data);
    });

getData('http://localhost:4545/currency/yena')
    .then((data) => {
        console.log(data);
    });