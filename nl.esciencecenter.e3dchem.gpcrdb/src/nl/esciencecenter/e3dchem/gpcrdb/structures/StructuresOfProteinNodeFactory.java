package nl.esciencecenter.e3dchem.gpcrdb.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 */
public class StructuresOfProteinNodeFactory 
        extends NodeFactory<StructuresOfProteinNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public StructuresOfProteinNodeModel createNodeModel() {
        return new StructuresOfProteinNodeModel();
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
    public NodeView<StructuresOfProteinNodeModel> createNodeView(final int viewIndex,
            final StructuresOfProteinNodeModel nodeModel) {
        return new StructuresOfProteinNodeView(nodeModel);
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
        return new StructuresOfProteinNodeDialog();
    }

}

