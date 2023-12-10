JAVAFILES = Test.java WordCount.java InvertedIndex.java FileParser.java mapreduce/MapReduce.java mapreduce/Mapper.java mapreduce/Reducer.java
JFLAGS = java -ea
OUTDIR = out

run: $(JAVAFILES)
	javac -d $(OUTDIR) $(JAVAFILES)
	$(JFLAGS) -cp $(OUTDIR) Test

clean:
	rm -rf $(OUTDIR)