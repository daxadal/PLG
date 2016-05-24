package abstree.expresiones;

import abstree.Declaracion;
import errors.UnsuportedOperation;

public abstract class Expresion {
	public abstract TipoE tipo();
	public Expresion op1() throws UnsuportedOperation {throw new UnsuportedOperation("op1");}
	public Expresion op2() throws UnsuportedOperation {throw new UnsuportedOperation("op2");}
	public int num() throws UnsuportedOperation {throw new UnsuportedOperation("num");}
	public String id() throws UnsuportedOperation {throw new UnsuportedOperation("id");}
	/**Devuelve la referencia a la declaracion de la variable*/
	public Declaracion ref() throws UnsuportedOperation {throw new UnsuportedOperation("ref");}
	public Expresion elemAt(int i) throws UnsuportedOperation {throw new UnsuportedOperation("elemAt" +i);}
	public abstract TipoV getTipo() throws UnsuportedOperation {throw new UnsoportedOperation("type mismatch");}
}
