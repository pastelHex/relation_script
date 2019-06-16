package node.common;

import java.util.HashMap;

public abstract class BiNode implements Computable {
    protected BiNode leftNode = null;
    protected BiNode rightNode = null;

    protected NodeType side;
    public String varName;
    public Integer identificator;

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

    public static void setIdentificatorsToLeafs(HashMap<String, Integer> identificators, BiNode node) {
        if (node == null)
            return;
        if (node.leftNode == null && node.rightNode == null) {//liść
            Integer ident = identificators.get(node.varName);
            node.identificator = ident;
        }
        if (node.leftNode != null)
            setIdentificatorsToLeafs(identificators, node.leftNode);

        if (node.rightNode != null)
            setIdentificatorsToLeafs(identificators, node.rightNode);
    }
}
