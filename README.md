# Labs
This is a repository of codes that I work on while solving problems, codes that
I experiment on while learning a topic in computer science. The directory 'docs'
is meant to keep all the documents, links, etc that I think are helpful in
getting some idea of different topics in computer science or otherwise that I
explore. 

## Compilation 
Following command may be used to compile a **.c** file:

 **gcc -Wall \<filename\>**

Following command may be used to compile a **.java** file:

 **javac \<filename\>**

## Execution 
### Execute c code 
The above command for compiling a **.c** file generates object file with the
name **a.out**. Following command may be used to execute the object file:

 **./a.out**

If execute permission is not given to the object file, following command may be
used to assign the execute permission:

 **chmod u+x a.out**

The above command assigns execute permission to the user owner of the file
**a.out**. This permission may be validated either by executing the object file
a.out as per above command or by listing the details of file by the command:

 **ls -l a.out**

### Execute Java code 
The compilation of a **.java** file with javac command (as
given above) generates a **.class** file which can be run by the following
command:

 **java \<filename without extension\>**

### Run a python code 
Following command may be executed to run a python file:

 **python \<filename\>**

### Check memory leak 
Execute the following command to check mem-leak for the object file generated
after compiling the c code:

 **valgrind -v --tool=memcheck --leak-check=yes ./a.out**

