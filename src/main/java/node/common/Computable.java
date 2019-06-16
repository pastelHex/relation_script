package node.common;

import java.util.HashMap;

public interface Computable {

    public Integer compute(BiContextNode ctx);
    public NodeType getNodeType();
    public void setIdentificatorsToLeafs(HashMap<String, Integer> identificators);
}
