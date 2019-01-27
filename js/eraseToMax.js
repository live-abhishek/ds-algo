process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

// process.stdin.on("data", function (input) {
//     stdin_input += input;                               // Reading input from STDIN
// });

// process.stdin.on("end", function () {
//     main(stdin_input);
// });

function main(input) {
    const lines = input.split("\n");
    const t = parseInt(lines[0]);
    for (let i = 0; i < t; i++) {
        n = parseInt(lines[i * 2 + 1]);
        arr = []
        lines[i * 2 + 2].split(" ").forEach(a => arr.push(parseInt(a)));
        const sum = arr.reduce((a, b) => a + b, 0);
        var myMap = new Map();
        for (let i = 0; i < arr.length; i++) {
            const curr = myMap.get(arr[i]) || 0;
            myMap.set(arr[i], curr + 1);
        }
        // set the num & its count; for now using the 1st index
        const x = { num: arr[0], count: myMap.get(arr[0]) };
        for (let [key, value] of myMap) {
            if (x.num && x.count) {
                if (key * value < x.num * x.count) {
                    x.num = key;
                    x.count = value;
                }
            } else {
                x.num = key;
                x.count = value;
            }
        }
        console.log(sum - x.num * x.count);
    }
}

const str = "1\n3\n1 2 3\n";
main(str);
