const { Router } = require('express');
const { renderSignInForm,
        renderSingUpForm,
        signin,
        signup } = require('../controllers/user.controller');

const router = Router();

/**
 * Representa la ruta de registro del usuario, con formulario
 */
router.get('/user/signup', renderSingUpForm);

/**
 * Representa la ruta para el guardado de información del registro
 */
router.post('/user/signup', signup);

/**
 * Representa la ruta para el ingreso al login del usuario
 */
router.get('/user/signin', renderSignInForm);

/**
 * Representa la ruta para la verificación de credenciales
 */
router.post('/user/signin', signin);


module.exports = router;
