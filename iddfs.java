public class IDDFS {
    //private PriorityQueue<Node> frontier = new PriorityQueue<Node>();
    // private PriorityQueue<Node> explored = new PriorityQueue<Node>();
   
    private int depthLimite= 20;

    
    //check if the current node is the goal state
    public static boolean isGoalState(Node currentNode, int[] goalState){
        
        int[] temp = currentNode.getState();
        if(temp.equals(goalState)){
            return true;
        }else{
            return false;
        }
    }
    
    public static Node iddfsearch(Node n, int depth, int[] goalState){
        Node n1;
        Node n2;
        Node n3;
        Node n4;
        int[] s = new int[9];
        
        if (isGoalState(n,goalState)){
            return n;
        }else if(depth >=0){
            //if the empty is on the left top
            if (n.state(0) == 0){
                s[0] = n.state(3);
                s[1] = n.state(1);
                s[2] = n.state(2);
                s[3] = n.state(0);
                s[4] = n.state(4);
                s[5] = n.state(5);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(3),n.state(1),n.state(2), 0 ,n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "down", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(1);
                    s[1] = n.state(0);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(6);
                    s[7] = n.state(7);
                    s[8] = n.state(8);
                    //s = {n.state(1), 0 ,n.state(2),n.state(3),n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                    n2 = new Node(s, n, "right", 1, depth);
                    return iddfsearch(n2, depth-1,goalState);
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the top
            }else if(n.state(1) == 0){
                s[0] = n.state(0);
                s[1] = n.state(4);
                s[2] = n.state(2);
                s[3] = n.state(3);
                s[4] = n.state(1);
                s[5] = n.state(5);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(0),n.state(4),n.state(2),n.state(3),0,n.state(5),n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "down", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(1);
                    s[1] = n.state(0);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(6);
                    s[7] = n.state(7);
                    s[8] = n.state(8);
                    //s = {0, n.state(1),n.state(2),n.state(3),n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                    n2 = new Node(s, n, "left", 1, depth);
                    if(iddfsearch(n2, depth-1,goalState) == null){
                        s[0] = n.state(0);
                        s[1] = n.state(2);
                        s[2] = n.state(1);
                        s[3] = n.state(3);
                        s[4] = n.state(4);
                        s[5] = n.state(5);
                        s[6] = n.state(6);
                        s[7] = n.state(7);
                        s[8] = n.state(8);
                        //s = {n.state(0),n.state(2), 0 , n.state(3),n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                        n3 = new Node(s, n, "right", 1, depth);
                        return iddfsearch(n3, depth-1,goalState);
                    }else{
                        return iddfsearch(n2, depth-1,goalState);
                    }
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the right top
            }else if(n.state(2) == 0){
                s[0] = n.state(0);
                s[1] = n.state(1);
                s[2] = n.state(5);
                s[3] = n.state(3);
                s[4] = n.state(4);
                s[5] = n.state(2);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(0),n.state(1), n.state(5),n.state(3),n.state(4),0, n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "down", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(2);
                    s[2] = n.state(1);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(6);
                    s[7] = n.state(7);
                    s[8] = n.state(8);
                    //s = {n.state(0),0,n.state(1),n.state(3),n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                    n2 = new Node(s, n, "left", 1, depth);
                    return iddfsearch(n2, depth-1,goalState);
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if th empty is on the left
            }else if(n.state(3) == 0){
                s[0] = n.state(3);
                s[1] = n.state(1);
                s[2] = n.state(2);
                s[3] = n.state(0);
                s[4] = n.state(4);
                s[5] = n.state(5);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {0, n.state(1),n.state(2),n.state(0),n.state(4),n.state(5),n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(6);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(3);
                    s[7] = n.state(7);
                    s[8] = n.state(8);
                    //s = {n.state(0),n.state(1),n.state(2),n.state(6),n.state(4),n.state(5),0,n.state(7),n.state(8)};
                    n2 = new Node(s, n, "down", 1, depth);
                    if(iddfsearch(n2, depth-1,goalState) == null){
                        s[0] = n.state(0);
                        s[1] = n.state(1);
                        s[2] = n.state(2);
                        s[3] = n.state(4);
                        s[4] = n.state(3);
                        s[5] = n.state(5);
                        s[6] = n.state(6);
                        s[7] = n.state(7);
                        s[8] = n.state(8);
                        //s = {n.state(0),n.state(1), n.state(2),n.state(4),0, n.state(5),n.state(6),n.state(7),n.state(8)};
                        n3 = new Node(s, n, "right", 1, depth);
                        return iddfsearch(n3, depth-1,goalState);
                    }else{
                        return iddfsearch(n2, depth-1,goalState);
                    }
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the center
            }else if(n.state(4) == 0){
                s[0] = n.state(0);
                s[1] = n.state(4);
                s[2] = n.state(2);
                s[3] = n.state(3);
                s[4] = n.state(1);
                s[5] = n.state(5);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(0),0, n.state(2),n.state(3),n.state(1),n.state(5),n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(7);
                    s[5] = n.state(5);
                    s[6] = n.state(6);
                    s[7] = n.state(4);
                    s[8] = n.state(8);
                    //s = {n.state(0),n.state(1),n.state(2),n.state(3),n.state(7),n.state(5),n.state(6),0, n.state(8)};
                    n2 = new Node(s, n, "down", 1, depth);
                    if(iddfsearch(n2, depth-1,goalState) == null){
                        s[0] = n.state(0);
                        s[1] = n.state(1);
                        s[2] = n.state(2);
                        s[3] = n.state(4);
                        s[4] = n.state(3);
                        s[5] = n.state(5);
                        s[6] = n.state(6);
                        s[7] = n.state(7);
                        s[8] = n.state(8);
                        //s = {n.state(0),n.state(1), n.state(2),0, n.state(3), n.state(5),n.state(6),n.state(7),n.state(8)};
                        n3 = new Node(s, n, "left", 1, depth);
                        if(iddfsearch(n3, depth-1,goalState) == null){
                            s[0] = n.state(0);
                            s[1] = n.state(1);
                            s[2] = n.state(2);
                            s[3] = n.state(3);
                            s[4] = n.state(5);
                            s[5] = n.state(4);
                            s[6] = n.state(6);
                            s[7] = n.state(7);
                            s[8] = n.state(8);
                            //s = {n.state(0),n.state(1), n.state(2),n.state(3),n.state(5),0,n.state(6),n.state(7),n.state(8)};
                            n4 = new Node(s, n, "right", 1, depth);
                            return iddfsearch(n4, depth-1,goalState);
                        }else{
                            return iddfsearch(n3, depth-1,goalState);
                        }
                    }else{
                        return iddfsearch(n2, depth-1,goalState);
                    }
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the right
            }else if(n.state(5) == 0){
                s[0] = n.state(0);
                s[1] = n.state(1);
                s[2] = n.state(5);
                s[3] = n.state(3);
                s[4] = n.state(4);
                s[5] = n.state(2);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(0),n.state(1),0,n.state(3),n.state(4),n.state(2),n.state(6),n.state(7),n.state(8)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(8);
                    s[6] = n.state(6);
                    s[7] = n.state(7);
                    s[8] = n.state(5);
                    //s = {n.state(0),n.state(1),n.state(2),n.state(3),n.state(4),n.state(8),n.state(6),n.state(7),0};
                    n2 = new Node(s, n, "down", 1, depth);
                    if(iddfsearch(n2, depth-1,goalState) == null){
                        s[0] = n.state(0);
                        s[1] = n.state(1);
                        s[2] = n.state(2);
                        s[3] = n.state(3);
                        s[4] = n.state(5);
                        s[5] = n.state(4);
                        s[6] = n.state(6);
                        s[7] = n.state(7);
                        s[8] = n.state(8);
                        //s = {n.state(0),n.state(1), n.state(2),n.state(3),0, n.state(4),n.state(6),n.state(7),n.state(8)};
                        n3 = new Node(s, n, "left", 1, depth);
                        return iddfsearch(n3, depth-1,goalState);
                    }else{
                        return iddfsearch(n2, depth-1,goalState);
                    }
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the left down
            }else if(n.state(6) == 0){
                s[0] = n.state(0);
                s[1] = n.state(1);
                s[2] = n.state(2);
                s[3] = n.state(6);
                s[4] = n.state(4);
                s[5] = n.state(5);
                s[6] = n.state(3);
                s[7] = n.state(7);
                s[8] = n.state(8);
                //s = {n.state(0),n.state(1), n.state(2),0,n.state(4),n.state(5),n.state(3),n.state(7),n.state(8)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(7);
                    s[7] = n.state(6);
                    s[8] = n.state(8);
                    //s = {n.state(0), n.state(1),n.state(2),n.state(3),n.state(4),n.state(5),n.state(7),0,n.state(8)};
                    n2 = new Node(s, n, "right", 1, depth);
                    return iddfsearch(n2, depth-1,goalState);
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if th empty is on the down
            }else if(n.state(7) == 0){
                s[0] = n.state(0);
                s[1] = n.state(1);
                s[2] = n.state(2);
                s[3] = n.state(3);
                s[4] = n.state(7);
                s[5] = n.state(5);
                s[6] = n.state(6);
                s[7] = n.state(4);
                s[8] = n.state(8);
                //s = {n.state(0),n.state(1),n.state(2),n.state(3),0,n.state(5),n.state(6),n.state(4),n.state(8)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(7);
                    s[7] = n.state(6);
                    s[8] = n.state(8);
                    //s = {n.state(0),n.state(1),n.state(2),n.state(3),n.state(4),n.state(5),0, n.state(6),n.state(8)};
                    n2 = new Node(s, n, "left", 1, depth);
                    if(iddfsearch(n2, depth-1,goalState) == null){
                        s[0] = n.state(0);
                        s[1] = n.state(1);
                        s[2] = n.state(2);
                        s[3] = n.state(3);
                        s[4] = n.state(4);
                        s[5] = n.state(5);
                        s[6] = n.state(6);
                        s[7] = n.state(8);
                        s[8] = n.state(7);
                        //s = {n.state(0),n.state(1), n.state(2),n.state(3),n.state(4),n.state(5),n.state(6),n.state(8),0};
                        n3 = new Node(s, n, "right", 1, depth);
                        return iddfsearch(n3, depth-1,goalState);
                    }else{
                        return iddfsearch(n2, depth-1,goalState);
                    }
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
                //if the empty is on the right down
            }else if(n.state(8) == 0){
                s[0] = n.state(0);
                s[1] = n.state(1);
                s[2] = n.state(2);
                s[3] = n.state(3);
                s[4] = n.state(4);
                s[5] = n.state(8);
                s[6] = n.state(6);
                s[7] = n.state(7);
                s[8] = n.state(5);
                //s = {n.state(0),n.state(1), n.state(2),n.state(3),n.state(4),0,n.state(6),n.state(7),n.state(5)};
                n1 = new Node(s, n, "up", 1, depth);
                if(iddfsearch(n1, depth-1,goalState) == null){
                    s[0] = n.state(0);
                    s[1] = n.state(1);
                    s[2] = n.state(2);
                    s[3] = n.state(3);
                    s[4] = n.state(4);
                    s[5] = n.state(5);
                    s[6] = n.state(6);
                    s[7] = n.state(8);
                    s[8] = n.state(7);
                    //s = {n.state(0), n.state(1),n.state(2),n.state(3),n.state(4),n.state(5),n.state(6),0,n.state(7)};
                    n2 = new Node(s, n, "left", 1, depth);
                    return iddfsearch(n2, depth-1,goalState);
                }else{
                    return iddfsearch(n1, depth-1,goalState);
                }
            }
            
            
        }
        
        return null;
    }
    public static void main(String[] args){
        int[] goalState = new int[9];
        goalState[0] = 0;
        goalState[1] = 1;
        goalState[2] = 2;
        goalState[3] = 3;
        goalState[4] = 4;
        goalState[5] = 5;
        goalState[6] = 6;
        goalState[7] = 7;
        goalState[8] = 8;
        int[] initState= new int[9];
        initState[0] = 5;
        initState[1] = 0;
        initState[2] = 4;
        initState[3] = 2;
        initState[4] = 1;
        initState[5] = 3;
        initState[6] = 6;
        initState[7] = 7;
        initState[8] = 8;
        Node root = new Node(initState);
        for(int i =0; i < 20; i++){
            if (iddfsearch(root,i,goalState) != null){
                System.out.println("Found");
            }else{
                System.out.println("Nothing");
            }
        }
        
    }
    
    
}