package sem4;

public class BinTree {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        }
        if (addNode(root, value) != null)
            return true;
        return false;

    }




    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else
                return addNode(node.left, value);
        } else  {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else
                return addNode(node.right, value);
        }
    }


    private Node balancing(Node node) {
        Node result = node;
        boolean needBalance;

        do {
            needBalance = false;
            if (result.right != null && result.color == Color.red &&
                    (result.left == null || result.left.color == Color.black)) {
                needBalance = true;
                result = rightTurn(result);
            }

            if (result.left != null && result.left.color == Color.red &&
                    result.left.left != null && result.left.left.color == Color.red) {
                needBalance = true;
                result = leftTurn(result);
            }

            if (result.left != null && result.left.color == Color.red &&
                    result.right != null && result.right.color == Color.red) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);

        return result;
    }

        // левый поворот
        private Node leftTurn(Node node) {
            Node left = node.left;
            Node right = left.right;
            left.right = node;
            node.left = right;
            left.color = node.color;
            node.color = Color.red;
            return left;
        }
    
        // правый поворот
        private Node rightTurn(Node node) {
            Node right = node.right;
            Node left = right.left;
            right.left = node;
            node.right = left;
            right.color = node.color;
            node.color = Color.red;
            return right;
        }

        private void colorSwap(Node node) {
            node.color = Color.red;
            node.right.color = Color.black;
            node.left.color = Color.black;
        }




    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }



    private class Node {
        int value;
        Node left;
        Node right;
        Color color;
        Node() {
            this.color = Color.red;
        }

        Node(int _value) {
            this.value = _value;
            this.color = Color.red;
        }
    }
    enum Color {red, black}
}
