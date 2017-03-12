import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class stackIterator<T> implements Iterator<T> {

	private StackInterface<T> stack;
	private ArrayList<T>  temp;
	private int nextPosition;
	private boolean wasNextCalled;
	
	public stackIterator(StackInterface<T> myStack){
		nextPosition = 0;
		wasNextCalled = false;
		temp = new ArrayList<>();
		while(!myStack.isEmpty()){
			temp.add(myStack.pop());
		}
		stack = myStack;
		for(int i=temp.size();i<0;i--){
		    stack.push(temp.get(i-1));
		}
		myStack = stack;
	}
	
	@Override
	public boolean hasNext() {
		return nextPosition < temp.size();
	}

	@Override
	public T next() {
		if(hasNext())
		{
			wasNextCalled = true;
			T result = temp.get(nextPosition);
			nextPosition++;
			return result;
		}
		else
			throw new NoSuchElementException("Illegal call to next();" +
		                                      "iterator is after end of list");
	}
	
	@Override
	public void remove(){
		if(wasNextCalled){
			temp.remove(nextPosition);
			nextPosition--;
			wasNextCalled = false;
			
			stack.clear();
			for(int i=temp.size();i>0;i--){
				stack.push(temp.get(i-1));
			}
		}
		else
		    throw new IllegalStateException("Illegal call to remove();" +
                                   "next() was not called.");
	}

}
