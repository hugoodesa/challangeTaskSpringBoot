## How to run this project

1. you can run this command (be sure that you're in the root folder): ``docker-compose up``

2. you can also can run using your favorite IDEA by running the mainClass

## How can you acess the project

1. The project it will run at port 9000 so you can acess by ``http:localhost:9000``

2. To check the routes and endPoints you can acess the swagger to get more information ``http://localhost:9000/swagger-ui/index.html``

## About framework and libs

### libs used in this project
1. **database** : Was used h2 that is a memory database , every that you restart your application the data will be lost so a made a insert into /target/data.sql to have some resgister to work on when the application starts. 

2. **validation** : To check if certain fields are not blank or null i use the bean validation lib 

3. **persist data** : Maybe the most famous framework when were refer to springboot its hibernate and jpa , give a abstration on creating tables and give you the CRUD main  methods in a easy way.

4. **Mapper** : When the api get a register from the db and gives to the client return the raw entity its bad pratice , the right way to do this its return a DTO (data transfer object) then i can manually create a DTO using constructor , builder by lombok or using a lib to do this as i do using ObjectMapper

## Notes
1. **Architeture** : I use a basic division that its controller, entity , repository and service

2. **Docker** : To be more confortable and no depends of the user machine i prefer use docker , to make sure that the enviroment its correct 
  
 3. **Routes** : There is a route that ask for the 20 incidents order by desc and another one that ask for all incidents , its a little redundat this part , maybe says that the dev should use a  pagination its be more clarify 
