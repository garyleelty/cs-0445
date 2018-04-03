import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {


  @Test
  public void testPushPop() {
    Stack<Double> as = new ArrayStack<Double>();
    Stack<Double> ls = new LinkedStack<Double>();

    Double[] values = {0.0, 0.1, 0.02, 0.003, 0.0004, 0.00005, 0.0000006};
    for (int i = 0; i < values.length; i++) {
      as.push(values[i]);
      ls.push(values[i]);
    }
        
    int i = values.length - 1;
    while (i >= 0) {
      assertEquals(values[i], as.pop());
      assertEquals(values[i], ls.pop());
      i--;
    }
    assertTrue(as.isEmpty());
    assertTrue(ls.isEmpty());
    
    try {
      as.pop();
      fail(); // we fail if we pop an empty stack.
    } catch (UnsupportedOperationException iExc) {
      // OK, this should have caused an exception.
    }
    
    try {
      ls.pop();
      fail(); // we fail if we successfully pop an empty stack.
    } catch (UnsupportedOperationException iExc) {
      // OK, this should have caused an exception.
    }
  }
  
  @Test
  public void testPeek() {
    Stack<Double> as = new ArrayStack<Double>();
    Stack<Double> ls = new LinkedStack<Double>();

    Double last = 0.0;
    for (int i = 0; i < 101; i++) {
      last = Math.random();
      as.push(last);
      ls.push(last);
    }
    assertEquals(last, as.peek());
    assertEquals(last, ls.peek());
    
    // test a second time to ensure no mutation
    assertEquals(last, as.peek());
    assertEquals(last, ls.peek());
  }
  
  @Test
  public void testPerformance() {
    Stack<Double> as = new ArrayStack<Double>();
    Stack<Double> ls = new LinkedStack<Double>();
    measurePushTime(as, ls, 23);
    measurePopTime(as, ls);
    measurePushTime(as, ls, 1000);
    measurePopTime(as, ls);
    measurePushTime(as, ls, 1000000);
    measurePopTime(as, ls);
    measurePushAndPopTime(as, ls);
  }
  
  public void measurePushAndPopTime(Stack<Double> as, Stack<Double> ls) {
    long arrayTime = 0;
    long linkedTime = 0;
    long now = 0;
    for (int i = 0; i < 10000; i++) {
      for (int k = 0; k < 40; k++) {
        now = System.nanoTime();
        as.push(Math.random());
        arrayTime += (System.nanoTime() - now);
        
        now = System.nanoTime();
        ls.push(Math.random());
        linkedTime += (System.nanoTime() - now);
      }
      for (int k = 0; k < 38; k++) {
        now = System.nanoTime();
        as.pop();
        arrayTime += (System.nanoTime() - now);
        
        now = System.nanoTime();
        ls.pop();
        linkedTime += (System.nanoTime() - now);
      }
    }
    while (!as.isEmpty()) {
      now = System.nanoTime();
      as.pop();
      arrayTime += (System.nanoTime() - now);
    }
    while (!ls.isEmpty()) {
      now = System.nanoTime();
      ls.pop();
      linkedTime += (System.nanoTime() - now);
    }
    System.out.println("\nFor 40000 sporadic pushes and pops, array approach took " + arrayTime + "ns and linked approach took " + linkedTime + "ns.");
  }
  
  public void measurePopTime(Stack<Double> as, Stack<Double> ls) {
    long arrayPopTime = 0;
    long linkedPopTime = 0;
    long now = 0;
    while (!as.isEmpty()) {
      now = System.nanoTime();
      as.pop();
      arrayPopTime += (System.nanoTime() - now);
    }
    while (!ls.isEmpty()) {
      now = System.nanoTime();
      ls.pop();
      linkedPopTime += (System.nanoTime() - now);
    }
    System.out.println("\nFor pops, array approach took " + arrayPopTime + "ns and linked approach took " + linkedPopTime + "ns.");
  }

  public void measurePushTime(Stack<Double> as, Stack<Double> ls, int size) {
    long arrayPushTime = 0;
    long linkedPushTime = 0;

    Double last = 0.0;
    long now = 0;
    for (int i = 0; i < size; i++) {
      last = Math.random();
      
      now = System.nanoTime();
      as.push(last);
      arrayPushTime += (System.nanoTime() - now);
      
      now = System.nanoTime();
      ls.push(last);
      linkedPushTime += (System.nanoTime() - now);
    }
    System.out.println("\nFor " + size + " pushes, array approach took " + arrayPushTime + "ns and linked approach took " + linkedPushTime + "ns.");
  }
}