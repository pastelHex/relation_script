package node;

import node.common.BiContextNode;
import node.common.BiNode;
import node.common.NodeType;


public class NumberNode extends BiNode {

    public Integer variable;

    public NumberNode(Integer varName) {
        this.variable = varName;
    }

    @Override
    public Integer compute(BiContextNode ctx) {
        return variable;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.NUMBER;
    }
}
