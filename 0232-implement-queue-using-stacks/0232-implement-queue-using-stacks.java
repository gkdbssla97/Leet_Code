class MyQueue {
    private Stack<Integer> stack1, stack2;

    public MyQueue() {
        this.stack1 = new Stack<>(); // 입력 스택
        this.stack2 = new Stack<>(); // 출력 스택
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        peek();
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */