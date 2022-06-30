const User = require("../models/user")

const existEmail = async (email = '') => {
    const emailE = await User.findOne({ email });
    if (emailE) {
        throw new Error(`El email ${email} ya existe`);
    }
}

const existUserById = async (id = '') => {
    const existId = await User.findById(id);
    if (!existId) {
        throw new Error(`El id ${id} no existe`);
    }
}

module.exports = {
    existEmail,
    existUserById
}