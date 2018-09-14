'use strict';
module.exports = function(app) {
    const productDetailController = require('../controller/productDetail-controller');
    app.route('/productdetail/:productId')
        .get(productDetailController.get);
};