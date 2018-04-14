# SayHello Test
SayHello utilizes both _uni_ and _integation_ tests for its TDD.  Units tests are JUnit 
test cases defined within each module.  Integration tests are performed in their own Karaf
container using [Pax Exam](https://ops4j1.jira.com/wiki/display/PAXEXAM4/Pax+Exam).

## Build
Tests are perform during the _test_ phase of the build lifecycle.  To execute tests, use the following
command(s):

    mvn clean test

## Reference
* [Camel-Pax-Exam-Demo](https://github.com/ANierbeck/Camel-Pax-Exam-Demo/blob/master/route-control/src/test/java/de/nierbeck/camel/exam/demo/control/route/KarafRoutingTest.java )
