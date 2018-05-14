JFLAGS = -g
JC = javac

exam: Answer.class Question.class Exam.class ExamTester.class

Answer.class: Answer.java
	$(JC) $(JFLAGS) Answer.java

Question.class: Question.java 
	$(JC) $(JFLAGS) Question.java 

Exam.class: Exam.java
	$(JC) $(JFLAGS) Exam.java

ExamTester.class: Answer.class Question.class Exam.class 
	$(JC) $(JFLAGS) ExamTester.java

clean:
	$(RM) *.class