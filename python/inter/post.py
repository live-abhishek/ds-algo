import requests

url = "http://demo.allennlp.org/predict/textual-entailment"

data = '{"premise": "Soham has blue pen", "hypothesis": "Soham has a pen"}'
headers = {"Content-Type": "application/json"}
response = requests.post(url, data=data, headers=headers)
print("response status = ", response.status_code)
print(response.text)
print(response.json())