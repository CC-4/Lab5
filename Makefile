JFLAGS=
SUBDIR=$(PWD)/tree
CLASSPATH=$(PWD)/lib/jlex.jar

parser: Lexer.java ParseTable.java Parser.java
	javac Parser.java
	$(RM) parser
	echo '#!/bin/sh' >> parser
	echo 'java Parser $$*' >> parser
	chmod a+x parser

ParseTable.java: table.xlsx
	$(RM) table.csv
	libreoffice --headless --convert-to csv --outdir . table.xlsx
	python convertToJava.py

lexer: Lexer.java
	javac Lexer.java
	$(RM) lexer
	echo '#!/bin/sh' >> lexer
	echo 'java Lexer $$*' >> lexer
	chmod a+x lexer

Lexer.java: lexer.lex
	java -classpath $(CLASSPATH) JLex.Main lexer.lex
	mv lexer.lex.java Lexer.java

.PHONY: clean, checkTable

checkTable: ParseTable.java
	java -jar autograder/E1.jar ParseTable.java

clean:
	$(RM) parser
	$(RM) lexer
	$(RM) Lexer.java
	$(RM) ParseTable.java
	$(RM) table.csv
	$(RM) *.class
	$(RM) */*.class
