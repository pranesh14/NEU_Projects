/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const scanProductController = require('../controller/scan-product-controller');
    // Sticky Routes for search and create.
    app.route('/scanProduct')
        .post(scanProductController.get);

};