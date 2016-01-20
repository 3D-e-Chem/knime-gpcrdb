package nl.esciencecenter.e3dchem.gpcrdb.proteinfamilies;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 */
public class ProteinFamiliesNodeFactory 
        extends NodeFactory<ProteinFamiliesNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ProteinFamiliesNodeModel createNodeModel() {
        return new ProteinFamiliesNodeModel();
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
    public NodeView<ProteinFamiliesNodeModel> createNodeView(final int viewIndex,
            final ProteinFamiliesNodeModel nodeModel) {
        return new ProteinFamiliesNodeView(nodeModel);
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
        return new ProteinFamiliesNodeDialog();
    }

}

