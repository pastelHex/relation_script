package pastelhex.aug.node.common;

import java.util.HashMap;

public abstract class BiNode implements Computable {
    protected BiNode leftNode = null;
    protected BiNode rightNode = null;

    public String varName;
    public Integer identificator;

    public void setLeftNode(BiNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(BiNode rightNode) {
        this.rightNode = rightNode;
    }

    public BiNode getLeftNode() {
        return leftNode;
    }

    public BiNode getRightNode() {
        return rightNode;
    }

    @Deprecated
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

    public void setIdentificatorsToLeafs(HashMap<String, Integer> identificators) {
        if (this.leftNode == null && this.rightNode == null) {//liść
            Integer ident = identificators.get(this.varName);
            this.identificator = ident;
        }
        if (this.leftNode != null)
            leftNode.setIdentificatorsToLeafs(identificators);

        if (this.rightNode != null)
            rightNode.setIdentificatorsToLeafs(identificators);
    }
}
