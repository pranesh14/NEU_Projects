'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/**
 * Mongoose schema for sticky object.
 */
let productSchema = new Schema({
    /**000
     * Title of the sticky.
     */
    id: {
        type: String,
    },
    name: {
        type: String,
       // required: "title is required"
    },
    description: {
        type: String,
       // required: "title is required"
    },
    price: {
        type: String,
       // required: "title is required"
    },
    inventoryCount: {
        type: String,
       // required: "title is required"
    },
    rating: {
        type: String,
       // required: "title is required"
    },
    imageUrl: {
        type: String,
       // required: "title is required"
    }
}, 
{
    versionKey: false
});

module.exports = mongoose.model('product', productSchema,'product');
