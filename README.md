# Pet Finder

**Find your new best friend**

![Pet Finder app](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7BP2fl6HfWc2sIeCm5NIym6V_LDLpp3Hi7A&usqp=CAU)


A pet can be a reliable friend to anyone.
Unconditional moral support, better immunity and the
urge to live an active life are just some of the benefits
that a pet brings to a family's life.


### Purpose of the project
PetFinder is intended to be a virtual puppy shelter where several puppy owners want to donate their pets. This project has the main purpose to use the knowledge gained during the Java course at IT School: working with Spring Boot, CRUD operations, register, login.

What should be noted is that only the user with the role of administrator has FULL credentials and authority over the databases: he can delete, edit and add animals and associated owners to the database. 
A user who registers on PetFinder has only the role of USER, i.e. only the right to view the database (without making any modifications to it).


### Technologies used
* Spring Boot
* Spring Security
* Spring Data JPA
* Thymeleaf
* Bootstrap template (that included HTML5, CSS3, JavaScript & JQuery) 
* Maven
* Lombok
* Postman
* Scheduler
* DTO
* Faker
* JUnit Test
* GIT

### Features

1. When we run the application, it is _automatically_ created the **ADMIN **user with FULL credentials. To test the functionality of the ADMIN user, we should login with: 
\- Username: admin
\- Password: password1

2. At the run of the application, it is also running a **Scheduler** job that aims to add some random and fake Owners into the DB (using _Faker_ module). After the ADMIN login, due to the fact that it's already running a Scheduling job, we already have some owners in the Database.

3. Another feature that we have is **Adding some owners into the DB via a CSV file** in case we don't have enough time to create owners.

4. **CRUD** operations on _Owners_ and _Pet_ entities linked by a Many to One relationship.

5. _Pet_ entity contains **LocalDateTime** for recording the added timestamp into the database and **Java Enum** for tracking the city/cities of the abandoned dog. It is possible that an owner to have dogs of the same breed scattered in different cities, so the Admin could select multiple cities of the added dogs.

6. **Login, Register & Token Validation by Email**. People who want to see the available dogs could register and validate the account using the token received by email.
![Token Validation Email](https://i.ibb.co/D96m9P1/poc.png) Also, the register has been possible using *DTO* design pattern. *Optional* was used in User Service to find the username and checking the password for that specific user. *Stream* was used in order to assign the role of the registered user.
A *custom exception* was thrown in case a user is trying to register with an existent email from the database.

7. **Bootstrap** templates used for Login/Register pages and for the pages right after the login using Carousel Slider, Parallax, Google Maps for embedding a map and other things related to Front End side.


### Resources
1) https://colorlib.com/wp/template/login-form-v18/ - Bootstrap template for Login & Register pages

2) https://themefisher.com/products/fiction-bootstrap-agency-temp - Bootstrap template for Index and the other pages after the Login part that contained information about Pet Finder and the database

3) https://stackoverflow.com/ - for all the bugs, errors, problems, exceptions
