/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.List;

/** 
 * Clone Graph #133 --- Accepted 384ms/364ms
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *     First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *     Second node is labeled as 1. Connect node 1 to node 2.
 *     Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * @author yanma
 * @since 2015-06-02
 * @version 2015-06-02
 */
public class CloneGraph_133 {

	/**
	 * Accepted 384ms
	 * use node object as key in hashtable
	 * @param node
	 * @return
	 */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return node;
        }
        List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        java.util.Hashtable<UndirectedGraphNode, UndirectedGraphNode> hashtable = new java.util.Hashtable<>();
        list.add(node);
        hashtable.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        while (start < list.size()) {
			UndirectedGraphNode currNode = list.get(start);			
			for (UndirectedGraphNode neighbor : currNode.neighbors) {
				if (!hashtable.containsKey(neighbor)) {
					list.add(neighbor);
					hashtable.put(neighbor, new UndirectedGraphNode(neighbor.label));
				}
			}
			start++;
		}//copy nodes into hashtable, value: node with label only
        
        for (UndirectedGraphNode newnode : list) {
			List<UndirectedGraphNode> neighbors = newnode.neighbors;
			for (UndirectedGraphNode neighbor : neighbors) {
				hashtable.get(newnode).neighbors.add(hashtable.get(neighbor));
			}
		}//copy neighbors into hashtable
        return hashtable.get(node);
    }
	
    /**
     * Accepted 364ms
     * use node.label as key in hashtable
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
        	return node;
        }
        
        List<UndirectedGraphNode> list = new ArrayList<>();
        java.util.Hashtable<Integer, UndirectedGraphNode> hashtable = new java.util.Hashtable<>();
        hashtable.put(node.label, new UndirectedGraphNode(node.label));
        list.add(node);
        
        //can't use for (UndirectedGraphNode undirectedGraphNode : list) to loop through list
        //cause concurrent modification Exception
        for (int i = 0; i < list.size(); i++) {
        	for (UndirectedGraphNode neighbor : list.get(i).neighbors) {
        		if (!hashtable.containsKey(neighbor.label)) {
    				hashtable.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
    				list.add(neighbor);
    			}
			}
			
		} // create all nodes in hashtable
        
        // create all relations in hashtable for each node
        // neighbor in hashtable
        for (UndirectedGraphNode undirectedGraphNode : list) {
			UndirectedGraphNode currNode = hashtable.get(undirectedGraphNode.label);
			for (UndirectedGraphNode neighbor : undirectedGraphNode.neighbors) {
				currNode.neighbors.add(hashtable.get(neighbor.label));
			}
		}
        
        return hashtable.get(node.label);
    }
    
    
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
