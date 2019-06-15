package node.common;

public abstract class BiNode implements Computable {
    protected BiNode leftNode;
    protected BiNode rightNode;

    protected NodeType side;

    public void setLeftNode(BiNode leftNode) {
        leftNode.side = NodeType.LEFT_VAR;
        this.leftNode = leftNode;
    }

    public void setRightNode(BiNode rightNode) {
        rightNode.side = NodeType.RIGHT_VAR;
        this.rightNode = rightNode;
    }

    public Computable getLeftNode() {
        return leftNode;
    }

    public Computable getRightNode() {
        return rightNode;
    }
}
