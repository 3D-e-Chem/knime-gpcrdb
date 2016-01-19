package nl.esciencecenter.e3dchem.gpcrdb.proteins;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 */
public class ProteinInfoNodeFactory 
        extends NodeFactory<ProteinInfoNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ProteinInfoNodeModel createNodeModel() {
        return new ProteinInfoNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeView<ProteinInfoNodeModel> createNodeView(final int viewIndex,
            final ProteinInfoNodeModel nodeModel) {
        return new ProteinInfoNodeView(nodeModel);
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
        return new ProteinInfoNodeDialog();
    }

}

