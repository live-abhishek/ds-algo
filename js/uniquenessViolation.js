process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

// process.stdin.on("data", function (input) {
//     stdin_input += input;                               // Reading input from STDIN
// });

// process.stdin.on("end", function () {
//     main(stdin_input);
// });

let i = 0;
let lines;
function getNextLine() {
    return lines[i++];
}

function processTC() {
    const n = parseInt(getNextLine());
    const arrU = [];
    getNextLine().split(" ").forEach(u => arrU.push(parseInt(u)));
    const arrE = [];
    getNextLine().split(" ").forEach(e => arrE.push(parseInt(e)));
    var myMap = new Map();
    for (let i = 0; i < n; i++) {
        const curr = myMap.get(arrU[i]) || 0;
        myMap.set(arrU[i], arrE[i] > curr ? arrE[i] : curr);
    }
    let total = 0;
    for (let [key, value] of myMap) {
        total += value;
    }
    console.log(total);
}

function main(input) {
    lines = input.split("\n");
    const t = parseInt(getNextLine());
    for (let i = 0; i < t; i++) {
        processTC();
    }
}

// const str = "2\n10\n15 15 12 13 13 13 1 1 1 1\n20 30 15 16 12 1 23 24 1 2\n10\n15 15 12 13 13 13 1 1 1 1\n20 30 15 16 12 1 23 24 1 2"
const str = "2\n3\n1 2 3\n1 3 2\n3\n1 2 3\n1 3 2";
main(str);