'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let paymentSchema = new Schema({
    name: {
        type: String,
    },
    quantity: {
        type: Number,
    },
    price: {
        type: Number,
    },
    image: {
        type: String,
    }
}, {
    versionKey: false
});

module.exports = mongoose.model('cart', paymentSchema, 'cart');