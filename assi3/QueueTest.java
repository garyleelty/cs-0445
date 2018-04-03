import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

  private static final String FIRST = "F";
  private static final String SECOND = "S";
  private static final Integer ONE = new Integer(1);
  private static final Integer TWO = new Integer(2);
  private static final Integer THREE = new Integer(3);
  private static final Integer FOUR = new Integer(4);
  private static final Integer FIVE = new Integer(5);

  public void populateAndTestQueue(Queue<String> q) {
    q.add(FIRST);
    q.add(SECOND);
    q.add("A");
    q.add("A");
    q.add("A");
    assertEquals(q.peek(), FIRST);
    assertEquals(q.remove(), FIRST);
    assertEquals(q.peek(), SECOND);
    assertEquals(q.remove(), SECOND);
    emptyQueue(q);
    try {
      q.remove();
      fail();
    } catch (UnsupportedOperationException uoExc) {
      // OK
    }
  }
  
  public void emptyQueue(Queue q) {
    while (!q.isEmpty()) {
      q.remove();
    }
  }
  
  public void addAndRemove(Queue<Integer> q) {
    q.add(ONE);
    q.add(TWO);
    q.add(THREE);
    q.add(FOUR);
    q.remove();
    q.add(FIVE);
    q.remove();
    assertEquals(THREE, q.remove());
    assertEquals(FOUR, q.remove());
    assertEquals(FIVE, q.remove());
    assertTrue(q.isEmpty());
    q.add(TWO);
    q.add(FOUR);
    assertEquals(TWO, q.peek());
    assertEquals(TWO, q.remove());
    assertEquals(FOUR, q.remove());
    assertTrue(q.isEmpty());
  }
  
  public void bigAddAndRemove(Queue<Byte> q) {
    for (int i = 1; i <= 10000000; i++) {
      if (i % 3 == 0) {
        q.remove();
      } else {
        byte b = (byte)(i % 128);
        q.add(b);
      }
    }
    assertEquals(new Byte((byte)64), q.remove());
    assertEquals(new Byte((byte)66), q.remove());
    assertEquals(new Byte((byte)67), q.remove());
    assertEquals(new Byte((byte)69), q.remove());
  }
 
  @Test
  public void testAddAndClear() {
    populateAndTestQueue(new LinkedQueue<String>());
    populateAndTestQueue(new ArrayQueue<String>());
  }
  
  @Test
  public void testAddAndRemove() {
    addAndRemove(new LinkedQueue<Integer>());
    addAndRemove(new ArrayQueue<Integer>());
  }
  
  @Test
  public void testBigAddAndRemove() {
    bigAddAndRemove(new LinkedQueue<Byte>());
    bigAddAndRemove(new ArrayQueue<Byte>());
  }
}
    
