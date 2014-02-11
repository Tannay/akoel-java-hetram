package hu.akoel.hetram.gui.drawingelements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

public class FullPatternBuildingStructuralElement extends HetramBuildingStructureElement{

	private final Stroke NORMAL_STROKE = new BasicStroke(1);
	
	private final Color SELECTED_COLOR = Color.red;
	private final Color SELECTED_BACKGROUND = Color.yellow;
	private final Stroke SELECTED_STROKE = new BasicStroke(1);

	//private static final Color INPROCESS_COLOR = Color.yellow;
	//private static final Color INPROCESS_BACKGROUND = Color.gray;
	private final Stroke INPROCESS_STROKE = new BasicStroke(3);
	
	private final Color INFOCUS_COLOR = Color.yellow;
	//private static final Color INFOCUS_BACKGROUND = Color.gray;
	private final Stroke INFOCUS_STROKE = new BasicStroke(1);
	
	private FullPatternBuildingStructuralElement(Status status, BigDecimal x1, BigDecimal y1, BigDecimal minLength, BigDecimal maxLength, BigDecimal minWidth, BigDecimal maxWidth, double lambda, Color lineColor, Color backgroundColor) {
		super(status, x1, y1, minLength, maxLength, minWidth, maxWidth, lambda, lineColor, backgroundColor );
	}
	
	public FullPatternBuildingStructuralElement(FullPatternInterface fullPatternInterface, Status status, BigDecimal x1, BigDecimal y1, double lambda, Color lineColor, Color backgroundColor ) {
		super( status, x1, y1, lambda, lineColor, backgroundColor );
		
		int patternWidth = fullPatternInterface.getPatternWidth();
		int patternHeight = fullPatternInterface.getPatternHeight();
		
		TexturePaint normalTexturePaint;
		TexturePaint selectedTexturePaint;
		TexturePaint infocusTexturePaint;
		TexturePaint inprocessTexturePaint;

		Rectangle r = new Rectangle( 0, 0, patternWidth, patternHeight );
	
		//
		//Normal
		//
		BufferedImage bi1 = new BufferedImage( patternWidth, patternHeight, BufferedImage.TYPE_INT_RGB); 
		Graphics2D big1 = bi1.createGraphics();
		big1.setColor( getBackgroundColor() );
		big1.fillRect( 0, 0, patternWidth, patternHeight );
		big1.setColor( getLineColor() ); 
		fullPatternInterface.drawPattern(big1, patternWidth, patternHeight);
		normalTexturePaint = new TexturePaint( bi1,r ); 
	
		//
		// Selected
		//
		BufferedImage bi2 = new BufferedImage( patternWidth, patternHeight, BufferedImage.TYPE_INT_RGB); 
		Graphics2D big2 = bi2.createGraphics();
		big2.setColor( SELECTED_BACKGROUND );
		big2.fillRect( 0, 0, patternWidth, patternHeight );
		big2.setColor( SELECTED_COLOR ); 
		fullPatternInterface.drawPattern(big2, patternWidth, patternHeight);
		selectedTexturePaint = new TexturePaint( bi2,r ); 
	
		//
		// Infocus
		//
		BufferedImage bi3 = new BufferedImage( patternWidth, patternHeight, BufferedImage.TYPE_INT_RGB); 
		Graphics2D big3 = bi3.createGraphics();
		big3.setColor( getBackgroundColor() );
		big3.fillRect( 0, 0, patternWidth, patternHeight );
		big3.setColor( INFOCUS_COLOR ); 
		fullPatternInterface.drawPattern(big3, patternWidth, patternHeight);
		infocusTexturePaint = new TexturePaint( bi3,r ); 
	
		//
		// Inprocess
		//
		BufferedImage bi4 = new BufferedImage( patternWidth, patternHeight, BufferedImage.TYPE_INT_RGB); 
		Graphics2D big4 = bi4.createGraphics();
		big4.setColor( getBackgroundColor() );
		big4.fillRect( 0, 0, patternWidth, patternHeight );
		big4.setColor( getLineColor() ); 
		fullPatternInterface.drawPattern(big4, patternWidth, patternHeight);		 
		inprocessTexturePaint = new TexturePaint( bi4,r ); 
	
		setNormal( getLineColor(), NORMAL_STROKE, normalTexturePaint );
		setSelected( SELECTED_COLOR, SELECTED_STROKE, selectedTexturePaint );
		setInfocus(INFOCUS_COLOR, INFOCUS_STROKE, infocusTexturePaint );
		setInprocess( getLineColor(), INPROCESS_STROKE, inprocessTexturePaint );
		
	}
	
}