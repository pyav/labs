# labs
This is a repository of codes which I work on while solving problems, codes which I experiment on while learning a topic in computer science. 

## Compilation
Following command may be used to compile **.c** files:

 **gcc -Wall \<filename\>**

## Execution
The above command generates object file with the name **a.out**. Following command
may be used to execute the object file:

 **./a.out**

If execute permission is not given to the object file, following command may be
used to assign the execute permission:

 **chmod u+x a.out**

The above command assigns execute permission to the user owner of the file
**a.out**. This permission may be validated either by executing the object file
a.out as per above command or by listing the details of file by the command:

 **ls -l a.out**

## Valgrind command to check memory leak
 **valgrind -v --tool=memcheck --leak-check=yes ./a.out**

