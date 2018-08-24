# Java-first-steps / Battleships


## What we did step by step...


### 1) Installation of the Java Development Kit and Gradle


more on README-installation.md


### 2) Building our first "Hello World!" program


* Introduction to the:
    * class
    * main function


### 3) Having introduction to the world of Object Oriented Programming


* Main subjects:
    * What can exactly be an object?
    * What are propeties and methods?
    * Hierarchy of Objects (Object, Array, String...)
    * The most importat default properties of those Objects
    * Logistics of OOP
    * Discussion on access modifiers (public, private,protected...)
    * What are they for?

### 4) Making first steps to our project

* Tasks:
    * Reseaching what the game needs to have (finding a story)
    * Having a discussion what WE need to do to accomplish that
    * Thinking about the Objects and what we can "convert" to the object
    * Doing a basic sketch of out object map

### 5) Putting together our first Objects and making relation between them


* Square:
    * What properties do we need?(Empty or not/Struck or not/xPosition/yPosition...)
    * What methods do we need?(Set the ship/Strike...)
    * How we want to initialize new Square object?(xPosition/yPosition)
* Grid:
	* How can we create representation of 2D in memory?(Array, Hashmap, List...)
	* Why we chose Hashmap?(Much more readable code, dynamic memory size...)
	* Implementing Square object into our Hashmap
	* Writing the code for getting the visual representation of the grid
* Writing first tests for methods we wrote

### 6) Constructing a fleet of Vessels constructors

* Motivation:
	* Every ship has the same properties and methods
	* Only the sizes are changing
* Answer:
	* Use of VesselImpl file as a parent to all of the Vessels
	* Give every ship construction function a power to "place" their own size
* Product:
	* We got a lot nicer structure
	* Less places for human mistake

### 7) Coding game without play file? Creating the one...

* Making this file gradle entry point
* Playing around with constructor functions, grid drawing, explaining more deeply private access modifier
* Discussing what else we need to have to play this game(Players, collection of the ships, assemble fleet function...)
	* Learning more on how can we read inputs from console(first hand tests)
