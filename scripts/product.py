import requests
import time

for index in range(4, 100):
    time.sleep(10) # 10 sec wait

    url = 'http://localhost:8080/product'
    body = { "id": index, 
            "name": "product"+str(index), 
            "quantity": 100, 
            "seller": { 
                "id": 2, 
                "userType": 1, 
                "firstName": "seller 2", 
                "lastName": "Taylor", 
                "address": "seller address 2", 
                "accountNo": "345678" 
            }
            }

    response = requests.post(url, json = body)

    print(response.text)