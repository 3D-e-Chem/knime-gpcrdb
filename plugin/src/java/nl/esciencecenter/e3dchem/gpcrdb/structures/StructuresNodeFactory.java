package nl.esciencecenter.e3dchem.gpcrdb.structures;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "Structures" Node. Get a list of structures
 */
public class StructuresNodeFactory extends NodeFactory<StructuresNodeModel> {

	@Override
	public StructuresNodeModel createNodeModel() {
		return new StructuresNodeModel();
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<StructuresNodeModel> createNodeView(int viewIndex, StructuresNodeModel nodeModel) {
		return null;
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		return new StructuresNodeDialog();
	}

}
