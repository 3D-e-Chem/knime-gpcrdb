package nl.esciencecenter.e3dchem.gpcrdb.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "Interactions" Node.
 * Get a list of interactions between structure and ligand
 */
public class InteractionsNodeFactory 
        extends NodeFactory<InteractionsNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionsNodeModel createNodeModel() {
        return new InteractionsNodeModel();
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
    public NodeView<InteractionsNodeModel> createNodeView(final int viewIndex,
            final InteractionsNodeModel nodeModel) {
        return null;
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
        return new InteractionsNodeDialog();
    }

}

