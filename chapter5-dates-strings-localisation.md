# OCP Chapter 5 - Dates, Strings and Localisation

#### Resource Bundles

Order in which properties are sourced from a Resource Bundle
1. Bundle_en_US.properties
2. Bundle_en.properties
3. Bundle.properties

Not everything that you specify in a ***java class*** bundle can be expressed in a ***property*** bundle. E.g. a java class bundle can have non-String values, property files are limited to strings.

```java
// Fetching from a 'Properties' object
props.get("version")
props.getProperty("version", "default if not present);
```

### Time

```java
LocalDate date = LocalDate.of(2014, 4, 24);

// Years, Months, Days
Period.of()

// Hours, Minutes, Seconds
Duration.of()

```

You cannot chain these method calls

#### Daylight Savings

Which way do the clocks move during daylight savings?

Spring forward!

Fall back!

We change our clocks at 2am of the daylight savings day.
Java still calculates the time difference as 1 hour between the two times, (because it takes into account the GMT) GMT is affected during daylight savings.
