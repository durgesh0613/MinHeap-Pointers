package main.controller;

import main.model.TreeNode;
import main.controller.utility.Utility;

/**
 * TreeManipulation class currently supports insertion to satisfy min-heap nature of the tree.
 */
public class TreeManipulation {

    //Can be overloaded to support insertion of lists in the future.
    public TreeNode insert(TreeNode root, TreeNode newNode) {
        if (root == null)
            return newNode;
        beginInsertion(root, newNode);
        return root;
    }

    //Recursive method to insert new node as per custom requirement
    public TreeNode beginInsertion(TreeNode root, TreeNode newNode) {
        if (newNode.getData() < root.getData()) {
            //Making the smallest value as the root
            int smallestValue = newNode.getData();
            newNode.setData(root.getData());
            root.setData(smallestValue);
        }

        int leftHeight = Utility.findHeight(root.getLeft());
        int rightHeight = Utility.findHeight(root.getRight());

        if (leftHeight <= rightHeight) { //Adding the new node to the left subHeap
            if (leftHeight == 0)
                root.setLeft(newNode);
            else
                beginInsertion(root.getLeft(), newNode);
        } else { //Adding the new node to the right subHeap
            if (rightHeight == 0)
                root.setRight(newNode);
            else
                beginInsertion(root.getRight(), newNode);
        }
        return root;
    }

    public TreeNode update(TreeNode root){
        /**
         * To be implemented in future
         */
        return root;
    }

    public TreeNode delete(TreeNode root){
        /**
         * To be implemented in future
         */
        return root;
    }
}