// GET http://localhost:9000/aliens
// GET http://localhost:9000/aliens/<id>
// POST http://localhost:9000/aliens
// PATCH http://localhost:9000/aliens/<id>
// DELETE http://localhost:9000/aliens/<id>
// Use of POSTMAN


const express = require('express')
const mongoose = require('mongoose')
const url = 'mongodb://localhost:27017/AlienDBex'

const app = express()

mongoose.connect(url, error => {
    console.log("error")
})
const con = mongoose.connection

con.on('open', () => {
    console.log('connected')
})

app.use(express.json())

const alienRouter = require('./routes/aliens')

app.use("/aliens", alienRouter)


app.listen(9000, () => {
    console.log("Server running...")
})

