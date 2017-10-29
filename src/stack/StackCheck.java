package stack;

/**
 * StackCheck is a class which calls Stack and verifies that the
 * written specification is sufficient.
 */
public class StackCheck
{
  /**
   * Helper method to generate elements to place in the queue.
   * Stack elements are never null.
   */
  private static Object element()
  //@ ensures \result != null;
  {
    return new Object();
  }

  /**
   * Check that legal call sequences to the constructor and push throw
   * no runtime exceptions.
   **/
  public static void checkConstructor() {
    Stack stack;
    stack = new Stack(1);
    stack.push(element());
    stack = new Stack(2);
    stack.push(element());
    stack.push(element());
  }

  /**
   * Check that the isEmpty specification is correctly related to the
   * push specification.
   */
  public static void checkIsEmpty() {
    Stack s = new Stack(2);
    
    if (! s.isEmpty())
      throw new RuntimeException("New stack should be empty");
    
    s.push(element());
    if (s.isEmpty())
      throw new RuntimeException("1-elt stack should not be empty");
    
    s.push(element());
    if (s.isEmpty())
      throw new RuntimeException("2-elt stack should not be empty");
  }

  /**
   * Check that the isFull specification is correctly related to the
   * push specification.
   */
  public static void checkIsFull() {
    Stack s = new Stack(2);
    
    if (s.isFull())
      throw new RuntimeException("New stack should not be full");
    
    s.push(element());
    if (s.isFull())
      throw new RuntimeException("1-elt stack should not be full");
    
    s.push(element());
    if (! s.isFull())
      throw new RuntimeException("2-elt stack should be full");
  }

  /**
   * Check that top returns null iff the queue is empty.
   */
  public static void checkTop() {
    Stack stack = new Stack(2);
    
    if (stack.top() != null)
      throw new RuntimeException("Top of new stack should be null");
    
    stack.push(element());
    //@ assert stack.top() != null;
    if (stack.top() == null)
      throw new RuntimeException("Top of 1-elt stack should be non-null");
  }

  /**
   * Check that legal call sequences to the constructor, push, and pop
   * throw no runtime exceptions.
   */
  public static void checkPop() {
    Stack stack = new Stack(2);
    
    stack.push(element());
    stack.pop();
    
    stack.push(element());
    stack.push(element());
    stack.pop();
    stack.pop();
  }

}
