/*
const express = require('express');
const path = require('path')

const app = express()

app.use('/', express.static(path.join(__dirname, '/dist')))


const port = process.env.PORT || 8080
app.listen(port)

console.log('OUvindo na porta: ' + port);
*/
/**************************************************************************
IMPORTS
**************************************************************************/


var express = require('express')
var history = require('connect-history-api-fallback')
var path = require('path')
var serveStatic = require('serve-static')


/**************************************************************************
EXPRESS SERVER
**************************************************************************/


var app = express()

app.use(history({verbose: true}))
app.use(serveStatic(path.join(__dirname, '/dist')))

var port = process.env.PORT || 8080

app.listen(port, () => {
    console.log('OUvindo na porta: ' + port);
})