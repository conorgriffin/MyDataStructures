package com.conorgriffin.datastructures;

/**
 * An implementation of a Linked Binary Search Tree
 * 
 * @author conorgriffin
 *
 * @param <E>
 */
public class LinkedBST<E extends Comparable<? super E>> implements BST<E> {

    private BSTNode<E> root;

    // default constructor
    public LinkedBST() {
        root = null;
    }
    
    // constructor with a root element
    public LinkedBST(E rootData) {
        root = new BSTNode<E>(rootData);
    }
    
    /**
     * This inner class BSTNode<T> represents an element in the LinkedBST
     * 
     * @author conorgriffin
     *
     * @param <T> The type of the element
     */
    public static class BSTNode<T> {
        private T data;
        private BSTNode<T> left;
        private BSTNode<T> right;
        
        public BSTNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        public int compareTo() {
            return 0;
        }
    }
    
    public void insert(E k) {
        root = insert(root, k);
    }

    /**
     * Insert a node with the given key unless it already exists
     * 
     * @param node
     * @param key
     */
    private static <T extends Comparable<? super T>> BSTNode<T> insert(BSTNode<T> node, T key) {
        
        if(node == null) {
            node = new BSTNode<T>(key);
        } else if(key.compareTo(node.data) < 0) {
            node.left = insert(node.left, key);
        } else if(key.compareTo(node.data) > 0) {
            node.right = insert(node.right, key);
        }
        
        return node;
    }

    public void delete(E key) {
        root = delete(root, key);
    }
    
    /**
     * Delete the node with a matching key if it exists
     * 
     * @param node
     * @param key
     */
    private static <T extends Comparable<? super T>> BSTNode<T> delete( BSTNode<T> node, T key) {
        if(node == null) {
            // do nothing, the node doesn't exist in this tree
        } else if(key.compareTo(node.data) < 0) { 
            node.left = delete(node.left, key);
        } else if(key.compareTo(node.data) > 0) {
            node.right = delete(node.right, key);
        } else {
            if(node.right == null) {
                node = node.left;
            } else {
                T replacement = min(node.right);
                node.data = replacement;
                node.right = delete(node.right, replacement);
            }
        }
        
        return node;
    }
    
    /**
     * Keep going left until the next left element is null.  Then return the current element.
     * 
     * @param node
     * @return T The object representing the smallest value in the tree
     */
    private static <T extends Comparable<? super T>> T min(BSTNode<T> node) {
        if (node.left == null) {
            return node.data;
        } else {
            return min(node.left);
        }
    }

    public boolean lookup(E k) {
        return lookup(root, k);
    }
    
    private static <T extends Comparable<? super T>> boolean lookup(BSTNode<T> node, T data) {
        if(node == null) {
            return false;
        } else if(data.compareTo(node.data) == 0) {
            return true;
        } else if(data.compareTo(node.data) < 0) {
            return lookup(node.left, data);
        } else {
            return lookup(node.right, data);
        }
    }
    
    /**
     * Output the tree as a comma-separated list
     * @return String representing the tree as a list
     */
    public String toString() {
        StringBuilder description = new StringBuilder("[");
        subtreeToString(root, description);
        description.append("]");
        return description.toString();
    }

    /**
     * Recursive method to output tree as a string 
     * @param <T>
     * 
     * @param node
     * @param string
     */
    private <T> void subtreeToString(BSTNode<T> node, StringBuilder string) {
        if (node == null) {
            return;
        }
        
        if (node.left != null) {
            subtreeToString(node.left, string);
            string.append(", ");
        }

        string.append(node.data);

        if (node.right != null) {
            string.append(", ");
            subtreeToString(node.right, string);
        }
    }
    
}