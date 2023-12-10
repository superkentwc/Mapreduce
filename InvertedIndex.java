import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import mapreduce.MapReduce;

public class InvertedIndex {

    public Map<String, List<String>> run(List<String> filenames) {
        List<Document> inputs = new LinkedList<>();
        for (String filename : filenames) {
            inputs.add(new Document(filename, FileParser.parse(filename)));
        }
        // TODO: instantiate a MapReduce object with correct input, key, value, and output types

        // TODO: set the mapper and reducer suppliers, and set the inputs

        // TODO: execute the MapReduce object and return the result

        MapReduce<Document, String, String, List<String>> mapReduce = new MapReduce<>();
        mapReduce.setMapperSupplier(Mapper::new);
        mapReduce.setReducerSupplier(Reducer::new);
        mapReduce.setInput(inputs);
        return mapReduce.call();
        //throw new UnsupportedOperationException("InvertedIndex.run() not implemented yet.");
    }

    class Document {

        String name;
        List<String> words;

        public Document(String name, List<String> words) {
            this.name = name;
            this.words = words;
        }

    }

    class Mapper
            extends mapreduce.Mapper<Document, String, String> {

        @Override
        public Map<String, String> compute() {
            // TODO: implement the Map function for inverted index
            Map<String, String> map = new HashMap<>();
            for (String word : input.words) {
                map.put(word, input.name);
            }
            return map;
            //throw new UnsupportedOperationException("InvertedIndex map function not implemented yet.");
        }

    }

    class Reducer
            extends mapreduce.Reducer<String, String, List<String>> {

        @Override
        public List<String> compute() {
            // TODO: implement the Reduce function for inverted index
            Set<String> uniqueFileNames = new HashSet<>(valueList);
            return new ArrayList<>(uniqueFileNames);
            //throw new UnsupportedOperationException("InvertedIndex reduce function not implemented yet.");
        }
    }

}
