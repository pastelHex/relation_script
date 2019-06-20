# relation_script
jflex + cup

It's a simple language that allows to define relations. All relations return 0 or 1 as true or false. Relations names are always CAPITAL_LETTERS.


```
DEF: a RELATION b { a < b };

DEF: a BIGGER b { a > b };
```

Simple variables contain Integer, but as now, only logic operation are allowed such as
```
<,>,<=,>=,==,!=

a is 0;

a is 3 RELATION 5;
```
Possible are operations on sets:

```
A is {1,2};

C is A + {3};
```
And there are two types of IF clause, one is standalone:

```
IF 1 -> { a is 1 }~{ b is a };

IF a REL b -> { a is 0 }~{ b is 1 };
```

and second is returning IF in relation:

```
DEF: a DD b { IF a < b -> { a==1 }~{ b==0 } };
```
