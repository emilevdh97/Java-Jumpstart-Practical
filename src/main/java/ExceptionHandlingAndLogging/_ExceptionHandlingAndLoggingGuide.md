# Practical Guide: Exception Handling and Logging
- We have our animals stored in a csv file. 
- The file contains information about each animal we have at our zoo.
- The owner of the zoo would like to read the contents of the file using a java application.
- There is an existing application, but it no longer does what it used to do.
- We have hired you as our problem solver, to fix our application.

## Step 1: Use Logger with SLF4J and Logback

- Create a new static logger in the `Zoo` class, use `LoggerFactory` from SLF4J to create it and make it final.
```java
    LoggerFactory.getLogger(Zoo.class);
```
- Use the static logger instance to log info about the animal inside the for loop.

```java
    logger.info("Animal {}", animal);
```

- Locate the `logback.xml` file in the resources' folder. Change the configuration of the log level from `NONE` to `INFO`.

## Step 2: Try / Catch / throw / throws 

- Move back to the `Zoo` class.
- Copy the following code and add it to the `readAnimals()` replacing the contents of the method and resolve the imports.

```java
    FileReader fileReader = new FileReader(file);
    return animalsReader(fileReader);
```

- Add the `throws` keyword to the `readAnimals()` method signature. Bind the `IOException` to the keyword. 
- Surround the following line with a `try-catch`.

```java
    animals = new ArrayList<>(readAnimals());
```

- Inside the catch block, add an error logger that will take a message and a throwable. The message should read,
*_Error occurred while trying to read animals!_*.
- Still inside the catch block, return an empty list using the `List.of()` call and assign it to the animals instance.

## Step 3: Try with resources 

- Surround the following line with a try with resources and return the method call to the `animalsReader()` method.
```java
    FileReader fileReader = new FileReader(file);
```
- Catch the `FileNotFoundException` and add error logger with the message and the cause. The message should read, 
 *_Error occurred while trying to open the animal file!_*.
- After the log message, throw a new `RuntimeException` and pass the cause of the exception. 

## Step 4: Custom Exception

- Create a new exception class called the `AnimalFileNotFoundException` inside the `ExceptionHandlingAndLogging` package. 
 The exception should extend the `RuntimeException`.
- The constructor of the exception should take a message and a cause of a throwable type. These should then be passed
 to the super class.
- In the `Zoo` class replace the `RuntimeException` that was thrown inside the `readAnimals()` method with our newly 
 created exception. The line should be:

```java
 throw new AnimalFileNotFoundException("Use the correct file path", e);
```
- Locate the file  `animals.csv` in the resources' folder and copy the path from content root.
> You can copy the path by selecting on file and selecting __Copy Path/Reference__ with IntelliJ.
- Paste the copied content into the file constructor replacing the wrong parameter.

## Step 5: Allowing flow to continue

- Open the `AnimalReader` class. 
- Surround the following line with a try-catch.

```java
 return Integer.parseInt(value);
```
- Instead of logging or rethrowing an exception, return a zero in the catch block.

## Congratulations you have fixed the Application

> `Zoo` Run the appliction to see all the animals we have at our zoo.