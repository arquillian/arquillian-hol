## Lab 02 - Getting to know Ike

### Objectives

During this lab you will learn:

* What kind of challenge in the testing landscape Arquillian is trying to solve? 
* What are the core functionalities of Arquillian.
* What is required for JUnit tests to be handled by Arquillian.
* How to define a deployment.
* How to run the test in GlassFish Embedded both using a build tool and directly from the IDE.

### Task

First step is to fix the failing test [`ch.open.arquillian.lab02.FluidOuncesConverterTest`](https://github.com/arquillian/arquillian-hol/blob/master/lab02/src/test/java/org/arquillian/hol/lab02/FluidOuncesConverterTest.java) by implementing following interface with the logic for converting fluid ounces to millliliters

    public interface FluidOuncesConverter {

	    double convertToMilliliters(double ounces);

	}

Next step is to make it an `@EJB` component and test in WildFly 9.0.0.Final (already pre-configured in `pom.xml` and `arquillian.xml`). This will require following steps
* Enhance our test to be Arquillian powered.
* Define a deployment package programmatically using **ShrinkWrap**
* Run the test from the command line using `mvn clean package`
* Run it directly from the IDE

The solution is available [here](https://github.com/arquillian/arquillian-hol/tree/master/lab02-solution).