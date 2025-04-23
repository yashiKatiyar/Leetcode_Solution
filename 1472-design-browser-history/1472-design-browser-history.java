import java.util.Stack;
// INITIAL IDEA: USE 2 STCKS
// curr is more like a pointer
class BrowserHistory {
    private Stack<String> backstack;
    private Stack<String> forwardstack;
    private String curr;
//
    public BrowserHistory(String homepage) {
        backstack = new Stack<>();
        forwardstack = new Stack<>();
        curr = homepage;
    }
// simply adds to backstack; ensures forward is clear
    public void visit(String url) {
        backstack.push(curr);
        forwardstack.clear();
        curr = url;
    }
/* Now here, 
    every time we go back to prev site we pop elements ahead of it and add to forward stack. 
    */

    public String back(int steps) {
        while (steps > 0 && !backstack.isEmpty()) {
            forwardstack.push(curr);
            curr = backstack.pop();
            steps--;
        }
        return curr;
    }
// Similar to back stack we just reverse the operations to each stack. now we are adding to back and removing element from backstack.
    public String forward(int steps) {
        while (steps > 0 && !forwardstack.isEmpty()) {
            backstack.push(curr);  
            curr = forwardstack.pop();
            steps--;
        }
        return curr;
    }
}
