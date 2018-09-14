/**
 * Service for sticky operations.
 */

'use strict';
const mongoose = require('mongoose'),
    User = mongoose.model('user');
    
    //console.log(User);
/**
 * Throws error if error object is present.
 *
 * @param {Object} error {Error object}
 */
let throwError = function (error) {
    if (error) {
        throw Error(error);
    }
};

/**
 * Returns an array of sticky object matching the search parameters.
 *
 * @param {Object} userObj {Search parameters}
 *
 * @param {function} callback {Sucess callback function}
 */
exports.findOne = function (userObj, callback) {
    // let newUser = new User(userObj);
    // newUser.save(function (err, userObj) {
    //     throwError(err);
    //     callback(userObj);

    // });
    User.find({username:userObj.username,password:userObj.password}, function (err, foundUser) {
        console.log(err);
       // console.log(username_1+"Username"+password_1);
        throwError(err);
        console.log(foundUser);
        callback(foundUser);
    });
};

exports.find = function(userObj, callback) {
    User.find({}, function(err, foundUser) {
        throwError(err);
        callback(foundUser);
    });
};

