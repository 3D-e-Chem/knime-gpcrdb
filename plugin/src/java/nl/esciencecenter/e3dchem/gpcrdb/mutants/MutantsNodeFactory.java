package nl.esciencecenter.e3dchem.gpcrdb.mutants;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "Mutants" Node.
 * Get a list of mutations of a protein
 */
public class MutantsNodeFactory 
        extends NodeFactory<MutantsNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public MutantsNodeModel createNodeModel() {
        return new MutantsNodeModel();
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
    public NodeView<MutantsNodeModel> createNodeView(final int viewIndex,
            final MutantsNodeModel nodeModel) {
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
        return new MutantsNodeDialog();
    }

}

