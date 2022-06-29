const express = require('express')
const cors = require('cors');

class Server{

    constructor() {
        this.app = express();
        this.port = process.env.PORT;
        this.usuariosPath = '/api/usuarios';


        //middlewares
        this.middlewares();

        //Routes
        this.routes();
    }

    middlewares() {
        //Directorio público
        this.app.use(express.static('public'));

        //Lectura y parseo del body
        this.app.use(express.json());

        //Cors
        this.app.use(cors());
    }

    routes() {
        this.app.use(this.usuariosPath, require('../routes/user'));
    }

    listen() {
        this.app.listen(this.port, () => console.log(`Servidor corriendo en puerto ${this.port}`));
    }
}

module.exports = Server;