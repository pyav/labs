var fs = require('fs')

fs.readFile('calc.js', "utf8", function (err, data) {
    console.log(data)
})

fs.writeFile('autoGenerate.js', 'console.log("done")', function(err){
    console.log("Data saved")
})

fs.appendFile('autoGenerate.js', 'console.log("done2")', function(err){
    console.log("Data saved")
})

fs.readFile('autoGenerate.js', "utf8", function (err, data) {
    console.log(data)
})

fs.unlink('autoGenerate.js', function (err){
    console.log('Deleted')
})
