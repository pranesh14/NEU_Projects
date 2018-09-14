/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const searchProductController = require('../controller/search-product-controller');
    // Sticky Routes for search and create.
    app.route('/searchProduct')
        .post(searchProductController.get);

};