package com.algorithm;

public class BinaryTreeTraversal {
    class Node {
        int key;
        Node left;
        Node right;
        public Node(int key) {
            this.key = key;
        }

    }

    class BinaryTree {
        Node root;
        public BinaryTree(Node root) {
            this.root = root;
        }
    }

    public static void  main(String args[]) {
        System.out.println("Good morning ..........");
        new BinaryTreeTraversal().binaryTreeTraversal();

    }

    public void binaryTreeTraversal() {


        Node three = new Node(3);
        Node six = new Node(6);

        Node five = new Node(5);
        five.left = three ;
        five.right = six ;

        Node eight = new Node(8);
        Node ten= new Node(10);

        Node seventy = new Node(70);
        seventy.left = eight ;
        seventy.right = ten ;


        Node fourty = new Node(40);
        fourty.left = five ;
        fourty.right = seventy ;

        BinaryTree tree = new BinaryTree(fourty);

        System.out.println("Level Order (Breadth First) traversal .....................");
        breadthFirstTraversal(tree.root);

        System.out.println("Pre Order (Depth First)traversal .....................");
        preOrderTraversal(tree.root);

        System.out.println("In Order  (Depth First)traversal .....................");
        inOrderTraversal(tree.root);

        System.out.println("Post Order (Depth First) traversal .....................");
        postOrderTraversal(tree.root);

    }

    public void breadthFirstTraversal( Node node) {
        int height = computeHeight(node);
        for (int i= 1;i<=height ;i++) {
            printGivenLevel(node,i);
        }

    }

    public void printGivenLevel(Node node , int level) {
        if(node == null)
            return;
        if(level==1) {
            System.out.println(node.key);
        }
        else if(level>1) {
            printGivenLevel(node.left,level-1);
            printGivenLevel(node.right,level-1);
        }
    }

    private int computeHeight(Node node) {
        if(node ==null)
            return 0;
        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);
        if(leftHeight>rightHeight)
            return  leftHeight +1;
        else
            return rightHeight +1;


    }

    public void preOrderTraversal( Node node) {
        if(node == null)
            return;
        System.out.println(node.key);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node) {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.key);
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.key);

    }


}
