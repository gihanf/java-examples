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
| ```path.subPath()```        | Returns relative subpath of Path object referenced by inclusive start index and exclusive end index<br> - 0-indexed element does not include root directory<br> subPath(int inclusive, int exclusive)|
| ```path.relativize()```     | Construct the relative path from one path object to another<br> - throws IllegalArgumentException if both paths are not the same type (relative/absolute<br> - does not actually check whether file exists|
| ```path.resolve()```        | Create a new path by joining an existing path to the current path<br> - does not clean up path variables<br> - if mixing with an absolute path, absolute path is returned |
| ```path.normalize()```      | Eliminates redundancies in a path (e.g. by having multiple .. and . in a path)|
| ```path.toRealPath()```     | Returns a reference to a real path within the file system.<br> - Have to catch IOException|

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
### _subPath(int inclusive, int exclusive)_
```java
Path path = Paths.get("/mammal/carnivore/raccoon.image");
System.out.println("Path is: "+path);
 
System.out.println("Subpath from 0 to 3 is: "+path.subpath(0,3));
System.out.println("Subpath from 1 to 3 is: "+path.subpath(1,3));
System.out.println("Subpath from 1 to 2 is: "+path.subpath(1,2));

// Outputs
Path is: /mammal/carnivore/raccoon.image
Subpath from 0 to 3 is: mammal/carnivore/raccoon.image
Subpath from 1 to 3 is: carnivore/raccoon.image
Subpath from 1 to 2 is: carnivore
```

0-indexed element does not include root directory

### _relativize()_
```java
Path path1 = Paths.get("fish.txt");
Path path2 = Paths.get("birds.txt");
// give me a path that takes me to path2 from path1
System.out.println(path1.relativize(path2));
System.out.println(path2.relativize(path1));

// Outputs
..\birds.txt
..\fish.txt
```

When both path values are absolute, method computes relative path from one absolute location to another, regardless of current working directory.
```java
Path path3 = Paths.get("E:\\habitat");
Path path4 = Paths.get("E:\\sanctuary\\raven");
System.out.println(path3.relativize(path4));
System.out.println(path4.relativize(path3));

// Outputs
..\sanctuary\raven
..\..\habitat
```
Requires *both* paths to be **absolute** or *both* paths to be **relative**
A IllegalArgumentException will be thrown at runtime if they are mixed

### _resolve()_

the object on which the resolve() method is invoked becomes the basis of the new Path object, with the input argument being appended onto the Path

```java
final Path path1 = Paths.get("/cats/../panther");
final Path path2 = Paths.get("food");
System.out.println(path1.resolve(path2));

// Outputs
/cats/../panther/food

```

When both paths are absolute:
```java
final Path path1 = Paths.get("/turkey/food");
final Path path2 = Paths.get("/tiger/cage");
System.out.println(path1.resolve(path2));

// Outputs
/tiger/cage
```

### _normalize()_
```java
Path path3 = Paths.get("E:\\data");
Path path4 = Paths.get("E:\\user\\home");

Path relativePath = path3.relativize(path4);
System.out.println(path3.resolve(relativePath));

// Outputs
E:\data\..\user\home

System.out.println(path3.resolve(relativePath).normalize());

// Outputs
E:\user\home
```

### _toRealPath_
```java
// Assume:
// - current working directory is /horse/schedule
// - we have a file system in which we have a symbolic link from food.source
// to food.txt , as described in the following relationship:
// /zebra/food.source → /horse/food.txt

try {
    System.out.println(Paths.get("/zebra/food.source").toRealPath());
 
    System.out.println(Paths.get(".././food.txt").toRealPath());
} catch (IOException e) {
// Handle file I/O exception...
}

// Outputs
/horse/food.txt
/horse/food.txt
```

## Methods on the *Files* class

| <big>Method</big>                             | <big>Notes</big>                    |
| --------------------------------------------- | :---------------------------------- |
| ```Files.exists(Path)```                      | Returns true if file exists in filesystem|
| ```Files.isSameFile(Path, Path)```            | Returns true if two paths refer to same file in filesystem|
| ```Files.createDirectory(Path)```             | Creates a directory|
| ```Files.createDirectories(Path)```           | Creates directory and all non existent parent directories|
| ```Files.copy(Path, Path)```                  | Copies file or directory from one location to another<br> - throws checked IOException when file or directory does not exist or cannot be read<br> - directory copy is shallow (i.e. does not copy all containing files)<br> - by default, will traverse symbolic links (can be modified wi options NOFOLLOW_LINKS, REPLACE_EXISTING, COPY_ATTRIBUTES)<br> - will not overwrite a file or directory that already exists|
| ```Files.move(Path, Path)```                  | Moves or renames a file or directory within the filesystem<br> - thows checked IOException when file or directory can't be found/moved<br>- follows symbolic links|
| ```Files.delete(Path)```                      | Delete a file or directory in filesystem<br> - if target is symbolic link, link will be deleted|
| ```Files.deleteIfExists(Path)```              | Like delete() but won't throw exception when file does not exist|
| ```Files.newBufferredReader(Path, Charset)``` | Reads file at path using a bufferedReader object|
| ```Files.newBufferredWriter(Path, Charset)``` | Writes file at path using a bufferedWriter object|
| ```Files.readAllLines(Path)```                | Reads all lines from text file into a List<String><br> - be careful, this could be a  large list. OutOfMemory error could be thrown|

## File Attributes
| <big>Method</big>                             | <big>Notes</big>                    |
| --------------------------------------------- | :---------------------------------- |
| ```Files.isDirectory(Path)```                 | returns whether path refers to directory|
| ```Files.isRegularFile(Path)```               | returns whether path refers to regular file<br> - if path is a symbolic link that refers to a regular file, this method will return true.|
| ```Files.isSymbolicLink(Path)```              | returns whether path refers to a symbolic link, regardless of whether the link resolves a file/directory that exists|
| ```Files.isHidden(Path)```                    | returns whether file/directory is hidden. E.g. in linux, a file beginning with '.'<br> - throws a checked IOException as there may be an I/O error reading underlying file information|
| ```Files.isReadable(Path)```                  | Checks whether user has read permission on a file.<br> - does not throw exception if file doesn't exist, just returns false|
| ```Files.isExecutable(Path)```                | Checks whether user has execute permission on a file.<br> - does not throw exception if file doesn't exist, just returns false|
| ```Files.size(Path)```                        | Returns length of file in bytes as a long.<br> - throws checked IOException if file does not exist / process is unable to read file information.|
| ```Files.getLastModifiedTime(Path)```         | Returns a FileTime object of when the file was last modified.|
| ```Files.setLastModifiedTime(Path, FileTime)``` | Update the last modified time of a file.|
| ```Files.getOwner(Path)```                    | Returns an instance of UserPrincipal representing owner<br> - can throw a checked IOException|
| ```Files.setOwner(Path, UserPrincipal)```     | Sets the owner of a file.<br> - can throw a checked IOException|

### Files methods - **isDirectory(), isRegularFile(), isSymbolicLink()**
Assume the following:
- /canine/coyote and /canine/types.txt exists
- /coyotes is a symobolic link pointing to another path within the filesystem

<img src="./src/main/java/studyNotes/images/ch9-ocp-files-methods.png"> </img>

## Improving Access with Views
- Accessing individual file attributes with single method calls can be expensive
- It is more efficient to retrieve all the file metadata attributes in a single call
- A *_view*_ is group of related attributes for a particular file system type. When reading multiple attributes of a file / directory, using a view is a performance advantage
- To request a view, provide a **path** to the file / directory whose information you want to read as well as a **class object** which describes which type of view you want returned

### Types of Views
1. Files.readAttributes(Path, AttributeClass) - returns **read-only** view of the file attributes
2. Files.getFileAttributeView() - returns underlying attribute view, and provides direct resource for **modifying** file information

Both these methods can throw a checked IOException when the view class type is unsupported.

<img src="./src/main/java/studyNotes/images/ch9-ocp-attributes-and-view-classes.png"> </img>

#### BasicFileAttributes
```java
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributesSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/turtles/sea.txt");
        BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("Is path a directory? " + data.isDirectory());
        System.out.println("Is path a regular file? " + data.isRegularFile());
        System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
        System.out.println("Path not a file, directory, nor symbolic link? " +data.isOther());

        System.out.println("Size (in bytes): " + data.size());

        System.out.println("Creation date/time: " + data.creationTime());
        System.out.println("Last modified date/time: " + data.lastModifiedTime());
        System.out.println("Last accessed date/time: " + data.lastAccessTime());
        System.out.println("Unique file identifier (if available): " + data.fileKey());
    }
}
```

#### BasicFileAttributesView
```java
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class BasicFileAttributeViewSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/turtles/sea.txt");

        BasicFileAttributeView view = Files.getFileAttributeView(path,BasicFileAttributeView.class);
        BasicFileAttributes data = view.readAttributes();

        FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis()+10_000);

        view.setTimes(lastModifiedTime,null,null);
    }
}
```
- NIO.2 API allows us to pass *null* for any value we don't wish to modify
```java
view.setTimes(lastModifiedTime, null, null)
```
## Stream Methods in NIO.2
2 common search strategies associated with walking a directory tree:
1. depth-first search
2. breadth-first search
- Streams API uses **depth-first** searching with a maximum depth of Integer.MAX_VALUE

### Walking a Directory
- Files.walk(path) method returns a Stream<Path> that traverses dir in depth-first manner, **lazily** (set of elements is built and read while the directory is being traversed.)
- Files.walk(path) will **not** traverse symbolic links by default. Symbolic links could leave to circular paths (cycles)
- Files.walk(path, int) allows you to specify the depth explicitly
    
```java
Path path = Paths.get("/bigcats");
 
try {
    Files.walk(path)
    .filter(p -> p.toString().endsWith(".java"))
    .forEach(System.out::println);
} catch (IOException e) {
    // Handle file I/O exception...
}

// Sample output
/bigcats/version1/backup/Lion.java
/bigcats/version1/Lion.java
/bigcats/version1/Tiger.java
/bigcats/Lion.java
```

### Searching a Directory
- Files.find(path, int, BiPredicate) behaves similar to Files.walk() except it requires the depth value to be explicitly set.
- For the BiPredicate, the two objects are Path and BasicFileAttributes

```java
Path path = Paths.get("/bigcats");
long dateFilter = 1420070400000l;
 
try {
    Stream<Path> stream = Files.find(path, 10,
    (p,a) -> p.toString().endsWith(".java")
    && a.lastModifiedTime().toMillis()>dateFilter);
    stream.forEach(System.out::println);
} catch (Exception e) {
    // Handle file I/O exception...
}
```

### Listing Directory Contents
- Although you could use the Files.walk() with max depth of 1, Files.list(path) does this for you
- Assume that the current working directory is /zoo:

```java
try {
Path path = Paths.get("ducks");
Files.list(path)
    .filter(p -> !Files.isDirectory(p))
    .map(p -> p.toAbsolutePath())
    .forEach(System.out::println);
} catch (IOException e) {
    // Handle file I/O exception...
}

// Output
/zoo/ducks/food.txt
/zoo/ducks/food-backup.txt
/zoo/ducks/weight.txt
```

### Printing File Contents
- Files.readAllLines(path) could be used to do this but is vulnerable to an OutOfMemory error for large files.
- Files.lines(path) is the alternative which returns a Stream<String>
```java
Path path = Paths.get("/fish/sharks.log");
try {
    Files.lines(path).forEach(System.out::println);
} catch (IOException e) {
    // Handle file I/O exception...
}
```