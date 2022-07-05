require('dotenv').config();
const app = require('./server');
require('./database');

/**
 * Representa la iniciación del servidor
 */
app.listen(app.get('port'), () => {
    console.log('Server on port', app.get('port'));
});