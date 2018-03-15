import requests


def getAllCountries():
    url = "http://services.groupkt.com/country/get/all"
    response = requests.get(url)
    return response.json()['RestResponse']['result']


def getCountriesByNameOrCode(inp):
    countries = getAllCountries()
    resultCountries = []
    for country in countries:
        if country['name'] == inp or country['alpha2_code'] == inp or country['alpha3_code'] == inp:
            resultCountries.append(country['name'])
    resultCountries.sort()
    print(*resultCountries)


getCountriesByNameOrCode("IN")
