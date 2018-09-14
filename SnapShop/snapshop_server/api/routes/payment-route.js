'use strict';
module.exports = function(app) {
    const paymentController = require('../controller/payment-controller');
    app.route('/payment')
        .get(paymentController.get);
};