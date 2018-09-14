/**
 * Controller for sticky endpoints.
 */

'use strict';
//import sticky service.
const regService = require('../service/register-service');

/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function (request, response) {
    console.log("Hiiiiii");
    let regUser = Object.assign({},request.body);
    console.log(regUser);
    regService.saveUser(regUser, function (user) {
        console.log(regUser);
        if(user!=null && user != '' && user !=[]){
        response.status(200);
        response.json(user);
        console.log("User Inserted");
        }
        else{
            response.status(401);
            console.log("User Not Inserted");
        }
    });
};