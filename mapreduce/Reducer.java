package mapreduce;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author mph
 * @param <K>   key
 * @param <V>   valueListumulator
 * @param <OUT> output value
 */
public abstract class Reducer<K, V, OUT> extends RecursiveTask<OUT> {

  protected K key;
  protected List<V> valueList;

  /**
   * @param aKey  key for this reducer
   * @param aList list of values
   */
  public void setInput(K aKey, List<V> aList) {
    key = aKey;
    valueList = aList;
  }
};
