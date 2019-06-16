java -jar jflex-full-1.7.0.jar src/jflex/test.flex 
java -jar java-cup-11b.jar src/cup/parser.cup
cp src/jflex/TestLexer.java src/main/java/
cp parser.java src/main/java/
cp sym.java src/main/java/
rm ./src/jflex/TestLexer.java
rm ./parser.java
rm ./sym.java

# Ponieawż java-cup-11b.jar najwyraźniej nie występuje w repozytoriach Mavena,
# należy przejść do katalogu, gdzie się ten plik znajduje i odpalić:
#
# mvn install:install-file -Dfile=java-cup-11b.jar -DgroupId=de.jflex -DartifactId=cup -Dversion=11b -Dpackaging=jar

