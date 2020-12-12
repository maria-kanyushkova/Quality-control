const fetch = require('node-fetch');

const json = require('./currency.json');

async function postData(url = '', data = {}) {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    return await response.json();
}

postData('http://localhost:2525/imposters', json)
    .then((data) => {
        console.log(data);
    });