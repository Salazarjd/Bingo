const mongoose = require('mongoose');

/**
 * Representa la conexión a la base de datos
 */
mongoose.connect(process.env.MONGODB_URI, {
    useUnifiedTopology: true,
    useNewUrlParser: true
})
    .then(db => console.log('Database is connected'))
    .catch(err => console.log(err));
