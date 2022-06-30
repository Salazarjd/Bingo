const express = require('express')
const cors = require('cors');
const { dbConnection } = require('../database/config');

class Server{

    constructor() {
        this.app = express();
        this.port = process.env.PORT;

        this.usuariosPath = '/api/users';
        this.authPath = '/api/auth';

        //COnectar a base de datos
        this.conectarDB();

        //middlewares
        this.middlewares();

        //Routes
        this.routes();
    }

    async conectarDB() {
        await dbConnection();
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
        this.app.use(this.authPath, require('../routes/auth'));
        this.app.use(this.usuariosPath, require('../routes/user'));
    }

    listen() {
        this.app.listen(this.port, () => console.log(`Servidor corriendo en puerto ${this.port}`));
    }
}

module.exports = Server;