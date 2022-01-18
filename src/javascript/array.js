let arr = "first";
let arr2 = ["third", "second"];

console.log(typeof arr)
console.log(typeof arr2)

if (typeof arr === typeof "") {
    console.log("string type")
} else {
    console.log("else of string type")
}


let newArr = new Array(arr);
let newArr2 = new Array(arr2);


let newArr3 = newArr2[0];
let newArr4 = newArr[0];


/*for (let i = 0; i < newArr.length; i++) {
    console.log(newArr[i]+"\n");
}

for (let i = 0; i < arr2.length; i++) {
    console.log(arr2[i]+"\n");
}

for (let i = 0; i < newArr2.length; i++) {
    console.log(newArr2[i]+"\n");
}*/
for (let i = 0; i < newArr3.length; i++) {
    console.log(newArr3[i]+"\n");
}
for (let i = 0; i < newArr4.length; i++) {
    console.log(newArr4[i]+"\n");
}