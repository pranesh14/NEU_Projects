/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const removeFromCartController = require('../controller/removeFromCart-controller');
    // Sticky Routes for search and create.
    app.route('/cartupdated')
        .post(removeFromCartController.get);

};