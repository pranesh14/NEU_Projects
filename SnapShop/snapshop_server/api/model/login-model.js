'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/**
 * Mongoose schema for sticky object.
 */
let loginSchema = new Schema({
    /**
     * Title of the sticky.
     */
    username: {
        type: String,
        unique:true,
        required: true,
        trim: true
       // required: "title is required"
    },
    /**
     * Sticky created date.
     */
    password: {
        type: String,
        //unique:true,
        required: true,
        trim: true

    },
    firstname :{
        type: String,
        required: true,

    },
    lastname :{
        type: String,

    },
    email :{
        type: String,
        unique:true,
        required: true,
        trim: true
    },
    phonenumber:{
        type: String,
        required: true,
   
    }
}, 
{
    versionKey: false
});

module.exports = mongoose.model('user', loginSchema, 'user');