/**
 * Representa el controlador para renderizar la página de inicio
 */
const indexCtrl = {};

indexCtrl.renderIndex = (req, res) => {
    res.render('index');
};

module.exports = indexCtrl;