import java.util.Iterator;
import java.util.LinkedList;

public class Dictionary<K,V> implements DictionaryInterface<K,V> {

	private LinkedList<K> keyList;
	private LinkedList<V> valueList;
	private LinkedList<Entry<K,V>> dictionary;
	
	private int findIndexOfKey(K key){
		boolean found = false;
		int index = 0;
		Iterator<Entry<K,V>> walker = dictionary.listIterator();
		
		while((!found)&&(walker.hasNext())){
			Entry<K,V> temp = walker.next();
			if(temp.getKey().equals(key)){
				found = true;
			}
			else{
		    	index++;
			}
		}
		return found? index:-1;
	}
	
	private class Entry<S,T>{
		private S key;
		private LinkedList<T> value;
		
		private Entry(S searchKey,T dataValue){
			key = searchKey;
			value = new LinkedList<>();
			value.push(dataValue);
		}
		
		public S getKey(){
			return key;
		}
		
		public LinkedList<T> getValue(){
			return value;
		}
		
		public boolean addValue(T addThis){
			if(value.contains(addThis)){
				throw new IllegalArgumentException("Invalid input!!!");
			}
			else{
				value.add(addThis);
				return true;
			}
		}
	}
	
	public Dictionary(){
		keyList = new LinkedList<>();
		valueList = new LinkedList<>();
		dictionary = new LinkedList<Entry<K,V>>();
	}
	
	@Override
	public boolean add(K key, V value) {
		if(key==null || value==null){
			throw new IllegalArgumentException("Invalid input!!!");
		}
		else{
			if(keyList.contains(key)){
				int getIndex = findIndexOfKey(key);
				dictionary.get(getIndex).addValue(value);
				valueList.add(value);
			}
			else{
				Entry<K,V> newStaff = new Entry<>(key,value);
				dictionary.add(newStaff);
				valueList.add(value);
				keyList.add(key);
			}
			return true;
		}
	}

	@Override
	public LinkedList<V> remove(K key) {
		if(keyList.contains(key)){
			LinkedList<V> result = new LinkedList<>();
			int getIndex = findIndexOfKey(key);
			result = dictionary.remove(getIndex).getValue();
			for(int i =0;i<result.size();i++){
				valueList.remove(result.get(i));
			}
			return result;
		}
		else
			throw new IllegalArgumentException("Does not have this key!!");
	}

	@Override
	public LinkedList<V> getValue(K key) {
		if(keyList.contains(key)){
			int getIndex = findIndexOfKey(key);
			return dictionary.get(getIndex).getValue();
		}
		else
			throw new IllegalStateException("Does not have this key!");
		
	}

	@Override
	public boolean contains(K key) {
		Iterator<K> keyWalker = getKeyIterator();
		boolean found = false;
		while(keyWalker.hasNext()&&(!found)){
			K checkKey = keyWalker.next();
			if(checkKey.equals(key)){
				found = true;
			}
		}
		return found;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return keyList.iterator();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return valueList.iterator();
	}

	@Override
	public boolean isEmpty() {
		return dictionary.isEmpty();
	}

	@Override
	public int getSize() {
		return dictionary.size();
	}

	@Override
	public void clear() {
		dictionary.clear();
	}

}
