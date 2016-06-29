package abstree;

import java.util.LinkedList;

import resolid.Anfitrion;
import resolid.Visitante;

public class Funcion implements Anfitrion{
	
	public Funcion(String id, LinkedList<Declaracion> entrada, 
			LinkedList<Declaracion> salida, Programa programa) {
		this.id = id;
		this.entrada = entrada;
		this.salida = salida;
		this.programa = programa;
	}
	
	public Funcion(String id, LinkedList<Declaracion> entrada, 
			LinkedList<Declaracion> salida, Programa programa, int fila) {
		this.id = id;
		this.entrada = entrada;
		this.salida = salida;
		this.programa = programa;
		this.fila = fila;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public void accept(Visitante v) {
		boolean cont =  v.previsit(this);
		if (!cont) return;
		
		v.visit(id);
		for(Declaracion d: entrada)
			d.accept(v);
		for(Declaracion d: salida)
			d.accept(v);
		programa.accept(v);
		v.postvisit(this);
	}

    public boolean checkTipo() {
     /*   for(int i=0;i<entrada.size();i++) {
            if(!entrada.get(i).checkTipo())
                throw new UnsuportedOperation("Error de tipo en funcion (entrada).");
        }*/
        
        for(int j=0;j<salida.size();j++) {
            if(!salida.get(j).checkTipo())
                return false;
        }
        
        if(!programa.checkTipo())
            return false;
        return true;
    }

	public LinkedList<Declaracion> getEntrada() {
		return entrada;
	}

	public LinkedList<Declaracion> getSalida() {
		return salida;
	}

	public Programa getPrograma() {
		return programa;
	}

	public int getFila() {
		return fila;
	}

	private String id;
	private LinkedList<Declaracion> entrada;
	private LinkedList<Declaracion> salida;
	private Programa programa;
	private int fila;
}
