package com.nirvana.learning.interview.linklist;

import com.nirvana.learning.interview.linkedlist.DeleteDuplicateNodes;
import com.nirvana.learning.interview.linkedlist.LinkedList;
import com.nirvana.learning.interview.linkedlist.Node;
import org.junit.Test;

public class DeleteDuplicateNodesTest {

    @Test
    public void testDifferentCases() {
        DeleteDuplicateNodes deleteDuplicateNodes = new DeleteDuplicateNodes();
        LinkedList linkedList = new LinkedList();
        Node node = null;
        node = linkedList.addNode(1, node);
        node = linkedList.addNode(2, node);
        node = linkedList.addNode(2, node);
        deleteDuplicateNodes.deleteDuplicates(node);
    }
}
