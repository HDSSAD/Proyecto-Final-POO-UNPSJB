package modelo;

import java.util.ArrayList;

public class Computadora {

	private String idComputadora, estado;
	private ArrayList<CompPlacaBase> placaBase;
	private ArrayList<CompProcesador> procesador;
	private ArrayList<CompDiscoRigido> disco;
	private ArrayList<CompMemoriaRam> ram;
	private ArrayList<CompLectora> lectora;

	public Computadora(String idComputadora, String estado, ArrayList<CompPlacaBase> placaBase,
			ArrayList<CompProcesador> procesador, ArrayList<CompDiscoRigido> disco, ArrayList<CompMemoriaRam> ram,
			ArrayList<CompLectora> lectora) {
		super();
		this.setIdComputadora(idComputadora);
		this.setEstado(estado);
		this.setPlacaBase(placaBase);
		this.setProcesador(procesador);
		this.setDisco(disco);
		this.setRam(ram);
		this.setLectora(lectora);
	}
	
	public ArrayList<CompPlacaBase> getPlacaBase() {
		return placaBase;
	}
	public void setPlacaBase(ArrayList<CompPlacaBase> placaBase) {
		this.placaBase = placaBase;
	}
	public ArrayList<CompProcesador> getProcesador() {
		return procesador;
	}
	public void setProcesador(ArrayList<CompProcesador> procesador) {
		this.procesador = procesador;
	}
	public ArrayList<CompDiscoRigido> getDisco() {
		return disco;
	}
	public void setDisco(ArrayList<CompDiscoRigido> disco) {
		this.disco = disco;
	}
	public ArrayList<CompMemoriaRam> getRam() {
		return ram;
	}
	public void setRam(ArrayList<CompMemoriaRam> ram) {
		this.ram = ram;
	}
	public ArrayList<CompLectora> getLectora() {
		return lectora;
	}
	public void setLectora(ArrayList<CompLectora> lectora) {
		this.lectora = lectora;
	}
	public String getIdComputadora() {
		return idComputadora;
	}

	public void setIdComputadora(String idComputadora) {
		this.idComputadora = idComputadora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}