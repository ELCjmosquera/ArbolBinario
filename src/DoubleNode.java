public class DoubleNode {
    private Object data;
    private DoubleNode parent;
    private DoubleNode left;
    private DoubleNode right;

    public DoubleNode(Object data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

    public DoubleNode getParent() { return parent; }
    public void setParent(DoubleNode parent) { this.parent = parent; }

    public DoubleNode getLeft() { return left; }
    public void setLeft(DoubleNode left) { this.left = left; }

    public DoubleNode getRight() { return right; }
    public void setRight(DoubleNode right) { this.right = right; }
}