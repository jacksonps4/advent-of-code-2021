# Advent of code 2021

This is my attempt at Advent of Code 2021.

## Project structure

This project is a fairly standard Maven project with a dependency on JUnit. Everything 
else is just plain Java.

Building and testing is done with
```shell
$ mvn package
```

## Code structure

Since a new puzzle arrives each day, there is a new Java package for each day. Packages 
are of the format: `com.cw.aoc.dX` where X is the day number. Since there is often some
overlap between part 1 and part 2 of the puzzle, the same package is used for both 
parts. There are also some tooling for running the code in the `com.cw.aoc.common` 
package. 

Each day, you need to implement a new `com.cw.aoc.common.Solver` which takes a series 
of inputs from lines in a text file and generates a result. The input files such as 
test data and input data are stored in the `resources` folder again with a directory
per day.

## Running a solver

To run a solver, use the following syntax:

```shell
$ mvn package
$ java -cp target/classes com.cw.aoc.common.Runner <path-to-input-file-relative-to-classpath> <solver-class>
```
