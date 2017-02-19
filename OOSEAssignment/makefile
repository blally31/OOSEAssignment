JFLAGS = -g
JC = javac
JVM= java
ARGS= properties1.txt events1.txt plan1.txt 2017 2019
FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	Main.java \
	Controller.java \
	Property.java \
	Company.java \
	BusinessUnit.java \
	BankAccount.java \
	Event.java \
	WagesEvent.java \
	ValueEvent.java \
	RevenueEvent.java \
	Plan.java \
	BuyPlan.java \
	SellPlan.java \
	ReadProperty.java \
	ReadEvent.java \
	ReadPlan.java \
	FileFormatException.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN) $(ARGS)

clean:
	$(RM) *.class     