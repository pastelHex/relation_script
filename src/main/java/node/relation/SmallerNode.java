package node.relation;

import node.common.BiContextNode;
import node.common.BiNode;
import node.common.NodeType;

public class SmallerNode extends BiNode {
    @Override
    public Integer compute(BiContextNode ctx) {
        Integer l = leftNode.compute(ctx);
        Integer r = rightNode.compute(ctx);
        return l < r ? 1 : 0;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.SMALLER;
    }
}
