const { Router } = require("express");
const {
  usersGet,
  usersPost,
  usersPut,
  usersDete,
} = require("../controllers/user");

const router = Router();

router.get("/", usersGet);

router.post("/", usersPost);

router.put("/:id", usersPut);

router.delete("/:id", usersDete);

module.exports = router;
