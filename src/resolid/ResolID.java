package resolid;


import errors.GestionErroresTiny;
import errors.IdentifyingIdException;
import errors.UnsuportedOperation;
import abstree.Declaracion;
import abstree.Funcion;
import abstree.Programa;
import abstree.expresiones.Identificador;
import abstree.sentencias.Call;

public class ResolID extends VisitorHelper {

	private TablaDeSimbolos tabla;
	
	public ResolID() {
		this.tabla = new TablaDeSimbolos();
	}
	
	@Override
	public void previsit(Declaracion node) {
		try {
			tabla.insertaIdV(node.getId(), node);
		} catch (IdentifyingIdException e) {
			GestionErroresTiny.errorID(e.getFila(), e.getLocalizedMessage(), e.getFilaDecl());
		}
	}

	@Override
	public boolean previsit(Funcion node) {
		try {
			tabla.insertaIdF(node.getId(), node);
			tabla.abreBloqueV();
		} catch (IdentifyingIdException e) {
			GestionErroresTiny.errorID(e.getFila(), e.getLocalizedMessage(), e.getFilaDecl());
		}
		return true;
	}

	@Override 
	public void postvisit(Funcion node) {
		tabla.cierraBloqueV();
	}

	@Override
	public void previsit(Programa node) {
		tabla.abreBloqueV();
	}

	@Override
	public void postvisit(Programa node) {
		tabla.cierraBloqueV();
	}

	@Override 
	public void visit(Identificador node) {
		try {
			Declaracion ref = tabla.buscaIdV(node.id());
			node.setRef(ref);
		} catch (IdentifyingIdException e) {
			GestionErroresTiny.errorID(node.getFila(), e.getLocalizedMessage(), -1);
		} catch (UnsuportedOperation e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean previsit(Call node) {
		try {
			Funcion ref = tabla.buscaIdF(node.functionID());
			node.setRef(ref);
		} catch (IdentifyingIdException e) {
			GestionErroresTiny.errorID(node.getFila(), e.getLocalizedMessage(), -1);
		} catch (UnsuportedOperation e) {
			e.printStackTrace();
		}
		return true;
	}

}
