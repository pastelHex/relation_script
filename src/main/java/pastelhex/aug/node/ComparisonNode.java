package pastelhex.aug.node;

import pastelhex.aug.node.common.BiContextNode;
import pastelhex.aug.node.common.BiNode;
import pastelhex.aug.node.common.NodeType;

public class ComparisonNode extends BiNode {
    private NodeType operator;

    public ComparisonNode(NodeType operator) {
        this.operator = operator;
    }

    @Override
    public Integer compute(BiContextNode ctx) {
        Integer result = 0;
        Integer l;
        Integer r;
        switch (operator) {
            case SMALLER:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l < r ? 1 : 0;
                break;
            case SMALLER_OR_EQUAL:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l <= r ? 1 : 0;
                break;
            case GREATER:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l > r ? 1 : 0;
                break;
            case GREATER_OR_EQUAL:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l >= r ? 1 : 0;
                break;
            case EQUAL:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l == r ? 1 : 0;
                break;
            case NOT_EQUAL:
                l = leftNode.compute(ctx);
                r = rightNode.compute(ctx);
                result = l != r ? 1 : 0;
                break;
        }

        return result;
    }

    @Override
    public NodeType getNodeType() {
        return operator;
    }
}
