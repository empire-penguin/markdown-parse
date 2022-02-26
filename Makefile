test: MarkdownParse.class MarkdownParseTest.class
	java -cp lib/*:. org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp lib/*:. MarkdownParseTest.java MarkdownParse.java

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

debug-test: MarkdownParseTest.class
	jdb -classpath lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/commonmark-0.18.1.jar:. org.junit.runner.JUnitCore MarkdownParseTest