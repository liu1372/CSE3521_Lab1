package astar;

public class Node {
    
    private int[] state;
    private int[][] twoState;
    private Node parentNode;
    private String action;
    private int pathCost;
    private int depth;
    private int cost2go;

    
    public Node()
    {
      this.twoState = new int [3][3];
      this.parentNode = null;
      this.action = "";
      this.pathCost = 0;
      this.depth = 0;
      this.cost2go = 0 ;
    }
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
    
    public Node(int[][] s) {
        twoState = s;

        }
        //init for nodes expect root node
        public Node(int[][] s, Node parent, String a, int p, int d) {
            twoState = s;
            parentNode = parent;
            action = a;
            pathCost = p;
            depth = d;
        }
        //init for nodes in A*
        public Node(int[][] s, Node parent, String a, int p, int d, int c) {
            twoState = s;
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
    
    public int[][] getTwoState(){
        return this.twoState;
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
    //return the state of one dimensional array
    public int state(int n){
        return this.state[n];
    }
    //return the state of two dimensional array
    public int state(int x, int y)
    {
    	return this.twoState[x][y];
    }
    //return the cost2go
    public int getCost2go()
    {
    	return this.cost2go;
    }

    public boolean equals(Node other)
    {
    	for(int x =0; x<3; x++)
    	{
    		for(int y=0; y<3; y++)
    		{
    			if(!(this.twoState[x][y] == other.getTwoState()[x][y]))
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}