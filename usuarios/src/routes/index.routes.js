const { Router } = require('express');
const { renderIndex} = require('../controllers/index.controllers');

/**
 * Representa la ruta de inicio de la página
 */
const router = Router();

router.get('/', renderIndex);


module.exports = router;