# [Software Sauna](https://www.softwaresauna.com/) Code Challenge

- Path following algorithm in ASCII Map
- Find the position of character `@`
- Follow the path, stop when character `x` is reached

## Code Challenge

Write a piece of code that takes ASCII map as an input and outputs the collected letters and the list of characters of the travelled path.

  - Input: 
    - ASCII map (hard-coded, in a file, copied from a magic scroll - your choice)
  - Output:
    - Collected letters
    - Path as characters
    
    
# Solution
Java Application with Gradle Framework

# Running
Program accept a list of pair arguments (map input and rsult) with path of 
```
${project.dir}/input/${argument}
```

## Example 1: Valid maps

### inputs/test-map-1.txt

```
  @---A---+
          |
  x-B-+   C
      |   |
      +---+
```

### inputs/test-map-1-result.txt
```
ACB
   @---A---+|C|+---+|+-B-x
```

### RUNNING 
```
java inputs/test-map-1.txt inputs/test-map-1-result.txt
```

### OUTPUT
```
FILE: inputs/test-map-1.txt

  @---A---+
          |
  x-B-+   C
      |   |
      +---+

LETTER: ACB
PATH: @---A---+|C|+---+|+-B-x
```

## Example 2: Invalid maps:

## RUNNING 
```
java inputs/test-map-1-inv.txt inputs/test-map-1-inv-result.txt
```

## OUTPUT
```
FILE: inputs/test-map-1-inv.txt
     -A---+
          |
  x-B-+   C
      |   |
      +---+

Error

```

## JUNIT TEST
Basic unit tests are included in solution. Grouped in 3 Logical Process of program execution.
  - InitLoadingTest
  - MapValidationTest
  - AlgorithmTest




