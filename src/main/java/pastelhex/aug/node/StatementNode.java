package pastelhex.aug.node;

import pastelhex.aug.node.common.BiContextNode;
import pastelhex.aug.node.common.BiNode;
import pastelhex.aug.node.common.Computable;
import pastelhex.aug.node.common.NodeType;
import pastelhex.aug.parser;

public class StatementNode extends BiNode {
    public StatementNode(){}
    public StatementNode(BiNode left, BiNode right){
        this.leftNode = left;
        this.rightNode = right;
    }
    @Override
    public Integer compute(BiContextNode ctx) {
        String var = getLeftNode().varName;
        Integer value = getRightNode().compute(ctx);
        parser.setVariable(var,value);
        return 1;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.STATEMENT;
    }
}
