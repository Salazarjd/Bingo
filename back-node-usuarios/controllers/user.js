const { response } = require('express');
const User = require('../models/user');
const bcryptjs = require('bcryptjs');

const usersGet = async(req, res = response) => {

    const query = {status: true}

    const[total, users] = await Promise.all([
        User.countDocuments(query),
        User.find(query)
    ]);

    res.json({
        cantidad: total,
        users
    });
}

const usersPost = async (req, res) => {

    const { name, email, password } = req.body;
    const user = new User({ name, email, password });

    //Encriptar contraseña
    const salt = bcryptjs.genSaltSync();

    user.password = bcryptjs.hashSync(password, salt);

    await user.save();

    res.json({
        user
    });
}

const usersPut = async (req, res) => {

    const { id } = req.params;

    const { name, email } = req.body;

    const user = await User.findByIdAndUpdate(id, { name, email },{new:true});

    res.json({
        user
    });
}

const usersDete = async (req, res) => {

    const { id } = req.params;

    const user = await User.findByIdAndUpdate(id, {status: false}, {new:true})

    res.json({
        user,
    });
}

module.exports = {
    usersGet,
    usersPost,
    usersPut,
    usersDete
}