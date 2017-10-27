# OCP Chapter 9 - NIO2 Non Blocking IO

### Why is NIO.2 around?
- performance improvements over *java.io.File*
- introduces the *java.nio.file.Path* interface

### Why is the *Path* interface superior to *File*?
- Path supports symbolic links
- 

*Path* is an interface because the JVM is then able to give you back an object that transparently handles system-specific details for a platform.
A Path object is not a file but a representation of a location within a file system
This means you can write the same code that is able to run on a variety of platforms that differ on type of filesystem.

#### NIO.2 class and interface relationships
<img src="./src/main/java/studyNotes/images/ch9-ocp-java-nio2classes.png"> </img>

## How to create Paths?
1. Use the *Paths* class
2. Using the *FileSystem* object
3. Using a legacy *File* instance


#### 1. Using the Paths class
```java
// Create path reference to a relative file in the current working directory
Path path1 = Paths.get("pandas/cuddly.png");
 
// Path reference to absolute file in Windows-based system
Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt");

// Path reference to an absolute directory in a Linux system
Path path3 = Paths.get("/home/zoodirector");
```
##### Using a Uniform Resource Identifier (URI) with *Paths*
A URI is a string of characters that identifies a resource.
Begins with a schema that indicates resource type, followed by path value. E.g. schemas - file://, http://, https://, ftp://
```java
Path path1 = Paths.get(new URI("file://pandas/cuddly.png")); // THROWS EXCEPTION AT RUNTIME
Path path2 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
Path path3 = Paths.get(new URI("file:///home/zoodirectory"));
Path path4 = Paths.get(new URI("http://www.wiley.com"));
Path path5 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
```
First example throws exception at runtime as URIs must reference absolute paths at runtime.
The Path interface also contains a reciprocal method *toUri()* for converting a Path instance back to a URI instance.
```java
Path path4 = Paths.get(new URI("http://www.wiley.com"));
URI uri4 = path4.toUri();
```
#### 2. Using the *FileSystem* object
```java
Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
Path path2 = FileSystems.getDefault().getPath("c:","zooinfo","November",
"employees.txt");
Path path3 = FileSystems.getDefault().getPath("/home/zoodirector");
```

*FileSystems* factory class also give us the ability to connect to the remote file system
```java
FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
Path path = fileSystem.getPath("duck.txt");
```

#### 3. Working with Legacy File Instances
```java
File file = new File("pandas/cuddly.png");
Path path = file.toPath();
```

For backwards compatibility, Path interface contains a method toFile() to return to a File instance
```java
Path path = Paths.get("cuddly.png");
File file = path.toFile();
```

### Providing Optional Arguments
#### NIO.2 class and interface relationships
<img src="./src/main/java/studyNotes/images/ch9-ocp-java-common-optional-arguments.png"> </img>

## Using *Path* Objects
<img src="./src/main/java/studyNotes/images/ch9-ocp-java-file-vs-path.png"> </img>

#### Methods on the *Path* interface

| <big>Method</big>           | <big>Notes</big>                    |
| --------------------------- | :---------------------------------- |
| ```path.toString()```       | String representation of entire path|
| ```path.getNameCount()```   | Retrieve number of elements in path |
| ```path.getName(int index)```        | Retrieve reference to an element in path |
| ```path.getFileName()```    | Returns path instance|
| ```path.getParent()```      | Returns path instance representing parent path or null (if no such parent)|
| ```path.getRoot()```        | Returns root element for path object, or null if the path is relative<br> - Returns **null** if path is relative |
| ```path.isAbsolute()```     | Returns true if object references absolute path, false if relative<br> - dependant on the underlying filesystem|
| ```path.toAbsolutePath()``` | Converts relative path to absolute path by joining to current working directory|
| ```path.subPath()```        | Returns relative subpath of Path object referenced by inclusive start index and exclusive end index|
| ```path.relativize()```     | Construct the relative path from one path object to another|
| ```path.resolve()```        | Create a new path by joining an existing path to the current path |
| ```path.normalize()```      | Eliminates redundancies in a path (e.g. by having multiple .. and . in a path)|
| ```path.toRealPath()```     | Returns a reference to a real path within the file system.|

## Java Examples
### _toString(), getNameCount(), getName()_
```java
Path path = Paths.get("/land/hippo/harry.happy");
System.out.println("The Path Name is: "+path);
for(int i=0; i<path.getNameCount(); i++) {
    System.out.println("Element "+i+" is: "+path.getName(i));
}

// Outputs
The Path Name is: /land/hippo/harry.happy
Element 0 is: land
Element 1 is: hippo
Element 2 is: harry.happy
```
Notice that the root element / is not included in the list of names. If the Path object
represents the root element itself, then the number of names in the Path object returned by
getNameCount() will be 0.

What if we ran the preceding code using the relative path land/hippo/harry.happy ?
The output would be as follows:
```java
// Outputs
The Path Name is: land/hippo/harry.happy
Element 0 is: land
Element 1 is: hippo
Element 2 is: harry.happy
```
Notice that the individual names are the same. For the exam, you should be aware that
the getName(int) method is zero-indexed, with the file system root excluded from the path
components.

### _getFileName(), getParent(), getRoot()_
```java
public class PathFilePathTest {
    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println("    Current parent is:  "+currentParent);
        }

    public static void main(String[] args) {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("armadillo/shells.txt"));
    }
}

// Outputs
Filename is: shells.txt
Root is: /
    Current parent is: /zoo/armadillo
    Current parent is: /zoo
    Current parent is: /Interacting with Paths and Files
        
Filename is: shells.txt
Root is: null
    Current parent is: armadillo
```

### _isAbsolute(), toAbsolutePath()_
```java
Path path1=Paths.get("C:\\birds\\egret.txt");
System.out.println("Path1 is Absolute? "+path1.isAbsolute());
System.out.println("Absolute Path1: "+path1.toAbsolutePath());

// Assume the current working directory where this is run is /home
Path path2=Paths.get("birds/condor.txt");
System.out.println("Path2 is Absolute? "+path2.isAbsolute());
System.out.println("Absolute Path2 "+path2.toAbsolutePath());

// Outputs
Path1 is Absolute? true
Absolute Path1: C:\birds\egret.txt
 
Path2 is Absolute? false
Absolute Path2 /home/birds/condor.txt
```

## Methods on the *Files* class

