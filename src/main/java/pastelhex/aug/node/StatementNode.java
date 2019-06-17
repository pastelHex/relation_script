package pastelhex.aug.node;

import pastelhex.aug.node.common.BiContextNode;
import pastelhex.aug.node.common.BiNode;
import pastelhex.aug.node.common.NodeType;
import pastelhex.aug.parser;

public class StatementNode extends BiNode {
    @Override
    public Integer compute(BiContextNode ctx) {
        String var = getLeftNode().varName;
        Integer value = getRightNode().compute(ctx);
        parser.setVariable("a",3);
        //parser.setVariable
        return 1;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.STATEMENT;
    }
}
