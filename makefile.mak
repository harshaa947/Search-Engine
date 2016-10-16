
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        AvlTree.java \
        InvertedPageIndex.java \
		MyLinkedList.java \
		MyHashTable.java \
		MySet.java \
		MySort.java \
		PageEntry.java \
		PageIndex.java \
		Position.java \
		SearchEngine.java \
		SearchResult.java \
		WordEntry.java \
		heap.java \
		checker.java
        

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
