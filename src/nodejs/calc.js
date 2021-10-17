// Demonstration of how a module is created

function add(a, b) {
    return a+b
}

function sub(a, b) {
    return a-b
}

// Multiple ways of exporting a function to be used outside a module
exports.mult = function mult(a, b) {
    return a*b
}

module.exports.add = add
// Works even without module word
exports.sub = sub
