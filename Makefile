# This is a very simple makefile for building the LISP interpreter
# # project when using Java on stdlinux. Feel free to add any improvements:
# # e.g. pattern rules, automatic tracking of dependencies, etc. There
# # is a lot of info about "make" on the web.
#
# # Java compiler
JAVAC = javac
#
# # Java compiler flags
JAVAFLAGS = -g 
#
# # Creating a .class file
COMPILE = $(JAVAC) $(JAVAFLAGS)
#
# # One of these should be the "main" class listed in Runfile
CLASS_FILES = Cook.class Dinner.class Machine.class Restaurant.class Table.class TableImpl.class Order.class OrderImpl.class
#
# # The first target is the one that is executed when you invoke
# # "make". 
#
all: $(CLASS_FILES) 
#
# # The line describing the action starts with <TAB>
%.class : %.java
	$(COMPILE) $<
#
#
#
#
.PHONY: clean
clean:
	rm *.class
