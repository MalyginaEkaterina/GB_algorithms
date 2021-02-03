package ru.geekbrains;
import java.util.Random;

public class Tree {
    TreeNode root;

    public void insert(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (node.value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (node.value > current.value) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void preOrderTraverse(TreeNode currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode);
            preOrderTraverse(currentNode.left);
            preOrderTraverse(currentNode.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public int getDepth(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left == null) {
            return getDepth(node.right) + 1;
        } else if (node.right == null) {
            return getDepth(node.left) + 1;
        } else {
            return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
        }

    }

    //возвращает -1, если несбалансировано и глубину дерева иначе
    public int isBalanced(TreeNode node) {
        if (node.right == null && node.left == null) {
            return 0;
        } else if (node.right == null) {
            int leftDepth = getDepth(node.left);
            return (leftDepth > 0) ? -1 : leftDepth + 1;
        } else if (node.left == null) {
            int rightDepth = getDepth(node.right);
            return (rightDepth > 0) ? -1 : rightDepth + 1;
        } else {
            int leftBal = isBalanced(node.left);
            int rightBal = isBalanced(node.right);
            if (leftBal == -1 || rightBal == -1) {
                return -1;
            } else {
                return Math.max(leftBal, rightBal) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Tree tree = new Tree();
            for (int k = 0; k < 20; k++) {
                int v = random.nextInt(201) - 100;
                //System.out.println(v);
                tree.insert(new TreeNode(v));
            }
            int isBal = tree.isBalanced(tree.root);
            if (isBal != -1) {
                System.out.println(isBal);
            }
        }


    }
}
