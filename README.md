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
