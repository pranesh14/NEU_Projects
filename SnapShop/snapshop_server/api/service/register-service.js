/**
 * Service for sticky operations.
 */

'use strict';
var Q = require('q');
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
exports.saveUser = function (userObj, callback) {
    // let newUser = new User(userObj);
    // newUser.save(function (err, userObj) {
    //     throwError(err);
    //     callback(userObj);

    // });
    var deferred = Q.defer();
    let newUser = new User(userObj);
    console.log(userObj);
     User.findOne(
       {username :userObj.username},function(err,userObj){
       if(err){
        deferred.reject(err.name +""+err.message);   
       }
       if(userObj){
        deferred.reject('Username "' + userObj.username + '" is already taken');
       }
       else{
        newUser.save(function (err,userObj) {
            
                if(err){
                    console.log("User Not Created");
                }
                else{
                console.log(userObj);
                console.log("User Created");
                }
            
       }
    )
}
   });
}