
const express = require('express')
const app = express()

// http://localhost:8888
app.get('/', function (req, res) {
    //console.log("Hello World!")
    res.send('Hello World!')
})

// http://localhost:8888/alien?id=2
app.get('/alien', function (req, res) {
    const id = req.query.id
    res.send('Welcome alien: ' + id)
})

// http://localhost:8888/alien/3
app.get('/alien/:id', function (req, res) {
    const id = req.params.id
    res.send('Welcome alien: ' + id)
})

app.listen(8888, function (req, res) {
    console.log("Server running...")
})
