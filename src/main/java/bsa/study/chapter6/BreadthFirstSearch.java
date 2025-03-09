package bsa.study.chapter6;

import bsa.study.chapter6.Graph.Graph;
import bsa.study.chapter6.Graph.Node;
import bsa.study.chapter6.Queue.Queue;

import java.util.ArrayList;

public class BreadthFirstSearch {
    private static void putAllNeighboringNodesToSearchQueue(
            Node<String> fromNode, Queue<Node<String>> searchQueue, Graph<String> graph) {

        if (graph.isNodeNotHaveNeighbors(fromNode)) {
            return;
        }

        ArrayList<Node<String>> toNodes = graph.getNeighbors(fromNode);
        for (Node<String> node : toNodes) {
            if (!node.isChecked()) {
                searchQueue.put(node);
                node.setChecked(true);
            }
        }
    }

    public static Node<String> findNearestSeller(Graph<String> graph) throws Exception {
        graph.markAllNodesAsUnchecked();

        if (graph.isGraphNotHaveMainNode()) {
            throw new Exception("The main node is not specified, the search is impossible");
        }

        Node<String> mainNode = graph.getMainNode();
        if (graph.isNodeNotHaveNeighbors(mainNode)) {
            throw new Exception("The main node has no connections to other nodes, the search is impossible");
        }

        Queue<Node<String>> searchQueue = new Queue<>();

        putAllNeighboringNodesToSearchQueue(mainNode, searchQueue, graph);

        while (!searchQueue.isEmpty()) {
            Node<String> node = searchQueue.pop();
            if (node.isSeller()) {
                return node;
            }

            putAllNeighboringNodesToSearchQueue(node, searchQueue, graph);
        }

        return null;
    }
}
