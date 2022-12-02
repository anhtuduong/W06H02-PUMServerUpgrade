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
		Stack temp = stacks;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		int result = temp.pop();
		if (temp.isEmpty()) {
			// in case temp is the NOT first stack, remove the stack
			if (temp.getCapacity() != 1) {	// the first stack has capacity of 1
				temp = null;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return stacks.toString();
	}

}
