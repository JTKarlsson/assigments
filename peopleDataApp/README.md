# peopleDataApp

this project is simple Spring boot and Angular.js application. The purpose of this project is to manage peopledata. 

## how to run
- you need to have java envirioment installed
- you need to have node.js and npm installed
- when you do navigate to the frontend folder and run "npm install" to install the npm depedencies for the project
- then run "ng serve" to serve frontend in developing mode
- then navigate to the backend foler and run "mvn install" to install maven depedencies and build the projects
- then run "mvn spring-boot:run" to run Spring Boot application
- Then you should open the "http://localhost:4200" and see the application that can be used
- the api is running in ""http://localhost:8080" if you would like only use the api


## Angular frontend

### Features
- You can create a new people data
- You can read the data from the table
- You can edit existing data
- You can delete existing data

### Notes about the frontend
This is my first Angular.js project ever. I have done many React.js app. The reason I did this with is, that I wanted to try out and learn Angular and see am I able to develop with it. I m not sure have I used the best practices and there is a lot to study about the framework. The test with Jasmine wasn't easy to make, but I managed to do some tests. I would like to hear about the prodedures that you use in your projects. 

## Spring boot backend

### Features
- Rest api that has CRUD methods for managin 'henkilotietoRekisteri" ArrayList
- You can read the data
- you can add new Henkilo objects to the henkilotietoRekisteri ArrayList
- you can update existing Henkilo objects that are in the henkilotietoRekisteri ArrayList
- you can delete existing Henkilo objects from the henkilotietoRekisteri Arraylist

### Notes about the backend
This was going to expand a lot bigger than needeed. I wanted to add HenkiloFactory Class and I was going to implement h2 database with repository and entity Classes. I needed to read again the instructions and cut down some features. This was fun to build, I haven't been starting Spring Boot projects from scratch for a while. If this would go to the production, I would go throught all the error handling and add the database. The unit tests in this project are only unit tests. The app would need end to end tests. I haven't done those kind of tests, so it would be a good place to practice. 

## Notes about possbile next steps
- I would like to dockerize the application
    - This would help the start of the application
- I would add SQL based database, maybe postgresSQl, I am familiar with it
- Refactor the frontend to have multiple components, now it has all the CRUD operations in the same component
- Frontend would need the "Henkilo" model, maybe other models as well for the api calls
- Figure out the state managment for the Frontend
- better error handling, so the users could see easier if something went wrong
- Logs for the backend to make easier debugging if the app is expanding
- search feature that uses the api for better user expierence