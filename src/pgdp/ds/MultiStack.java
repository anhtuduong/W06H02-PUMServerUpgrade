package pgdp.ds;

public class MultiStack {

	private final Stack stacks;

	public MultiStack() {
		stacks = new Stack(1);
	}

	public void push(int data) {
		Stack temp = stacks;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		if (temp.isFull()) {
			// create new Stack with double capacity of the previous one
			temp.setNext(new Stack(temp.getCapacity() * 2));
			temp = temp.getNext();
		}
		temp.push(data);
	}

	public int top() {
		Stack temp = stacks;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.top();
	}

	public int pop() {
		if (stacks.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		Stack current = stacks;
		Stack previous = null;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		int result = current.pop();
		if (current.isEmpty()) {
			// in case temp is the NOT first stack, remove the stack
			if (current.getCapacity() != 1) {	// the first stack has capacity of 1
				previous.setNext(null);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return stacks.toString();
	}

}
