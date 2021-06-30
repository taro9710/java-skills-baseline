# Java Skills Baseline

## GIT basic commands

### 1.Introduction
What is GIT?

GIT is a software for tracking changes in any set of files, usually used for
coordinating work among programmers collaboratively developing source code
software development. Its goals include speed, data integrity, and support for
distributed, non-linear workflows (thousands of parallel branches running on
different systems).

### 2. Windows basic commands

cd [destino] change directory

cd  …/ goes back

dir shows the directories in the current position

cls clear screen

mkdir [directory_name] makes a directory

rmdir [directory_name] removes a directory

del [file_name] deletes a file

### 3. Key Concepts

1. Repository:

   Project directory where all the files and all their historical versions are located


2. Revision:

   Is a certain version of a project.


3. Commit:

   Action by which the changes we made in the computer are persisted in the repository.


4. Staging:

   It is a loading area where you can decide what is going to be saved in the next
   commit and what is going to be ignored.

### 4. GIT basic commands

1. git init

   Initializes GIT in our project.


2. git clone [URL]

   It allows us to connect to a server and download a copy of the project in our computer.


3. git remote add origin [URL]

   When we already initialized a GIT repository, so we don't want to clone the repository cuz It already exists. We use
   this command to connect it.


4. git pull

   Downloads new changes.


5. git push

   It Uploads changes in the server, so this way shares them  and makes a back up of the data.


6. git status

   It shows the status of our remote copy.


7. git add [file_name]

   Adds the file to the staging area.


8. git add -A / git add .

   Adds all the files to the staging area.


9. git commit -m "some message"

   Creates a new revision. -m (message) is the title of the changes.


10. git log

    It allows us to watch the historic versions of the project. It shows in cronological order (newest at the top & the
    latest at the bottom) all the revisions made. With the date, the author and a description.


11. git log --oneline

    Shows more history than git log, but is less detailed.


12. git log -p

    It also shows who modified and when modified the project and the exact changes in detail.


13. git log -- [file_name] (warning, there is a space between -- & [file_name])

    Shows the changes of an specific file.


14. git diff

    Shows the changes of the files.


15. git branch

    Creates a new branch.


16. git merge [branch_name]

    Merges two branches.


17. git branch -d [branch_name]

    Deletes a branch


18. git checkout [branch_name]

    Allows us to change between different branches.


19. git checkout [revision_number]

    Takes us to the revision of the specified number.


20. git checkout master

    Takes us to the latest revision.


21. git checkout --[file_name]

    Ignore the changes of a file in the staging area. This way we can control the changes for the next revision.


22. git checkout .

    Undoes all the changes of a revision.

### 5. Good Practices

1. Make commits frequently. This way they are easier to patch or revert, and it helps us to work in a more organized way.

2. Never commit work in progress.

## OOP

### 1. Introduction

Object-oriented programming (OOP) is a programming paradigm based on the concept of "objects". Objects can have attributes,
methods (witch will determine the behaviour of the object) and relations (with other objects).

It differs from other programming paradigms in tha we have abstractions or encapsulations that allows us to use the program
without necessarily having to know all the details in how the algorithm works.

### 2. Classes and Objects

- What's a class?

  A class is like a template that we can use to instanciate Objects using constructors.

Example:

    public class person {
        private String name;  
        private String lastname;
        
        public person () {} //Constructor
        public person (String name,String lastname) {
            this.name = name;
            this.lastname = lastname;
        }
        
        public void setName(String name) {
            this.name = name;
        }

        public void setLastname(String name) {
            this.name = name;
        }
    }

- Constructors

  They are used to the constructors in a class to create objects.


- Destructors

  They are used to freeing specific resources that objects acquired through their life cycle (For example memory).


- Instance method
  We need to instantiate an object in order to call them.

- Characteristics of methods

  Objects have a state, a performance (dictated by the instance methods and class methods) and references (characteristic
  or attribute that refers it unequivocally)

- Relationships between objects:

1.  Association: Objects may exist, and they have a completely independent life cycle


2. Aggregation: Is has a collaboration of the type "has a"


3. Compound: One object stops existing when the other stops existing

### 3. OOP Characteristics

1. Abstraction

   It's to take the most important aspects of the model we are trying to abstract and take those attributes by taking
   the context into consideration.


2. Encapsulation

   It's to save the performance of these objects within themselves and expose just the important and interesting factors
   that other objects want to know about them, or the ones who are interested in communicating with un within the model. So
   we will control the encapsulation level through access, the private and public level of the method or attribute and also
   through the performance within the methods.


3. Modularity

   It is the process of decomposing a problem (program) into a set of modules to reduce the overall complexity of
   the problem. We want the modules to be compact but tightly coupled. This means that we don't want modules depending on
   other modules.


4. Hierarchy inside of classes

   4.1 "Is a":

   It refers to a class and subclass. For example if we have a Flower Class the subclass would be a Rose Class,
   or a Daisy Class.

   4.2 "It is a part of":

   Here we are talking about a composition. We have a class that is going to be compound by other
   classes. Following the example of the flowers, we have the Flower Class that has particular components, there is the Petal
   Class, the Leaf and the Stem Class, those, at the same time, will be other objects that make the flower


5. Inheritance

   This is when we have a class which is the parent or superclass, and it's kid classes or subclasses. Kid classes are
   going to inherit from the parent class, the behaviour that is already defined in that class but at the same time, the kids
   may have specific behaviours for each specific class.

   The inheritance can be:

    - Simple: There is only one superclass.
    - Multiple: There can be multiple superclasses.
    - Multi-level: A derived class can be created from another derived class.
    - Hierarchical: More than one derived classes can be created from a single base class and further child classes act as
      parent classes for more than one child classes (kind of like branches on a tree).
    - Hybrid classes: This is combination of more than one inheritance.

6. Abstract classes and Interfaces

    - Abstract Classes:

      Abstract classes may exist without the need to instantiate them or create objects that belong to them, so we have
      a word that distinguish them "abstract", and they can exist without having another purpose.

    - Interface:

      An interface is a contract where we define certain methods, and they will be each classes that implements the
      interface will also implement that particular method. Interface don't have performance or logic incorporated.

7. Polymorphism

   It means "when something takes different shapes". When related with OOP, this paradigm give us the possibility of having
   several behaviours depending on the instance this method is implementing

8. Generalization y Specification

    - Generalization is finding witch performance and attributes are recurring like finding patterns throughout the
      model or problem.

    - Specialization is finding the peculiar thing of each of the objects we are working with.

### 3. Modeling Example

Now we're going to look an example of modelling a class diagram which we're then going to develop with a behavior that
we are going to apply some logic.

#### Current & Savings Accounts (in relation to a customer)

In this example we have customers and two types of counts. The current and savings accounts, which they have different
behaviors. While both accounts have a balance,the savings account has a limit to how much we can withdraw daily from
that account. Meanwhile, in the current account we can withdraw without a limit, and we can even exceed the balance.

With this context, so following the specialization concept, We want to constrain the problem as much as possible,
so it's easier to solve the problem. We will only focus in three classes. The customer class, the savings account class,
and the current account class.

![alt text](./images/oop/uml1.png)

If we apply the generalization process we can see that within the diagram that both SavingsAccount & CurrentAccount have
some standards performances, that can be compatible with a particular abstract class name Account.

![alt text](./images/oop/uml2.png)

With these diagrams we can create the classes and they'll look like this:

    public class Customer {
        private int id;
        private String name;

        public Customer() {
            name = default;
        }
        public Customer(String name) {
            this.name = name;
        }
        
        public String getName(){
            return name;

        }
    }


    public abstract class Account {
        protected double balance;
        protected List<Customer> owners;

        public Account (Collection<Customer> owners) {
            this.owners = new ArrayList<Customer>();
            balance = 0;

            for (Customer owner : owners) {
                this.owners.add(owner);
            }
        }
        
        public double getBalance(){
            return balance;
        }

        public void deposit(double amount) {
            balance += monto;
        }

        public abstract double withdraw(double amount);

    }


    public class CurrentAccount extends Account {
        private double overdraft;
        private double insufficientAmountInterest;

        public CurrentAccount (List<Customer> owners, double overdraft, double insufficientAmountInterest) {
            super(owners);
            this.overdraft = overdraft;
            this.insufficientAmountInterest = insufficientAmountInterest;
        }
        
        public double withdraw (double amount) {
            if (balance >= amount) {
                balance -= amount;
                return amount;
            } else if ((amount - balance) <= overdraft {
                balance -= amount + insufficientAmountInterest;
                return amount;
            } else {
                return 0
            }
        }

    }


    public class SavingsAccount extends Account {
        private int maxNumberOfOperations;
        private int currentOperations;
        private double annualInterestRate;

        public SavingsAccount(List<Customer> owners, int maxNumberOfOperations, double annualInterestRate) {
            super(owners);
            this maxNumberOfOperations = maxNumberOfOperations;
            this.annualInterestRate = double annualInterestRate;
            currentOperations = 1;
        }

        public double withdraw(double amount) {
            if (currentOperations <= maxNumberOfOperations) {
                if (balance >= amount) {
                    balance -= amount;
                    currentOperations += 1;

                    return amount;
                }
            }
        }
    }

### 4. Design Patterns

Design Patterns are reusable solution to a commonly occurring problem within a given context in software design.
They are like a description or template for how to solve a problem that can be used in many different situations.

- Creational patterns

  Creational patterns are the ones that allows us to create new instances inside our program in a reusable and
  cleaner way. Some of these patterns are:

    - Builder: Separate the construction of a complex object from its representation, allowing the same construction
      process to create various representations.

    - Singleton: Ensure a class has only one instance, and provide a global point of access to it.

    - Abstract Factory: Provide an interface for creating families of related or dependent objects without specifying
      their concrete classes.

    - Factory method: Define an interface for creating a single object, but let subclasses decide which class to
      instantiate. Factory Method lets a class defer instantiation to subclasses.

    - Prototype: Specify the kinds of objects to create using a prototypical instance, and create new objects from
      the 'skeleton' of an existing object, thus boosting performance and keeping memory footprints to a minimum.


- Structural patterns

  Structural patters propose certain conventions in the assembly of structures that give us possible solutions to problems
  that other programmer have solved and also propose a way of good practice for a clean and reusable code. Some of these
  are:

    - Bridge: Decouple an abstraction from its implementation allowing the two to vary independently.

    - Facade: Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level
      interface that makes the subsystem easier to use.

    - Composite: Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat
      individual objects and compositions of objects uniformly.

    - Proxy: Provide a surrogate or placeholder for another object to control access to it.

    - flyweight: Use sharing to support large numbers of similar objects efficiently.


- Behavioural patterns

  Behavioural patterns  are strategies we can implement in the communication between different modules or classes.
  Some of these are:

    - Strategy: Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the
      algorithm vary independently from clients that use it.

    - Iterator: Provide a way to access the elements of an aggregate object sequentially without exposing its
      underlying representation.

    - Template: Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
      Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

    - Visitor: 	Represent an operation to be performed on the elements of an object structure. Visitor lets a new
      operation be defined without changing the classes of the elements on which it operates.

    - Observer: Define a one-to-many dependency between objects where a state change in one object results in all its
      dependents being notified and updated automatically.

    - Memento: Without violating encapsulation, capture and externalize an object's internal state allowing the object
      to be restored to this state later.

    - Chain of responsibility: Avoid coupling the sender of a request to its receiver by giving more than one object a
      chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

    - State: Allow an object to alter its behavior when its internal state changes. The object will appear to change
      its class.


### 5. SOLID principles

#### What is SOLID?

SOLID principles are some thoughts or lineaments which allow us to have a code much cleaner, more maintainable and
comprehensible to others. SOLID stands for:

- Single Responsibility
- Open-close
- Liskov substitution
- Interface segregation
- Dependency injection

#### Single Responsibility principle
This means that every module must have one and only one responsibility.

#### Open-close principle
We will be open to extend but close to modify.

#### Liskov substitution principle
If S is a subtype of T, then objects of type T may be replaced with objects of type S without altering any of the
desirable properties of the program.

#### Interface Segregation principle
This principle states that no client should be forced to depend on methods it does not use.

#### Dependency inversion principle
The principle states:

- High-level modules should not depend on low-level modules. Both should depend on abstractions (like interfaces).
- Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.

### 6. OOP principles

#### KISS
KISS (Keep it simple). Always think in the simplest solution you can come with and avoid complexity or intricate code.

#### DRY
DRY (Don't repeat yourself) Try to reuse the code as much as possible and don't copy-paste as much, repeating and
propagating errors or making the code hart to maintain.

#### YAGNI
YAGNI (you aren't gonna need it) It's thinking about the thing we aren't using and deleting them form the code.

#### GRASP
GRASP (general responsibility assignment) which is a group of concepts that we've already seen. These are good practices
we've already used, and we group them under a single concept to describe characteristics that have systems.

## Gradle Basics

### 1. Introduction
Gradle is a Groovy-based build management system designed specifically for building Java-based projects.

### 2. Building Blocks – Projects and Tasks
In Gradle, Builds consist of one or more projects and each project consists of one or more tasks.
A project in Gradle can be assembling a jar, war or even a zip file.

A task is a single piece of work. This can include compiling classes, or creating and publishing Java/web archives.

A simple task can be defined as:

    task hello {
        doLast {
            println 'Lauta'
        }
    }
If we execute above task using gradle -q hello command from the same location where build.gradle resides, we should see
the output in the console.

#### 2.1. Tasks
Gradle's build scripts are nothing but Groovy:

    task toLower {
        doLast {
            String someString = 'HELLO WORLD IM LAUTA'
            println "Original: "+ someString
            println "Lower case: " + someString.toLowerCase()
        }
    }
We can define tasks that depend on other tasks. Task dependency can be defined by passing the dependsOn: taskName argument in a task definition:

    task helloGradle {
        doLast {
            println 'Hello Gradle!'
        }
    }

    task fromBaeldung(dependsOn: helloGradle) {
        doLast {
            println "I'm from Baeldung"
        }
    }

#### 2.2. Adding Behavior to a Task
We can define a task and enhance it with some additional behaviour:

    task helloBaeldung {
        doLast {
            println 'I will be executed second'
        }
    }

    helloBaeldung.doFirst {
        println 'I will be executed first'
    }

    helloBaeldung.doLast {
        println 'I will be executed third'
    }

    helloBaeldung {
        doLast {
            println 'I will be executed fourth'
        }
    }

doFirst and doLast add actions at the top and bottom of the action list, respectively, and can be defined multiple times
in a single task.

#### 2.3. Adding Task Properties
We can also define properties:

    task ourTask {
        ext.theProperty = "theValue"
    }
Here, we're setting “theValue” as theProperty of the ourTask task.

### 3. Managing Plugins
There are two types of plugins in Gradle.

-Script

-Binary

To benefit from an additional functionality, every plugin needs to go through two phases: resolving and applying.

- Resolving means finding the correct version of the plugin jar and adding that to the classpath of the project.

- Applying plugins is executing Plugin.apply(T) on the project.

#### 3.1. Applying Script Plugins
In the aplugin.gradle, we can define a task:

    task fromPlugin {
        doLast {
            println "I'm from plugin"
        }
    }

If we want to apply this plugin to our project build.gradle file, all we need to do is add this line to our build.gradle:

    apply from: 'aplugin.gradle'

Now, executing gradle tasks command should display the fromPlugin task in the task list.

#### 3.2. Applying Binary Plugins Using Plugins DSL
In the case of adding a core binary plugin, we can add short names or a plugin id:

    plugins {
        id 'application'
    }
Now the run task from application plugin should be available in a project to execute any runnable jar. To apply a
community plugin, we have to mention a fully qualified plugin id :

    plugins {
        id "org.shipkit.bintray" version "0.9.116"
    }
Now, Shipkit tasks should be available on gradle tasks list.The limitations of the plugins DSL are:

- It doesn't support Groovy code inside the plugins block.
- Plugins block needs to be the top level statement in project's build scripts (only buildscripts{} block is allowed
  before it).
- Plugins DSL cannot be written in scripts plugin, settings.gradle file or in init scripts.

Plugins DSL is still incubating. The DSL and other configuration may change in the later Gradle versions.

#### 3.3. Legacy Procedure for Applying Plugins
We can also apply plugins using the “apply plugin”:

    apply plugin: 'war'
If we need to add a community plugin, we have to add the external jar to the build classpath using buildscript{} block.

Then, we can apply the plugin in the build scripts but only after any existing plugins{} block:

    buildscript {
        repositories {
            maven {
                url "https://plugins.gradle.org/m2/"
            }
        }
        dependencies {
            classpath "org.shipkit:shipkit:0.9.117"
        }
    }
    apply plugin: "org.shipkit.bintray-release"

### 4. Dependency Management
   Gradle supports very flexible dependency management system, it's compatible with the wide variety of available approaches.

*Best practices for dependency management in Gradle are versioning, dynamic versioning, resolving version conflicts and 
managing transitive dependencies.*

#### 4.1. Dependency Configuration
Dependencies are grouped into different configurations. 
*A configuration has a name and they can extend each other.*

If we apply the Java plugin, we'll have compile, testCompile, runtime configurations available for grouping our dependencies. 
*The default configuration extends “runtime”.*

#### 4.2. Declaring Dependencies
Let's look at an example of adding some dependencies (Spring and Hibernate) using several different ways:

    dependencies {
        compile group: 
            'org.springframework', name: 'spring-core', version: '4.3.5.RELEASE'
        compile 'org.springframework:spring-core:4.3.5.RELEASE',
            'org.springframework:spring-aop:4.3.5.RELEASE'
        compile(
            [group: 'org.springframework', name: 'spring-core', version: '4.3.5.RELEASE'],
            [group: 'org.springframework', name: 'spring-aop', version: '4.3.5.RELEASE']
        )
        testCompile('org.hibernate:hibernate-core:5.2.12.Final') {
            transitive = true
        }
        runtime(group: 'org.hibernate', name: 'hibernate-core', version: '5.2.12.Final') {
            transitive = false
        }
    }

We're declaring dependencies in various configurations: compile, testCompile, and runtime in various formats.

Sometimes we need dependencies that have multiple artifacts. In such cases, we can add an artifact-only notations 
@extensionName (or ext in the expanded form) to download the desired artifact:

    runtime "org.codehaus.groovy:groovy-all:2.4.11@jar"
    runtime group: 'org.codehaus.groovy', name: 'groovy-all', version: '2.4.11', ext: 'jar'
Here, we added the @jar notation to download only the jar artifact without the dependencies.

To add dependencies to any local files, we can use something like this:

    compile files('libs/joda-time-2.2.jar', 'libs/junit-4.12.jar')
    compile fileTree(dir: 'libs', include: '*.jar')

*When we want to avoid transitive dependencies, we can do it on configuration level or on dependency level:*

    configurations {
        testCompile.exclude module: 'junit'
    }

    testCompile("org.springframework.batch:spring-batch-test:3.0.7.RELEASE"){
        exclude module: 'junit'
    }

### 5. Multi-Project Builds
#### 5.1. Build Lifecycle
*In the initialization phase, Gradle determines which projects are going to take part in a multi-project build.* This is
usually mentioned in settings.gradle file, which is located in the project root. Gradle also creates instances of the 
participating projects.

*In the configuration phase, all created projects instances are configured based on Gradle feature configuration on 
demand.*

In this feature, only required projects are configured for a specific task execution. This way, configuration time is 
highly reduced for a large multi-project build. This feature is still incubating.

Finally, in the execution phase, a subset of tasks, created and configured are executed. We can include code in the 
settings.gradle and build.gradle files to perceive these three phases.

In settings.gradle :

    println 'At initialization phase.'

In build.gradle :

    println 'At configuration phase.'

    task configured { println 'Also at the configuration phase.' }

    task execFirstTest { doLast { println 'During the execution phase.' } }

    task execSecondTest {
        doFirst { println 'At first during the execution phase.' }
        doLast { println 'At last during the execution phase.' }
        println 'At configuration phase.'
    }

#### 5.2. Creating Multi-Project Build
We can execute the gradle init command in the root folder to create a skeleton for both settings.gradle and build.gradle 
file.

All common configuration will be kept in the root build script:

    allprojects {
        repositories {
            mavenCentral()
        }
    }

    subprojects {
        version = '1.0'
    }

The setting file needs to include root project name and subproject name:

    rootProject.name = 'multi-project-builds'
    include 'greeting-library','greeter'

Now we need to have a couple of subproject folders named greeting-library and greeter to have a demo of a multi-project 
build. Each subproject needs to have an individual build script to configure their individual dependencies and other 
necessary configurations.

If we'd like to have our greeter project dependent on the greeting-library, we need to include the dependency in the build script of greeter:

    dependencies {
        compile project(':greeting-library')
    }

### 6. Using Gradle Wrapper
If a Gradle project has gradlew file for Linux and gradlew.bat file for Windows, we don't need to install Gradle to 
build the project. If we execute gradlew build in Windows and ./gradlew build in Linux, a Gradle distribution specified 
in gradlew file will be downloaded automatically.

If we'd like to add the Gradle wrapper to our project:

    gradle wrapper --gradle-version 4.2.1
The command needs to be executed from the root of the project. This will create all necessary files and folders to tie Gradle wrapper to the project. The other way to do the same is to add the wrapper task to the build script:

    task wrapper(type: Wrapper) {
        gradleVersion = '4.2.1'
    }
Now we need to execute the wrapper task and the task will tie our project to the wrapper. Besides the gradlew files, a wrapper folder is generated inside the gradle folder containing a jar and a properties file.

If we want to switch to a new version of Gradle, we only need to change an entry in gradle-wrapper.properties.

## Core Spring Concepts


### 1. Introduction to Spring Framework

Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications.
Spring handles the infrastructure so you can focus on your application.
Spring enables you to build applications from “plain old Java objects” (POJOs) and to apply enterprise services
non-invasively to POJOs. This capability applies to the Java SE programming model and to full and partial Java EE.

Examples of how you, as an application developer, can use the Spring platform advantage:
- Make a Java method execute in a database transaction without having to deal with transaction APIs.
- Make a local Java method a remote procedure without having to deal with remote APIs.
- Make a local Java method a management operation without having to deal with JMX APIs.
- Make a local Java method a message handler without having to deal with JMS APIs.

#### 1.1 Dependency Injection and Inversion of Control
Java applications -- a loose term that runs the gamut from constrained applets to n-tier server-side enterprise 
applications -- typically consist of objects that collaborate to form the application proper. Thus the objects in an 
application have dependencies on each other.

Although the Java platform provides a wealth of application development functionality, it lacks the means to organize 
the basic building blocks into a coherent whole, leaving that task to architects and developers. True, you can use 
design patterns such as Factory, Abstract Factory, Builder, Decorator, and Service Locator to compose the various 
classes and object instances that make up an application. However, these patterns are simply that: best practices given 
a name, with a description of what the pattern does, where to apply it, the problems it addresses, and so forth. 
Patterns are formalized best practices that you must implement yourself in your application.

*The Spring Framework Inversion of Control (IoC)*
component addresses this concern by providing a formalized means of 
composing disparate components into a fully working application ready for use. The Spring Framework codifies formalized 
design patterns as first-class objects that you can integrate into your own application(s). Numerous organizations and 
institutions use the Spring Framework in this manner to engineer robust, maintainable applications

#### 1.2 Modules
The Spring Framework consists of features organized into about 20 modules. These modules are grouped into Core 
Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, and Test, as shown in the 
following diagram.

![alt text](./images/core-spring-concepts/spring-modules.png)



