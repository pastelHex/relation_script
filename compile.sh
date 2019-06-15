java -jar jflex-full-1.7.0.jar src/jflex/test.flex 
java -jar java-cup-11b.jar src/cup/parser.cup
cp src/jflex/TestLexer.java src/main/java/
cp parser.java src/main/java/
cp sym.java src/main/java/
rm ./src/jflex/TestLexer.java
rm ./parser.java
rm ./sym.java
