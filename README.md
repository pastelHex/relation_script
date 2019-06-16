# relation_script
jflex + cup

Language that allows to define relations:

DEF: a RELATION b { a < b };
DEF: a BIGGER b { a > b };

with operators <,>,<=,>=,==,!=.

Operations on sets:

A is {1,2};
B is {3,4};
C is A + B;

Basic expressions such as:

a is 0;
a is 3 RELATION 5;

And IF statement:

x -> { if x is true }~{ if x is false };

