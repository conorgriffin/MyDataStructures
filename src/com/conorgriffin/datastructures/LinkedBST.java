package com.conorgriffin.datastructures;

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
    
    public void insert(E k) {
        root = insert(root, k);
    }

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
     * 
     * @param node
     * @param key
     * @return
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
    
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        helpToString(root, string);
        string.append("]");
        return string.toString();
    }

    /**
     * Recursive help method for toString. 
     * @param <T>
     * 
     * @param node
     * @param string
     */
    private <T> void helpToString(BSTNode<T> node, StringBuilder string) {
        if (node == null)
            return; // Tree is empty, so leave.

        if (node.left != null) {
            helpToString(node.left, string);
            string.append(", ");
        }

        string.append(node.data);

        if (node.right != null) {
            string.append(", ");
            helpToString(node.right, string);
        }
    }
    
}