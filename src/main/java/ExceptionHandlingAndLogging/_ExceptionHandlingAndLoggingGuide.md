# Practical Guide: Exception Handling and Logging
- We have our animals stored in a csv file. 
- The file contains information about each animal we have at our zoo.
- The owner of the zoo would like to read the contents of the file using a java application.
- There is an existing application, but it no longer does what it used to do.
- We have hired you as our problem solver, to fix out application.

## Exercise

### Step 1: Use Throws and try-catch
- The zoo owner requires that you add exception handling to the application. They want you to use pass the exception to 
the calling method. Use the `throws` keyword on the method signature of the `readAnimals()` method.

- The owner would like you to handle the passed exception in the `main()` method. Do this by surrounding the `readAnimals()`
 call with a `try-catch` leaving the initialization of the animal list and the for loop outside the `try-catch`. 
 You can add print the exception to the STDOUT as the owner is not concerned about that yet.

### Step 2: Use logging facade
- Logging for the application has been configured, but it is not being used yet. Import Logger and LoggerFactory from SLF4J
 and initialize a static logger in the zoo class. 
- In the catch element of the `main()` method, replace the print method with `logger.error()`. Pass the message
 "Something went wrong when reading the file" and the exception object.
- The application is no longer logging to the STDOUT look for the `logback.xml`(which is the configuration file for our logging backend), in the resource folder and change 
 the log level from `NONE` to `INFO`

### Step 3: Using custom exceptions and Try with Resource
- Create your own Exception `AnimalsFileNotFoundException` and inside the  `readAnimals()` insert a try with resources and
 catch the `FileNotFoundException` and handle that by throwing our `AnimalsFileNotFoundException`. 
- Add A general catch in `main()` to handle all the other unknown Exceptions and give it a message with "Something went wrong" and the exception object
- The application throws a `AnimalsFileNotFoundException` because it is not able to find the file containing all the animals that 
 belong to the zoo. fix the path as it should be `src/main/resources/animals.csv` 

### Step 4: Not Logging Some exceptions
- In the AnimalReader class, surround the `parseInt` call with a `try-catch` and return a default value of zero of an exception
 is thrown. 