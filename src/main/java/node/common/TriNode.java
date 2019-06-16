package node.common;

import java.util.HashMap;

public class TriNode implements Computable {

    private BiNode conditionNode;
    private BiNode trueNode;
    private BiNode falseNode;

    public TriNode(BiNode ifNode, BiNode trueNode, BiNode falseNode) {
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
        BiNode.setIdentificatorsToLeafs(identificators, node.getConditionNode());
        BiNode.setIdentificatorsToLeafs(identificators, node.getTrueNode());
        BiNode.setIdentificatorsToLeafs(identificators, node.getFalseNode());
    }

    public void setIdentificatorsToLeafs(HashMap<String, Integer> identificators) {
        this.getConditionNode().setIdentificatorsToLeafs(identificators);
        this.getTrueNode().setIdentificatorsToLeafs(identificators);
        this.getFalseNode().setIdentificatorsToLeafs(identificators);
    }

    public BiNode getConditionNode() {
        return conditionNode;
    }

    public BiNode getTrueNode() {
        return trueNode;
    }

    public BiNode getFalseNode() {
        return falseNode;
    }
}