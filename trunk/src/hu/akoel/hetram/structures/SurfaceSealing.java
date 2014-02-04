package hu.akoel.hetram.structures;

import hu.akoel.hetram.accessories.Length;
import hu.akoel.hetram.accessories.Orientation;

public class SurfaceSealing extends AStructureSealing{
	
	private double alpha;
	private double airTemperature;
		
	public SurfaceSealing( Orientation orientation, Length length, double alpha, double airTemperature ){
		super( orientation, length );		
		this.alpha = alpha;
		this.airTemperature = airTemperature;
	}

	public double getAlpha() {
		return alpha;
	}

	public double getAirTemperature() {
		return airTemperature;
	}

}