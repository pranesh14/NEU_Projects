/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const loginController = require('../controller/login-controller');
    // Sticky Routes for search and create.
    app.route('/login')
        .post(loginController.post)
        .get(loginController.get)

    // Sticky Routes for get, update and delete.;
};