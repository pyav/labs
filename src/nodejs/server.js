
var http = require('http')

http.createServer(function(req, res) {

    res.writeHead(200, {'Content-type':'test/html'})
    res.write("Welcome user!")
    res.end()

}).listen(8080)