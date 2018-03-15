import platform
import subprocess


def ping(ipAddr, timeout=100):
    if platform.system().lower() == 'windows':
        numFlag = '-n'
    else:
        numFlag = '-c'
    completedPing = subprocess.run(['ping', numFlag, '1', '-w', str(timeout), ipAddr],
                                   stdout=subprocess.PIPE,
                                   stderr=subprocess.STDOUT)
    return completedPing


f = open("output.txt", "w+")
res = str(ping('google.com'))

f.write(res)
