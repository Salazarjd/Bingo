const { response } = require('express');

const usersGet = (req, res = response) => {
    res.json({
        msg: 'get API - Controlador'
    });
}

const usersPost = (req, res) => {

    const { nombre, edad } = req.body;

    res.json({
        nombre,
        edad
    });
}

const usersPut = (req, res) => {

    const { id } = req.params;

    const { nombre, edad } = req.body;

    res.json({
        id,
        nombre,
        edad
    });
}

const usersDete = (req, res) => {
    res.json({
        msg: 'delete API'
    });
}

module.exports = {
    usersGet,
    usersPost,
    usersPut,
    usersDete
}