import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
//
//		LinkedQueue<Integer> s = new LinkedQueue<>();
//        s.enqueue(1);
//        s.enqueue(2);
//        s.enqueue(3);
//        
//        Iterator<Integer> l = new queueIterator<>(s);
//        l.next();
//        l.remove();
//        while(!s.isEmpty()){
//        	System.out.println("check work: " + s.dequeue());
//        }
//		
//		ArrayStack<Integer> stack = new ArrayStack<>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		
//		Iterator<Integer> i = new stackIterator<>(stack);
//		i.next();
//		i.remove();
//		while(!stack.isEmpty()){
//			System.out.println("Show me what u have: " + stack.pop());
//		}
		
//		LList<Integer> list = new LList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		Iterator<Integer> i = new listIterator<>(list);
//		i.next();
//		i.remove();
//		int num=1;
//		while(!list.isEmpty()){
//			System.out.println("Show me what u have: " + list.remove(num));
//		}
		
	Dictionary<Integer,String> test = new Dictionary<>();
	test.add(0, "I");
	test.add(1, "o");
	test.add(0, "L");
	test.add(0, "V");
	LinkedList<String> temp = test.getValue(0);
	System.out.println("Show me size : " + temp.size());

	System.out.println("show me : " + temp.get(0));
	System.out.println("show me : " + temp.get(1));
	System.out.println("show me : " + temp.get(2));
	
	test.remove(0);
	
	}

}
