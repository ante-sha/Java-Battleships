# Getting Started...

## Download JDK (Java Development Kit) from Oracle:

http://www.oracle.com/technetwork/java/javase/downloads/index.html

Click on the JDK download button.

Follow the installation instructions for your OS.

## Verify JDK installation:

```bash
/Users/widders
> JAVA -version
java version "10.0.1" 2018-04-17
Java(TM) SE Runtime Environment 18.3 (build 10.0.1+10)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.1+10, mixed mode)
```

## Verify compiler:

```bash
> javac -version
javac 10.0.1
```

## Test that the JDK works:

Create a file HelloWord.java:

```bash
/Users/widders/JavaProject/HelloWorld
> ls -ltr
total 8
-rw-r--r--  1 widders  staff  119 Jul 12 14:40 HelloWorld.java
```

```java
class HelloWorld
{
    public static void main(String args[])
    {
        System.out.println("Hello World");
    }
}
```

Compile the Java code:
```bash
> javac HelloWorld.java
```

Creates this:
```bash
> ls -ltr
total 16
-rw-r--r--  1 widders  staff  119 Jul 12 14:40 HelloWorld.java
-rw-r--r--  1 widders  staff  425 Jul 12 14:42 HelloWorld.class
```

Run the compiled code without any file suffix (.java or .class):
```bash
> java HelloWorld
```
