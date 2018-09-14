/**
 * Controller for sticky endpoints.
 */

'use strict';
const loginService = require('../service/login-service');

/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function(request, response) {
    let validUser = Object.assign({}, request.body);
    console.log(validUser);
    loginService.findOne(validUser, function(user) {
        console.log(user);
        if (user != null && user != '' && user != []) {
            response.status(200);
            response.json(user);
            console.log("User Validated");
        } else {
            response.status(401);
            console.log("User Not Validated");
        }
    });
};

exports.get = function(request, response) {
    let user = Object.assign({}, request.body);
    loginService.find(user, function(user) {
        response.status(200);
        response.json(user);
    });
};