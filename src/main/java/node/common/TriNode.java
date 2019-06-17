package node.common;

import java.util.HashMap;

public class TriNode implements Computable {

    private Computable conditionNode;
    private Computable trueNode;
    private Computable falseNode;

    public TriNode(Computable ifNode, Computable trueNode, Computable falseNode) {
        this.conditionNode = ifNode;
        this.trueNode = trueNode;
        this.falseNode = falseNode;
    }

    @Override
    public Integer compute(BiContextNode ctx) {
        int ifResult = getConditionNode().compute(ctx);
        Integer finalResult = 0;
        if (ifResult == 0) {//false
            finalResult = getFalseNode().compute(ctx);
        } else {
            finalResult = getTrueNode().compute(ctx);
        }
        return finalResult;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.TRINODE;
    }

    @Deprecated
    public static void setIdentificatorsToLeafs(HashMap<String, Integer> identificators, TriNode node) {
        if (node == null)
            return;
        BiNode.setIdentificatorsToLeafs(identificators, (BiNode) node.getConditionNode());
        BiNode.setIdentificatorsToLeafs(identificators, (BiNode) node.getTrueNode());
        BiNode.setIdentificatorsToLeafs(identificators, (BiNode) node.getFalseNode());
    }

    public void setIdentificatorsToLeafs(HashMap<String, Integer> identificators) {
        this.getConditionNode().setIdentificatorsToLeafs(identificators);
        this.getTrueNode().setIdentificatorsToLeafs(identificators);
        this.getFalseNode().setIdentificatorsToLeafs(identificators);
    }

    public Computable getConditionNode() {
        return conditionNode;
    }

    public Computable getTrueNode() {
        return trueNode;
    }

    public Computable getFalseNode() {
        return falseNode;
    }
}