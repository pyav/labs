package main

import (
	"fmt"
	"strconv"
)

// Package-level variable
var l int = 32

// Exposed to outside the package
var L int = 20

// Multiple variable blocks for different contexts
var (
	name string = "pyav"
	number int = 8
)

var (
	counter int = 1
)

func main() {
	//    var i int
	//    i = 42
	//    fmt.Println(i)

	//var j float32 = 42
	//fmt.Println(j)

	// Block-level variable
	k := 42.
	fmt.Println(k)

	//fmt.Printf("%v, %T", k, k)

	fmt.Printf("%v %T", l, l)
	fmt.Println()
	// Re-declare variable - shadowing
	var l int = 10
	fmt.Printf("%v %T", l, l)

	// No new variable hence error in the following line
	// l := 20

	fmt.Println()
	// Type conversion - do keep track of whether you can loose information in type conversion
	var z float32
	z = float32(l)
	fmt.Printf("%v %T", z, z)

	fmt.Println()
	// Convert to string
	var t string
	t = strconv.Itoa(l)
	fmt.Printf("%v %T", t, t)
}
