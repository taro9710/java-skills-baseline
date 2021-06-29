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