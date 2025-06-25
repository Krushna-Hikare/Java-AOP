# learnAOP

A simple Spring Boot project to learn and demonstrate **Aspect Oriented Programming (AOP)** concepts such as Aspect, Weaving, PointCut, JoinPoint, and Advice.

## Features

- **Spring Boot** application with REST API.
- Demonstrates AOP concepts using Spring AOP and AspectJ.
- Example of logging before, after, and around a service method using custom aspects.
- Includes a simple user service and REST endpoint.

## Key Concepts Demonstrated

- **Aspect**: A module that encapsulates cross-cutting concerns (e.g., logging).
- **Advice**: Action taken by an aspect at a particular join point (e.g., `@Before`, `@After`, `@Around`).
- **JoinPoint**: A point during execution (e.g., method call) where an advice can be applied.
- **PointCut**: An expression that matches join points (e.g., all calls to `login()`).
- **Weaving**: The process of linking aspects with other application types or objects.

## Project Structure

```
app/
  src/
    main/
      java/
        org/
          example/
            App.java                # Main Spring Boot application
            api/
              rest.java            # REST controller exposing login endpoint
            services/
              userService.java     # Service with login/logout methods
            logging/
              Logging.java         # Aspect for logging advice
    test/
      java/
        org/
          example/
            AppTest.java           # (Sample test)
  build.gradle                     # Gradle build file
```

## How it Works

- The `userService` class provides a `login()` method.
- The `Logging` aspect uses `@Before`, `@After`, and `@Around` advices to log messages when `login()` is called.
- The `rest` controller exposes a `/` endpoint that triggers the `login()` method.
- When you call the endpoint, you will see log messages from the aspect in the console.

## Example Aspect (`Logging.java`)

```java
@Aspect
@Component
public class Logging {
    @Before("execution(public void org.example.services.userService.login())")
    public void loggingAdvice1() {
        System.out.println("Before login method");
    }

    @After("execution(public void org.example.services.userService.login())")
    public void loggingAdvice2() {
        System.out.println("After login method");
    }

    @Around("execution(public void org.example.services.userService.login())")
    public void loggingAdvice3() {
        System.out.println("Around login method");
    }
}
```

## Running the Project

1. **Build and run** using Gradle:
   ```
   ./gradlew bootRun
   ```
   or on Windows:
   ```
   gradlew.bat bootRun
   ```

2. **Test the endpoint**:
   - Open your browser or use `curl`:
     ```
     curl http://localhost:8080/
     ```
   - You should see `"User login endpoint called successfully."` in the response and logging output in the console.

## Dependencies

- Spring Boot 2.6.x
- Spring Boot Starter Web
- Spring Boot Starter AOP
- AspectJ
- Lombok

## Learning References

- [Spring AOP Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
- [AspectJ Programming Guide](https://www.eclipse.org/aspectj/doc/next/progguide/index.html)
