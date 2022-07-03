const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const User = require('../models/user');


passport.use(new LocalStrategy({
    userNameField: 'email',
    passwordField: 'password'
}, async (email, password, done) => {

    //Match email´s user
    const user = await User.findOne({ email });
    console.log(user);
    if (!user) {
        return done(null, false, { message: 'not user found' })
    } else {
        //Match password´s user
        const match = await user.matchPassword(password);
        if (match) {
            return done(null, user);
        } else {
            return done(null, false, { message: 'Incorrect password' });
        }
    }
}));

passport.serializeUser((user, done) => {
    done(null, user.id);
});

passport.deserializeUser( async(id, done) => {
    await User.findById(id, (err, user) => {
        done(err, user);
    })
})