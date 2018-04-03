package assi1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringArrayListTest {

  @Test
  public void testAdd() {
    // Test basic creation.
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    list.add(s);
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), s);
    
    // Test growth / capacity.
    list = new StringArrayList();
    int size = 100000;
    for (int i = 0; i < size; i++) {
      list.add(Integer.toString(i));
    }
    assertEquals(size, list.size());
  }

  @Test
  public void testGet() {
    // test basic get
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    list.add(s);
    assertEquals(list.get(0), s);
    
    // test exception if index is out of bounds
    try {
      list.get(10);
      fail();
    } catch (Exception exc) {
      // OK - this should have thrown an exception.
    }
  }

  @Test
  public void testContains() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    list.add(s);
    assertTrue(list.contains(s));
    assertFalse(list.contains("Nonexistent"));
  }

  @Test
  public void testIndexOf() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    String t = "Test 2";
    list.add(s);
    list.add(t);
    assertEquals(list.indexOf(s), 0);
    assertEquals(list.indexOf(t), 1);
    
    // test negative case
    assertEquals(list.indexOf("Not here"), -1);
  }

  @Test
  public void testSize() {
    StringArrayList list = new StringArrayList();
    assertEquals(list.size(), 0);
    String s = "Test 1";
    list.add(s);
    assertEquals(list.size(), 1);
    
    list.clear();
    assertEquals(list.size(), 0);
  }

  @Test
  public void testInsert() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    list.add(s);
    String t = "Test 2";
    list.add(0, t);
    assertEquals(list.get(0), t);
    assertEquals(list.get(1), s);
    
    // test out of bounds
    try {
      list.add(100, s);
      fail();
    } catch (Exception exc) {
      // OK - this should have thrown an exception.
    }
    
    // Test proper growth for insert
    list = new StringArrayList();
    int size = 10000;
    list.add("0");
    for (int i = 1; i < size; i++) {
      list.add(0, Integer.toString(i));
    }
    assertEquals(list.get(size - 1), "0");
  }

  @Test
  public void testClear() {
    StringArrayList list = new StringArrayList();
    list.add("x");
    list.clear();
    assertTrue(list.isEmpty());
    assertEquals(list.size(), 0);
  }

  @Test
  public void testIsEmpty() {
    StringArrayList list = new StringArrayList();
    assertTrue(list.isEmpty());
    list.add("x");
    assertFalse(list.isEmpty());
    list.clear();
    assertTrue(list.isEmpty());
  }

  @Test
  public void testRemove() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    String t = "Test 2";
    list.add(s);
    list.add(t);
    list.remove(0);
    assertEquals(list.size(),1);
    assertEquals(list.get(0), t);
    list.remove(0);
    assertTrue(list.isEmpty());
    
    // test bounds
    try { 
      list.remove(0);
      fail();
    } catch (Exception exc) {
      // OK - this should have thrown an exception.
    }
  }

  @Test
  public void testSet() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    String t = "Test 2";
    String u = "New";
    list.add(s);
    list.add(t);
    list.set(0, u);
    assertEquals(list.get(0), u);
    assertEquals(list.get(1), t);

    // test bounds
    try { 
      list.set(10000, u);
      fail();
    } catch (Exception exc) {
      // OK - this should have thrown an exception.
    }
  }

  @Test
  public void testToArray() {
    StringArrayList list = new StringArrayList();
    String s = "Test 1";
    String t = "Test 2";
    list.add(s);
    list.add(t);
    String[] strings = list.toArray();
    assertEquals(strings[0], s);
    assertEquals(strings[1], t);
    
    assertEquals(strings.length, 2);
    
    // Test to ensure that changing strings[] does not change the list.
    strings[0] = "Something else";
    assertEquals(list.get(0), s);
  }
}
