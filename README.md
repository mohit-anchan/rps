# Rock Paper Scissor

## Prerequisites
In order to build this application you'll need maven installed.

+ [Java 1.8 or above](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ [Apache Maven](https://maven.apache.org/download.cgi?Preferred=ftp://mirror.reverse.net/pub/apache/)


## Unit Test tools used
+ [Junit 4](https://junit.org/junit4/)
+ [Mockito](https://site.mockito.org/)
+ [System Rules](https://stefanbirkner.github.io/system-rules/)


## Build instruction
Package the application contents into an exeutable jar
```
$ mvn package
```
This will generate a jar file at ```./target```

## Running the application
```
$ cd target
$ java -jar mohit.rps-1.0.jar
```

## Run tests
```
$ mvn clean test
```
