const { Router } = require('express');
const { renderSignInForm,
        renderSingUpForm,
        signin,
        signup,
        logout } = require('../controllers/user.controller');

const router = Router();


router.get('/user/signup', renderSingUpForm);

router.post('/user/signup', signup);

router.get('/user/signin', renderSignInForm);

router.post('/user/signin', signin);

router.get('/user/logout', logout);


module.exports = router;
