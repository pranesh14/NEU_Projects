'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let productDetailSchema = new Schema({
    name: {
        type: String,
    },
    description: {
        type: String,
    },
    price: {
        type: Number,
    },
    inventorycount: {
        type: Number,
    },
    rating: {
        type: Number,
    },
    imageurl: {
        type: String,
    },
}, {
    versionKey: false
});

module.exports = mongoose.model('product', productDetailSchema, 'product');