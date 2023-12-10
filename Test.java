import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class Test {
    
    public static void main(String[] args) {
        // test your WordCount and InvertedIndex program with your own sample input files here
        String filename = "sample.txt";
        int numSplits = 4;
        WordCount wordCount = new WordCount(numSplits);
        Map<String, Long> wordCounts = wordCount.run(filename);
        System.out.println("WordCount Results:");
        displayOutput(wordCounts);

        List<String> Filenames = Arrays.asList("sample1.txt", "sample2.txt", "sample3.txt");
        InvertedIndex invertedIndex = new InvertedIndex();
        Map<String, List<String>> invertedIndexes = invertedIndex.run(Filenames);
        System.out.println("\nInvertedIndex Results:");
        displayOutput2(invertedIndexes);
    }
    private static void displayOutput(Map<String, Long> wordCounts) {
        for (Map.Entry<String, Long> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static void displayOutput2(Map<String, List<String>> invertedIndexes) {
        for (Map.Entry<String, List<String>> entry : invertedIndexes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
