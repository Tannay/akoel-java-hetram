package hu.akoel.hetram.drawingelements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import hu.akoel.mgu.drawnblock.DrawnBlock;

public class SymmetricEdgeElement extends DrawnBlock{

	private static final long serialVersionUID = -1063105162303271067L;
	
	private static final Stroke NORMAL_STROKE = new BasicStroke(3);
	
	private static final Color SELECTED_COLOR = Color.red;
	private static final Stroke SELECTED_STROKE = new BasicStroke(3);
	
	private static final Color INFOCUS_COLOR = Color.yellow;
	private static final Stroke INFOCUS_STROKE = new BasicStroke(3);
	
	private static final Stroke INPROCESS_STROKE = new BasicStroke(5);

	private SymmetricEdgeElement(Status status, double x1, double y1,
			java.lang.Double minLength, java.lang.Double maxLength,
			java.lang.Double minWidth, java.lang.Double maxWidth) {
		super(status, x1, y1, minLength, maxLength, minWidth, maxWidth);
	}

	private SymmetricEdgeElement( Status status, double x1, double y1 ){
		super( status, x1, y1 );
	}
	
	public SymmetricEdgeElement( Status status, double x1, double y1, java.lang.Double minLength, java.lang.Double maxLength, java.lang.Double minWidth, java.lang.Double maxWidth, Color color ){
		super( status, x1, y1, minLength, maxLength, minWidth, maxWidth );
		
		setNormal( color, NORMAL_STROKE, color );
		setSelected( SELECTED_COLOR, SELECTED_STROKE, color );
		setInfocus(INFOCUS_COLOR, INFOCUS_STROKE, color );
		setInprocess( color, INPROCESS_STROKE, color );
		
		refreshStatus();
		
	}
}