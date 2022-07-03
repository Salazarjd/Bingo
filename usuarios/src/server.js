const express = require('express');
const path = require('path');
const exphbs = require('express-handlebars');

//Inicialization
const app = express();

//Settings
app.set('port', process.env.Port || 4000);
app.set('views', path.join(__dirname, 'views'));
app.engine('.hbs', exphbs.engine({
    defaultLayout: 'main',
    layoutsDir: path.join(app.get('views'), 'layouts'),
    partialsDir: path.join(app.get('views'), 'partials'),
    extname: '.hbs'
}));
app.set('view engine', '.hbs');


//middlewares
app.use(express.urlencoded({ extended: false }));


//Global variables


//Routes
app.get('/', (req, res) => {
    res.render('index');
});


//static files
app.use(express.static(path.join(__dirname, 'public')))

module.exports = app;