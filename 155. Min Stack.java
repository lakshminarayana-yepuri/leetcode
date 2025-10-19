class MinStack {
    Deque<Integer> q = new ArrayDeque<>();
    PriorityQueue<Integer> pq= new PriorityQueue<>();
    public MinStack() {
    }
    
    public void push(int val) {
        q.push(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(q.pop());
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */