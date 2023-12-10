package mapreduce;

import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author mph
 * @param <IN> input type
 * @param <K>  key type
 * @param <V>  accumulator type
 */
public abstract class Mapper<IN, K, V> extends RecursiveTask<Map<K, V>> {
  protected IN input;

  /**
   * @param anInput list of input items
   */
  public void setInput(IN anInput) {
    input = anInput;
  }
}
