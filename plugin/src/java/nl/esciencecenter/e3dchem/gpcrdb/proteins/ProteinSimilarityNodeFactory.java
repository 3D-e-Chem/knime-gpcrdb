package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "ProteinSimilarity" Node. Get a list of structures of a protein
 */
public class ProteinSimilarityNodeFactory extends NodeFactory<ProteinSimilarityNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ProteinSimilarityNodeModel createNodeModel() {
        return new ProteinSimilarityNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasDialog() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeDialogPane createNodeDialogPane() {
        return new ProteinSimilarityNodeDialog();
    }

    @Override
    public NodeView<ProteinSimilarityNodeModel> createNodeView(int viewIndex, ProteinSimilarityNodeModel nodeModel) {
        return null;
    }

}
