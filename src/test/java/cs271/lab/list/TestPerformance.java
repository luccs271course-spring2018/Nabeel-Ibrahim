package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPerformance {

  // TODO run test and record running times for SIZE = 10(173ms)=0.173s, 100(215ms)=0.215s, 1000(840ms)=0.840,
  // 10000(9s 643ms)=9.643,done ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO refactor to DRY
  // which of the two lists performs better as the size increases?(done)
  //linkedlist
  private final int SIZE = 10;

  // TODO choose this value in such a way that you can observe an actual effect??????
  // for increasing problem sizes
  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
  }

  @Test
  public void testArrayListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
  }
}