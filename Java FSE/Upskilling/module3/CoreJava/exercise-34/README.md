# Exercise 34: Create and Use Java Modules

Because this requires a very specific directory structure, I have mocked up the required files here.
To run this properly:
1. `javac -d out --module-source-path src $(find src -name "*.java")`
2. `java --module-path out -m com.greetings/com.greetings.Main`
