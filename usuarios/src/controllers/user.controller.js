const User = require('../models/user');

/**
 * Representa el controlador para renderizar las páginas de registro de usuario
 */
const userCtrl = {};

userCtrl.renderSingUpForm = (req, res) => {
    res.render('user/signup');
};

/**
 * Representa el controlador de registro de usuarios
 * @param {request} req representa las solicitudes realizadas a la ruta
 * @param {response} res representa la información de respuesta a la solicitud
 */
userCtrl.signup = async(req, res) => {

    const errors = [];
    const { name, email, password, confirm_password } = req.body;
    if (password != confirm_password) {
        errors.push({text: 'Password do not match'})
    }
    if (password.length < 4) {
        errors.push({text: 'Password must be at least 4 characters'})
    }
    if (errors.length > 0) {
        res.render('user/signup', {
            errors,
            name,
            email
        })
    } else {
        const emailUser = await User.findOne({ email });
        
        if (emailUser) {
            console.log(emailUser);
            req.flash('error_msg', 'The email is already in use');
            res.redirect('signup')
        } else {
            const newUser = new User({ name, email, password });
            newUser.password = await newUser.encryptPassword(password);
            await newUser.save();
            res.redirect('/user/signin');
        }
    }
};

/**
 * Representa el controlador para renderizar el formulario de login
 * @param {request} req representa las solicitudes realizadas a la página
 * @param {response} res representa la respuesta a la información solicitada
 */
userCtrl.renderSignInForm = (req, res) => {
    res.render('user/signin');
};

/**
 * Representa el controlador para el login de usuario
 * @param {request} req representa las solicitudes realizadas a la página
 * @param {response} res representa la respuesta a la información solicitada
 */
userCtrl.signin = async (req, res) => {
    const { email, password } = req.body;

    const user = await User.findOne({ email });

    if (user) {
        const match = await user.matchPassword(password);
        if (match) {
            res.redirect('http://localhost:9090/');
        } else {
            res.render('user/signin')
        }
    }
}


module.exports = userCtrl;