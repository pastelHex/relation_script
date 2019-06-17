package node;

//import parser;
import node.common.BiContextNode;
import node.common.BiNode;
import node.common.NodeType;

public class StatementNode extends BiNode {
    @Override
    public Integer compute(BiContextNode ctx) {
        String var = getLeftNode().varName;
        Integer value = getRightNode().compute(ctx);
        //parser.setVariable
        //parser.setVariable
        return 1;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.STATEMENT;
    }
}
