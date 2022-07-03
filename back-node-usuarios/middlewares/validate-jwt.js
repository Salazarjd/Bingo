const { request, response } = require('express');
const jwt = require('jsonwebtoken');
const User = require('../models/user');


const validateJWT = async(req = request, res = response, next) => {

    const token = req.header('x-token');

    if (!token) {
        return res.status(401).json({
            msg: 'No hay token en la petición'
        });
    }

    try {

        const { uid } = jwt.verify(token, process.env.SECRETORPRIVATEKEY);
        
        const user = await User.findById(uid);

        if (!user) {
            return res.status(401).json({
                msg: 'Token no válido - usuario no existe en DB'
            })
        }

        if (!user.status) {
            return res.status(401).json({
                msg: 'Token no válido - usuario con estado false'
            })
        }

        req.user = user;
        
        next();
        
    } catch (err) {
        console.log(err);
        res.status(401).json({
            msg: 'Token no válido'
        })
    }

}

module.exports = {
    validateJWT
}