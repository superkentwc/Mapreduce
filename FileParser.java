import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileParser {

    static List<String> readLines(String fileName) {
        List<String> lines = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.exit(0x1);
        }
        return lines;
    }

    static List<String> parse(String fileName) {
        List<String> lines = readLines(fileName);
        List<String> words = new LinkedList<>();
        lines.stream().forEach((line) -> {
            words.addAll(
                    Arrays.asList(
                            line.toLowerCase()
                                    .split("\\W|\\d|_")));
        });
        return words;
    }

    static List<List<String>> split(List<String> text, int parts) {
        List<List<String>> inputs = new ArrayList<>(parts);
        int size = text.size();
        int div = size / parts;
        int rem = size % parts;
        int cur = 0;
        for (int i = 0; i < parts; i++) {
            int step = (rem-- > 0) ? div + 1 : div;
            inputs.add(text.subList(cur, cur + step));
            cur += step;
        }
        return inputs;
    }
}
