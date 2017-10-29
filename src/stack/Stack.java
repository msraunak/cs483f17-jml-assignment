package stack;
/**
 * Array-based implementation of the stack.
 */
public class Stack
{
    private Object [ ] theArray;
    private int topOfStack;

    /**
     * Construct the stack.
     */
    public Stack( int capacity )
    {
        theArray = new Object[ capacity ];
        topOfStack = -1;
    }

    /**
     * Test if the stack is logically empty.
     */
    /*@ pure */
    public boolean isEmpty( )
    {
        return topOfStack == -1;
    }

    /**
     * Test if the stack is logically full.
     */
    /*@ pure */
    public boolean isFull( )
    {
        return topOfStack == theArray.length;
    }

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     */
    /*@ pure */
    public Object top( )
    {
        if( isEmpty( ) )
            return null;
        return theArray[ topOfStack ];
    }

    /**
     * Remove the most recently inserted item from the stack.
     */
    public void pop( )
    {
        theArray[ topOfStack-- ] = null;
    }

    /**
     * Insert a new item into the stack, if not already full.
     */
    public void push( Object x )
    {
        theArray[ topOfStack++ ] = x;
    }
}
