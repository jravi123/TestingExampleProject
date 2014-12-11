TestingExampleProject
=====================

This project provides sample test cases using both Junit and Robolectric framework.  Test cases are under the default Android Testing  package which is sr/androidTest/java and the main files are under src/main/java

The simple JUnit test case GenerateEvenIntegerTest is written for the main java file GenerateEvenInteger

The simple Robolectric test case MainActivityTest is written for the MainActivity class.

To run both the tests follow the steps below:

1. From your Android Studio click on 'Terminal' tab at the bottom.  
2. Navigate one folder back by entering 'cd ..' at the terminal
3. run the tests by typing ' ./gradlew clean test'  from the terminal

Gradle compiles and runs all the testcases in the androidTest folder.
