package abstree.expresiones;


public class And extends ExpresionBinaria {

	public And(Expresion op1, Expresion op2) {
		super(op1, op2);
	}

	@Override
	public TipoE tipo() {
		return TipoE.AND;
	}

}
