import subprocess
import re
import sys

toGrep = sys.argv[2]
op = subprocess.run(["python", sys.argv[1]], stdout=subprocess.PIPE,
                    stderr=subprocess.STDOUT, encoding="utf-8")

strArr = op.stdout
strArr = strArr.split("\n")
for line in strArr:
    if re.match(toGrep, line):
        print(line)
