"# greenKoncept" 

Launch application

`mvn spring-boot:run`

--> Use Basic Auth admin/ password
--> Use postman samples **postman\CustomerOrdes.postman_collection.json**

1) Create Customer

`http://localhost:8080/customer`

`{
 	"name":"Prasad",
 	"age": 22,
 	"address":"India"
 }`

2) Create Order

`http://localhost:8080/order`

`{
 	"details":"Laptop",
 	"amount":1225.55,
 	"custId":1
 }`
