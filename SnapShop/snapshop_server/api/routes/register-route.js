/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const regController = require('../controller/register-controller');
    // Sticky Routes for search and create.
    app.route('/registration')
        .post(regController.post)

    // Sticky Routes for get, update and delete.;
};