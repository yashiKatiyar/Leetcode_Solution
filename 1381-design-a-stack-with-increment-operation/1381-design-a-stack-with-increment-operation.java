// create a an array named stack, set top to -1
class CustomStack {
    int [] stack;
    int top = -1;

    //set size of stack to maxsize  via constructor
    public CustomStack(int maxSize) {
        this.stack = new int [maxSize];
        
    }
    
    public void push(int x) {
        if (top< this.stack.length-1){
            top++;
            this.stack[top]=x;
        }
        
    }
    
    public int pop() {
        if (top!=-1){
            return this.stack[top--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i=0;i< Math.min(k,top+1);i++){
            this.stack[i]+= val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */