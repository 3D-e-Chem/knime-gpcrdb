package nl.esciencecenter.e3dchem.gpcrdb.residues;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 */
public class ResiduesNodeFactory 
        extends NodeFactory<ResiduesNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResiduesNodeModel createNodeModel() {
        return new ResiduesNodeModel();
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
    public NodeView<ResiduesNodeModel> createNodeView(final int viewIndex,
            final ResiduesNodeModel nodeModel) {
        return new ResiduesNodeView(nodeModel);
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
        return new ResiduesNodeDialog();
    }

}

