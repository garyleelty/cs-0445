package assi1;

/**
 * This interface defines necessary methods for a String List implementation.
 */
public interface StringList {

  /**
   * Add a String to this list.
   * @return the index where this String was inserted.
   */
  public int add(String s);

  /**
   * Retrieve the String at position i.
   */
  public String get(int i);

  /**
   * Return true if this list contains String s.
   */
  public boolean contains(String s);

  /**
   * Return the index of String s in this list, or -1 if s is not in this list.
   */
  public int indexOf(String s);

  /**
   * Return the current size of this list.
   */
  public int size();

  /**
   * Insert a string into this list in the specified index.
   * Note that this should move the rest of the values in the list.
   * @return the index where this String was inserted.
   */
  public int add(int index, String s);

  /**
   * Remove all strings from this list.
   */
  public void clear();

  /**
   * Return true if this list is empty, false otherwise.
   */
  public boolean isEmpty();

  /**
   * Remove a String at the specified position.
   * Note that all other values should move to fill the gap.
   */
  public String remove(int i);

  /**
   * Set the value of the String in position index.
   */
  public void set(int index, String s);

  /**
   * Return an array representation of this list.
   */
  public String[] toArray();
}
