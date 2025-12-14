package trees;

class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void insert(int data) {
        if(this.data == data) {
            return;
        }
        if(this.data < data) {
            if(rightChild == null) {
                rightChild = new TreeNode(data);
            }
            else {
                rightChild.insert(data);
            }
        }
        else {
            if(leftChild == null) {
                leftChild = new TreeNode(data);
            }
            else {
                leftChild.insert(data);
            }
        }
    }

    public TreeNode get(int data) {
        if(this.data == data) {
            return this;
        }
        else if(this.data < data) {
            if(rightChild != null) {
                return rightChild.get(data);
            }
            else {
                return null;
            }
        }
        else {
            if(leftChild != null) {
                return leftChild.get(data);
            }
            else {
                return null;
            }
        }
    }

    public void inorderTraversal() {
        if(leftChild != null) {
            leftChild.inorderTraversal();
            System.out.print(" ");
        }
        System.out.print(data);
        if(rightChild != null) {
            System.out.print(" ");
            rightChild.inorderTraversal();
        }
    }

    public void preorderTraversal() {
        System.out.print(data);
        if(leftChild != null) {
            System.out.print(" ");
            leftChild.preorderTraversal();
        }
        if(rightChild != null) {
            System.out.print(" ");
            rightChild.preorderTraversal();
        }
    }

    public void postorderTraversal() {
        if(leftChild != null) {
            leftChild.postorderTraversal();
            System.out.print(" ");
        }
        if(rightChild != null) {
            rightChild.postorderTraversal();
            System.out.print(" ");
        }
        System.out.print(data);
    }

    public int min() {
        if(leftChild != null) {
            return leftChild.min();
        }
        return data;
    }

    public int max() {
        if(rightChild != null) {
            return rightChild.max();
        }
        return data;
    }

}

class Tree {
    private TreeNode root;

    public void insert(int data) {
        if(root == null) {
            root = new TreeNode(data);
        }
        else {
            root.insert(data);
        }
    }

    public TreeNode get(int data) {
        if(root == null) {
            throw new IllegalStateException("Tree is empty!");
        }
        return root.get(data);
    }

    public void inorderTraversal() {
        if(root == null) {
            return;
        }
        System.out.println("-------InorderTraversal-------");
        root.inorderTraversal();
        System.out.println();
        System.out.println("------------------------------");
    }

    public void preorderTraversal() {
        if(root == null) {
            return;
        }
        System.out.println("-------PreorderTraversal-------");
        root.preorderTraversal();
        System.out.println();
        System.out.println("-------------------------------");
    }

    public void postorderTraversal() {
        if(root == null) {
            return;
        }
        System.out.println("-------PostorderTraversal-------");
        root.postorderTraversal();
        System.out.println();
        System.out.println("--------------------------------");
    }

    public int min() {
        if(root == null) {
            throw new IllegalStateException("Tree is empty!");
        }
        return root.min();
    }

    public int max() {
        if(root == null) {
            throw new IllegalStateException("Tree is empty!");
        }
        return root.max();
    }

    public TreeNode delete(TreeNode subtreeRoot, int data) {
        if(subtreeRoot == null) {
            return null;
        }
        if(subtreeRoot.getData() == data) {
            // case 1 and 2: node to delete has 0 or 1 children
            if(subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            }
            else if(subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            // case 3: node to delete has 2 children
            // get the min node from the right children or max value from the left children
//            int valueToReplaceWith = subtreeRoot.getLeftChild().max();
//            subtreeRoot.setData(valueToReplaceWith);
//            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), valueToReplaceWith));
            int valueToReplaceWith = subtreeRoot.getRightChild().min();
            subtreeRoot.setData(valueToReplaceWith);
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), valueToReplaceWith));
        }
        else if(subtreeRoot.getData() < data) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), data));
        }
        else {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), data));
        }
        return subtreeRoot;
    }

    public void delete(int data) {
        root = delete(root, data);
    }
}

public class BinarySearchTreeImpl {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        tree.inorderTraversal();
        tree.preorderTraversal();
        tree.postorderTraversal();
        System.out.println(tree.min());
        System.out.println(tree.max());
        System.out.println(tree.get(27));
        tree.delete(15);
        tree.inorderTraversal();
    }
}
