package nl.esciencecenter.e3dchem.gpcrdb.proteinfamilies;

import org.knime.core.node.NodeView;

/**
 * <code>NodeView</code> for the "StructuresOfProtein" Node.
 * Get a list of structures of a protein
 *
 */
public class ProteinFamiliesNodeView extends NodeView<ProteinFamiliesNodeModel> {

    /**
     * Creates a new view.
     * 
     * @param nodeModel The model (class: {@link ProteinFamiliesNodeModel})
     */
    protected ProteinFamiliesNodeView(final ProteinFamiliesNodeModel nodeModel) {
        super(nodeModel);

        // TODO instantiate the components of the view here.

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void modelChanged() {

        // TODO retrieve the new model from your nodemodel and 
        // update the view.
        ProteinFamiliesNodeModel nodeModel = 
            (ProteinFamiliesNodeModel)getNodeModel();
        assert nodeModel != null;
        
        // be aware of a possibly not executed nodeModel! The data you retrieve
        // from your nodemodel could be null, emtpy, or invalid in any kind.
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onClose() {
    
        // TODO things to do when closing the view
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onOpen() {

        // TODO things to do when opening the view
    }

}

