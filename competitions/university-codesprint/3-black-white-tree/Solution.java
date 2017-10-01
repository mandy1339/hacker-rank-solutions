import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Node> tree = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        Node root = null;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                   // Scan n
        int[] c = new int[n];                   // Create an array of colors size n
        for (int c_i = 0; c_i < n; c_i++) {       // Run n times
            c[c_i] = in.nextInt();                  // Scan all the colors
        }
        for (int a0 = 0; a0 < n - 1; a0++) {        // Run n - 1 times
            int x = in.nextInt();                   // Scan first node of edge
            int y = in.nextInt();                   // Scan second node of edge
            edges.add(new Edge(x, y));              // Add edge to edges list
            // Write Your Code Here
        }
        in.close();

        tree.add(new Node(0));                  // Add dummy node at index 0
        // 1-Create n nodes and push them to tree using colors from c
        for (int i = 1; i <= n; i++) {
            int color = 0;
            if (c[i - 1] == 0) {
                color = 1;
            } else
                color = -1;
            tree.add(new Node(i, color));
        }


        // 2-Create each node's incident node list
        for (int i = 0; i < n - 1; i++) {
            tree.get(edges.get(i).id1).incidentNodes.add(tree.get(edges.get(i).id2));           // Add first node from edge to incident list of id1
            tree.get(edges.get(i).id2).incidentNodes.add(tree.get(edges.get(i).id1));           // Add second node from edge to incident list of id2
        }

        // 3-Set root = to node n cuz why not
        root = tree.get(n);

        // 4-Run strangeify
        strangeify(root, root);

        // 5-Find max strange
        Node maxNode = maxStange(tree);
        //System.out.println("maxnode: " + maxNode.id);

        // 6-Store color of max strange node
        int maxColor = 0;
        if(maxNode.strangeness < 0) {
            maxColor = -1;
        }
        if(maxNode.strangeness > 0) {
            maxColor = 1;
        }
        //System.out.println("maxcolor: " + maxColor);

        // 7-Cut all leaves that are opposite color or just substract them from max
        // run strangeify under maxNode to find leaves under that subtree
        // count the leaves that are of diff color
        ArrayList<Integer> outList = new ArrayList<Integer>();
        int leavesDiffColor = countOppColorLeaves(maxNode, maxColor, root, outList);
        // add them to max

        // 8-If parent is same color, add parent recursively.
        int noOfAncesters = addAncester(maxNode, outList, maxColor);

        // 9-For every ancester, add the


        System.out.println(Math.abs(maxNode.strangeness) + leavesDiffColor + noOfAncesters);
        System.out.println(outList.size());
        for (Integer num : outList) {
            System.out.print(num + " ");
        }
//         Print tree
//        for(Node node: tree) {
//            System.out.println("id: " + node.id + " color: " + node.color + " strangeness: " + node.strangeness + " childOf: " + node.childOf + " incidentNodes: " + node.printIncidentNodes());
//        }
//        System.out.println("max: " + maxNode.strangeness);  // Print the max strangeness
//        System.out.println("leavesDiffColor:: " + leavesDiffColor);
//        System.out.println("ROOT: " + root.id);
    }










    // STRANGEIFY()
    // Finds strangeness of a node recursively in termos of the strangeness of the children
    // ---------------------------------------------------------
    public static int strangeify(Node node, Node root) {
        node.parent = true;
        int subStrange = 0;
        if (node.incidentNodes.size() == 1 && !node.equals(root)) {       // If node is a leaf (base  case)
            node.childOf =  node.incidentNodes.get(0);                      // Set its parent
            node.strangeness = node.color;
            return node.color;                                              // Return its color
        }
        for (Node neighbour : node.incidentNodes) {                     // For every incident node
            if(neighbour.parent == true) {                                  // If the neighbour is the parent, set it as so
                node.childOf = neighbour;
            }
            if(neighbour.parent == false) {                            // Except the parent
                subStrange += strangeify(neighbour, root);                  // Strangeness of subtree = recur on neighbour and add to subStrange
            }
        }
        node.strangeness = subStrange + node.color;                     // Set this node's strangeness
        return node.strangeness;                                        // Return it's strangeness
    }

    //MAXSTRANGE()
    // Goes through the nodes in the list looking for the max strange and returns it.
    // ----------------------------------------------------------
    public static Node maxStange(ArrayList<Node> tree) {
        int max = 0;
        Node maxNode = null;
        for(Node node: tree) {
            if(Math.abs(node.strangeness) > max) {
                max = Math.abs(node.strangeness);
                maxNode = node;
            }
        }
        return maxNode;
    }

    //COUNTOPPCOLORLEAVES()
    // Recursively find the leaves with different color and add them
    // ------------------------------------------------------------
    public static int countOppColorLeaves(Node node, int color, Node root, ArrayList<Integer> outList) {
        int sum = 0;
        if(node.equals(root) == false && node.incidentNodes.size() == 1 && node.color != color) {
            return 1;
        }
        outList.add(node.id);                                          // Add to list of nodes in output
        for (Node neighbour: node.incidentNodes) {                     // For every incident node
            if(node.equals(root)) {
                sum += countOppColorLeaves(neighbour, color, root, outList);
            }
            else if(node.childOf.equals(neighbour) == false) {                            // Except the parent
                sum += countOppColorLeaves(neighbour, color, root, outList);                // Strangeness of subtree = recur on neighbour and add to subStrange
            }
        }
        return sum;
    }

    public static int addAncester(Node node, ArrayList<Integer> outList, int maxColor) {
        int sum = 0;
        if(node.childOf == null) {                      // If root stop
            return 0;
        }
        else if(node.childOf.color != maxColor) {
            return 0;
        }
        else {
            outList.add(node.childOf.id);
            sum = 1 + addAncester(node.childOf, outList, maxColor);
        }
        return sum;
    }
}




// CLASS NODE
// ----------------------------------------
// ----------------------------------------
class Node {
    // Instance data
    ArrayList<Node> incidentNodes;
    public int id;
    public int color;
    public int strangeness;
    public boolean parent;
    public Node childOf;

    // Constructors
    public Node(int id, int color) {
        this.id = id;
        this.color = color;
        this.incidentNodes = new ArrayList<Node>();
        this.parent = false;
    }
    public Node(int id) {
        this.id = id;
        this.incidentNodes = new ArrayList<Node>();
        this.parent = false;
    }
    public Node() {
        this.incidentNodes = new ArrayList<Node>();
        this.parent = false;
    }

    // Methods
    public String printIncidentNodes() {
        String ptrStr = "";
        for(Node node: incidentNodes) {
            ptrStr += " " + node.id;
        }
        return ptrStr;
    }
}



// CLASS EDGE
// ----------------------------------------
// ----------------------------------------
class Edge {
    public int id1;
    public int id2;
    public Edge(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}

/*

8
1 0 0 1 1 0 0 0
7 1
3 5
1 6
4 3
6 3
2 3
7 8


*/