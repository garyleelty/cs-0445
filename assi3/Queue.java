public interface Queue<T> {
  public T remove();
  public T peek();
  public void add(T thing);
  public boolean isEmpty();
}
