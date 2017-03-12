import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class queueIterator<T> implements Iterator<T> {

	private QueueInterface<T> queue;
	private ArrayList<T>  temp;
	private int nextPosition;
	private boolean wasNextCalled;
	
	public queueIterator(QueueInterface<T> myQueue){
		nextPosition = 0;
		wasNextCalled = false;
		temp = new ArrayList<>();
		while(!myQueue.isEmpty()){
			temp.add(myQueue.dequeue());
		}
		queue = myQueue;
		for(int i=0;i<temp.size();i++){
		    queue.enqueue(temp.get(i));
		}
		myQueue = queue;
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
			nextPosition++;;
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
			
			queue.clear();
			for(int i=0;i<temp.size();i++){
				queue.enqueue(temp.get(i));
			}
		}
		else
		  throw new IllegalStateException("Illegal call to remove();" +
                                   "next() was not called.");
	}

}
