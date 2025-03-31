import requests
import time

for index in range(3, 1000):
    time.sleep(5) # 5 sec wait

    url = 'http://localhost:8080/order'
    body = {
        "id": index,
        "customer": {
            "id": 0,
            "userType": 0,
            "firstName": "customer 0",
            "lastName": "Doe",
            "address": "customer address 0",
            "accountNo": "123456"
        },
        "products": [
            {
                "id": 1,
                "name": "product1",
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
        ]
    }

    response = requests.post(url, json = body)

    print(response.text)