public class Node {
public int state = 0;
public Node parentNode;
public string action;
public int pathCost;
public int depth;


public Node Point(int s, node pn, string a, int pc, int d) {
state = s;
parentNode = pn;
action = a;
pathCost = pc;
depth = d;
}
}