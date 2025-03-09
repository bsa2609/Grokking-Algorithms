package bsa.study.chapter6.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {
    private HashMap<T, Node<T>> nodes;
    private HashMap<Node<T>, ArrayList<Node<T>>> edges;
    private Node<T> mainNode;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashMap<>();
    }

    public Graph(T value, boolean isSeller) {
        nodes = new HashMap<>();
        edges = new HashMap<>();

        try {
            addNode(value, isSeller);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addNode(T value, boolean isSeller) throws Exception {
        if (nodes.containsKey(value)) {
            throw new Exception("Node " + value + " already exists");
        }

        boolean isFirstNode = nodes.isEmpty();

        Node<T> node = new Node<>(value, isSeller);
        nodes.put(value, node);

        if (isFirstNode) {
            mainNode = node;
        }
    }

    public void addEdge(T from, T to) throws Exception {
        Node<T> fromNode = nodes.get(from);
        Node<T> toNode = nodes.get(to);

        if (fromNode == null) {
            throw new Exception("Node " + from + " not found");
        }

        if (toNode == null) {
            throw new Exception("Node " + to + " not found");
        }

        ArrayList<Node<T>> toNodes = null;

        if (edges.containsKey(fromNode)) {
            toNodes = edges.get(fromNode);
        } else {
            toNodes = new ArrayList<>();
        }

        toNodes.add(toNode);
        edges.put(fromNode, toNodes);
    }

    public void markAllNodesAsUnchecked() {
        for (Node<T> node : nodes.values()) {
            node.setChecked(false);
        }
    }

    public boolean isGraphNotHaveMainNode() {
        return mainNode == null;
    }

    public Node<T> getMainNode() {
        return mainNode;
    }

    public boolean isNodeNotHaveNeighbors(Node<T> node) {
        return !edges.containsKey(node);
    }

    public ArrayList<Node<T>> getNeighbors(Node<T> fromNode) {
        return edges.get(fromNode);
    }

}
