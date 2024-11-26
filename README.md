# tap (test anywhere protocol) test
Small repo to test out the [TAP](https://testanything.org/) 

How to run:
1. `./c++_producer/my_program > test.log`
```
pnispero@PC100942:~/tap_test$ cat test.log
1..3
ok 1 - This test passes
not ok 2 - foo() should be 1
# Failed test 'foo() should be 1'
#        Got: 2
#   Expected: 1
ok 3 - bar() should be "a string"
pnispero@PC100942:~/tap_test$
```
2. `cd java_consumer/ && ./gradlew run`
```
pnispero@PC100942:~/tap_test$ cd java_consumer/ && ./gradlew run

> Task :run
Number of tests found: 3
Any failure? true
Test Summary: Passed 2 of 3 tests (66%)
[Incubating] Problems report is available at: file:///home/pnispero/tap_test/java_consumer/build/reports/problems/problems-report.html

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.11/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
pnispero@PC100942:~/tap_test/java_consumer$
```

## Producer libraries
Almost all languages are supported - [libraries](https://testanything.org/producers.html)

one more to mention thats not on the list
1. c++ - [Catch2](https://github.com/catchorg/Catch2/blob/devel/docs/ci-and-misc.md#top) popular c++ testing framework which has more than just pass/fail

I used [this c++ producer library](https://github.com/cbab/libtappp) - for simple prototyping

## Consumer libraries
Since there is only one consumer/parser (build system backend) and its in java, I used [this java consumer library](https://tupilabs.com/tap4j/tap4j/tapconsumer.html)

