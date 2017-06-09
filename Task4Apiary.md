FORMAT: 1A
HOST: http://rentit2017/

# RentIT

RentIT is an API for Sales/Inventory microservices.

Authentication

user: user1
password: user1

Feel free to contact us at https://www.facebook.com/alex.cherednychenko for the consultation 
or in case of any issues. 



## Available Plant Collection [/inventory/plants{?name,startDate,endDate}]

### List All Available Plants [GET]

Returns all available plants with specified name in the given dates. 

+ Parameters
    + name (optional,string) ... Name of the plant
    + startDate (optional,date) ... Starting date for rental
    + endDate (optional,date) ... End date for rental

+ Response 200 (application/json)

        [
            {
                "_id": "1",
                "name": "Mini excavator",
                "description": "1.5 Tonne Mini excavator",
                "price": 150,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/1"
                    }
                }
            },
            {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            }
        ]


## Plant Management [/inventory/plants/{id}]

+ Parameters
    + id (String) - ID of the Plant in the form of an String

### Retrieve Plant details [GET]

Information about plant with the given id. 

+ Response 200 (application/json)

        {
            "_id": "13",
            "name": "D-Truck",
            "description": "15 Tonne Articulating Dump Truck",
            "price": 250,
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/inventory/plants/13"
                }
            }
        }


## Plant Management - Dispatched [/inventory/plants/{id}/dispatched]
+ Parameters
    + id (String) - ID of the Plant in the form of an String

### Dispatch selected plant [POST]
Changing status of selected plant

+ Response 200

## Plant Management - Delivered [/inventory/plants/{id}/delivered]
+ Parameters
    + id (String) - ID of the Plant in the form of an String

### Deliver selected plant [POST]
Changing status of selected plant
+ Response 200

## Plant Management - Returned [/inventory/plants/{id}/returned]
+ Parameters
    + id (String) - ID of the Plant in the form of an String

### Return selected plant [POST]
Changing status of selected plant
+ Response 200

## Plant Management - Rejected [/inventory/plants/{id}/rejected]
+ Parameters
    + id (String) - ID of the Plant in the form of an String

### Reject selected plant [POST]
Changing status of selected plant
+ Response 200



## PurchaseOrder Collection [/sales/orders]

### List all PurchaseOrders [GET]

Information about  existing purchase orders. 

+ Response 200 (application/json)

        {
            "_id": "bb51df4a-b786-478e-9317-a5ce3161fa03",
            "plant": {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            },
            "rentalPeriod": {
                "startDate": "2017-03-15",
                "endDate": "2017-03-21"
            },
            "total": 1400,
            "status": "PENDING",
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03"
                }
            },
            "_xlinks": [{
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "POST",
                "_rel": "accept"
            },
            {
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "DELETE",
                "_rel": "reject"
            }]
        }

###Create a new PurchaseOrder [POST]

You may create a new PurchaseOrder using this action. It takes a JSON
object containing a partial PurchaseOrder and returns the created PurchaseOrder.

+ Request (application/json)

        {
            "_id":null,
            "plant":{
                "_id":"2",
                "name":"Mini excavator",
                "description":"3 Tonne Mini excavator",
                "price":200.00,
                "links":[{
                    "rel":"self",
                    "href":"http://localhost/api/inventory/plants/2"}
                    ]},
                    "rentalPeriod":{
                        "startDate":[2017,3,15],
                        "endDate":[2017,3,21]},
                        "total":null,
                        "status":null,
                        "links":[]
        }

+ Response 201 (application/json)

        {
            "_id": "bb51df4a-b786-478e-9317-a5ce3161fa03",
            "plant": {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            },
            "rentalPeriod": {
                "startDate": "2017-03-15",
                "endDate": "2017-03-21"
            },
            "total": 1400,
            "status": "PENDING",
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03"
                }
            },
            "_xlinks": [{
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "POST",
                "_rel": "accept"
            },
            {
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "DELETE",
                "_rel": "reject"
            }]
        }

## PurchaseOrder Management [/sales/orders/{id}]

Details on the PO with given id. 

+ Parameters
    + id (String) - ID of the PurchaseOrder in the form of an string

### Retrieve PurchaseOrder details [GET]

+ Response 200 (application/json)

        {
            "_id": "bb51df4a-b786-478e-9317-a5ce3161fa03",
            "plant": {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            },
            "rentalPeriod": {
                "startDate": "2017-03-15",
                "endDate": "2017-03-21"
            },
            "total": 1400,
            "status": "PENDING",
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03"
                }
            },
            "_xlinks": [{
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "POST",
                "_rel": "accept"
            },
            {
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "DELETE",
                "_rel": "reject"
            }]
        }

### Update a PurchaseOrder [PUT]
You may update a PurchaseOrder using this action. It takes a JSON
object containing a partial PurchaseOrder.

+ Response 201 (application/json)

        {
            "_id": "bb51df4a-b786-478e-9317-a5ce3161fa03",
            "plant": {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            },
            "rentalPeriod": {
                "startDate": "2017-03-15",
                "endDate": "2017-03-21"
            },
            "total": 1400,
            "status": "PENDING",
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03"
                }
            },
            "_xlinks": [{
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "POST",
                "_rel": "accept"
            },
            {
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "DELETE",
                "_rel": "reject"
            }]
        }
        


### Cancel a PurchaseOrder [DELETE]
A PurchaseOrder can only be cancelled if the date is before the original start date


+ Response 204



## PurchaseOrder Modification Management [/sales/orders/{id}/{?startDate,endDate}]
PO modification. 

+ Parameters
    + id (optional,string) ... PO id
    + startDate (optional,date) ... New starting date
    + endDate (optional,date) ... New end date

### Modify a PurchaseOrder [PATCH]
You may modify PurchaseOrder dates using this action.

+ Response 201 (application/json)

        {
            "_id": "bb51df4a-b786-478e-9317-a5ce3161fa03",
            "plant": {
                "_id": "2",
                "name": "Mini excavator",
                "description": "3 Tonne Mini excavator",
                "price": 200,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/inventory/plants/2"
                    }
                }
            },
            "rentalPeriod": {
                "startDate": "2017-03-15",
                "endDate": "2017-03-21"
            },
            "total": 1400,
            "status": "PENDING",
            "_links": {
                "self": {
                    "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03"
                }
            },
            "_xlinks": [{
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "POST",
                "_rel": "accept"
            },
            {
                "href": "http://localhost:8080/api/sales/orders/bb51df4a-b786-478e-9317-a5ce3161fa03/accept",
                "method": "DELETE",
                "_rel": "reject"
            }]
        }



## PurchaseOrder Management Acceptance [/sales/ordes/{id}/accept]
+ Parameters
    + id (String) - ID of the PurchaseOrder in the form of an string

### Accept a PurchaseOrder [POST]
This is restricted to RentIT employees. Pending PurchaseOrders will be assessed and accepted based on the plant availability.

+ Response 200

### Reject a PurchaseOrder [DELETE]
This is restricted to RentIT employees. A PurchaseOrder can be rejected by an employee if the plant is no longer available.

+ Response 204




