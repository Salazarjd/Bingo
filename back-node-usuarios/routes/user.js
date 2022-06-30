const { Router } = require("express");
const { check } = require("express-validator");
const validateFields = require("../middlewares/validate-fields");
const { existEmail, existUserById } = require("../helpers/db-validators");
const {
  usersGet,
  usersPost,
  usersPut,
  usersDete,
} = require("../controllers/user");

const router = Router();

router.get("/", usersGet);

router.post("/", [
  check('name', 'El nombre es obligatorio').not().isEmpty(),
  check('email', 'El correo no es válido').isEmail(),
  check('email').custom(existEmail),
  check('password', 'El password debe ser de más de 6 letras').isLength({min: 6}),
  validateFields
], usersPost);

router.put("/:id", [
  check('id', 'No es un id válido').isMongoId(),
  check('id').custom(existUserById),
  validateFields
], usersPut);

router.delete("/:id", [
  check('id', 'No es un id válido').isMongoId(),
  check('id').custom(existUserById),
  validateFields
], usersDete);

module.exports = router;
