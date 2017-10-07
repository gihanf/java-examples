# OCP Chapter 4 - Functional Programming

#### Common Functional Interfaces
| **Functional Interface** | **# Parameters** | **Return Type** | **Single Abstract** Method |
| -------------            | :-----------:    | -----------:    | ----------------------:    |
| Supplier`<T>`            | 0                | T               | get                        |
| Consumer`<T>`            | 1 (T)            | void            | accept                     |
| BiConsumer`<T,U>`        | 2 (T, U)         | void            | accept                     |
| Predicate`<T>`           | 1 (T)            | boolean         | test                       |
| BiPredicate`<T,U>`       | 2 (T, U)         | boolean         | test                       |
| Function`<T,R>`          | 1 (T)            | R               | apply                      |
| BiFunction`<T,U,R>`      | 2 (T, U)         | R               | apply                      |
| UnaryOperator`<T>`       | 1 (T)            | T               | apply                      |
| BinaryOperator`<T>`      | 2 (T, T)         | T               | apply                      |

By definition, all functional interfaces have a single abstract method. It doesn't mean they only have one method, though. Some interfaces have a bunch of helpful default methods.

```java
Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

Predicate<String> brownEggs = egg.and(brown);
Predicate<String> otherEggs = egg.and(brown.negate());

```

**UnaryOperator** and **BinaryOperator** are special cases of functions - they require all parameters to be of the same type.

#### Working With Optionals
| **Method**              | **When Optional is Empty** | **When Optional Contains a Value** |
| ----------------------- | :--------------------------| :--------------------------------- |
| get()                   | Throws an exception        | Returns value                      |
| ifPresent(Consumer c)   | Does nothing               | Calls consumer c with value        |
| isPresent()             | Returns false              | Returns true                       |
| orElse(T other)         | Returns other parameter    | Returns value                      |
| orElseGet(Supplier s)   | Returns other parameter created by supplier | Returns value     |
| orElseThrow(Supplier s) | Throws exception created by supplier s | Returns value          |
