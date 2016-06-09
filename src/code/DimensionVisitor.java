package code;

import abstree.tipos.ArrayOf;
import abstree.tipos.Bool;
import abstree.tipos.Int;
import resolid.VisitorHelper;

public class DimensionVisitor extends VisitorHelper {

	public DimensionVisitor(){
		this.dsuper = 1;
	}
	
	public int getDsuper(){
		return this.dsuper;
	}
	
	@Override public void previsit(ArrayOf arrayOf) {}
	
	@Override 
	public void postvisit(ArrayOf arrayOf) {
		this.dsuper *= arrayOf.getTam();
	}
	
	@Override 
	public void visit(Bool bool) {
		this.dsuper = 1;
	}
	
	@Override 
	public void visit(Int int1) {
		this.dsuper = 1;
	}

	private int dsuper;
}
