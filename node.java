public class Node {
    
    private int[] state;
    private Node parentNode;
    private String action;
    private int pathCost;
    private int depth;
    private int cost2go;

    //init for the root node
    public Node(int[] s) {
    state = s;

    }
    //init for nodes expect root node
    public Node(int[] s, Node parent, String a, int p, int d) {
        state = s;
        parentNode = parent;
        action = a;
        pathCost = p;
        depth = d;
    }
    //init for nodes in A*
    public Node(int[] s, Node parent, String a, int p, int d, int c) {
        state = s;
        parentNode = parent;
        action = a;
        pathCost = p;
        depth = d;
        cost2go = c;
    }

    // return the state of the node
    public int[] getState(){
        return this.state;
    }
    //return the parent of this node
    public Node getParent(){
        return this.parentNode;
    }
    //return the actions of the node
    public String getAction(){
        return this.action;
    }
    //return the path cost
    public int getPathCost(){
        return this.pathCost;
    }
    //return the depth
    public int getDepth(){
        return this.depth;
        
    }
    public int state(int n){
        return this.state[n];
    }


}