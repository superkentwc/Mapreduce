import java.util.List;
import java.util.Map;
import java.util.HashMap;


import mapreduce.MapReduce;

/**
 *
 * @author mph
 */
public class WordCount {

  int numSplites;

  public WordCount(int numSplites) {
    this.numSplites = numSplites;
  }

  public Map<String, Long> run(String filename) {
    List<String> text = FileParser.parse(filename);
    List<List<String>> inputs = FileParser.split(text, numSplites);

    // TODO: instantiate a MapReduce object with correct input, key, value, and output types

    // TODO: set the mapper and reducer suppliers, and set the inputs

    // TODO: execute the MapReduce object and return the result
    MapReduce<List<String>, String, Long, Long> mapReduce = new MapReduce<>();
    mapReduce.setMapperSupplier(Mapper::new);
    mapReduce.setReducerSupplier(Reducer::new);
    mapReduce.setInput(inputs);
    return mapReduce.call();

    //throw new UnsupportedOperationException("WordCount.run() not implemented yet.");
  }

  class Mapper
      extends mapreduce.Mapper<List<String>, String, Long> {

    @Override
    public Map<String, Long> compute() {
      // TODO: implement the Map function for word count
      Map<String, Long> map = new HashMap<>();
      for (String word : input) {
        map.merge(word, 1L, (x, y) -> x + y);
      }
      return map;
      //throw new UnsupportedOperationException("WordCount map function not implemented yet.");
    }

  }

  class Reducer
      extends mapreduce.Reducer<String, Long, Long> {

    @Override
    public Long compute() {
      // TODO: implement the Reduce function for word count
      long count = 0;
      for (long c : valueList) {
        count += c;
      }
      return count;
      //throw new UnsupportedOperationException("WordCount reduce function not implemented yet.");
    }
  }

}
