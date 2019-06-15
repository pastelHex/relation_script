package node;

import node.common.BiContextNode;
import node.common.BiNode;
import node.common.NodeType;

public class NumberNode extends BiNode {
    @Override
    public Integer compute(BiContextNode ctx) {
        Integer toReturn = null;
        if (side == NodeType.LEFT_VAR) {
            toReturn = ctx.ctx[0];
        } else if (side == NodeType.RIGHT_VAR) {
            toReturn = ctx.ctx[1];
        }
        return toReturn;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.NUMBER;
    }
}
