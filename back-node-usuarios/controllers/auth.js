const { response } = require('express');

const login = (req, res = response) => {

    const { email, password } = req.body;

    res.json({
        email, 
        password
    });
}

module.exports = {
    login
}