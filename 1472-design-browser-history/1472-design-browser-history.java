class BrowserHistory {
    private String[] history;
    private int curr;
    private int last;

    public BrowserHistory(String homepage) {
        history = new String[5001]; // Max 5000 calls as per constraints(given)
        history[0] = homepage;
        curr = 0;
        last = 0;
    }
// elements are added to the array. Therefore, curr and last are updated.
    public void visit(String url) {
        curr++;
        history[curr] = url;
        last = curr; // both are updated
    }

    //traversing back in the history 

    public String back(int steps) {
        //0 because you cannot travel beyond last entry of array ; will throw array out of bound
        curr = Math.max(0, curr - steps);
        return history[curr];
    }
// traversing firward the array
    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return history[curr];
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */