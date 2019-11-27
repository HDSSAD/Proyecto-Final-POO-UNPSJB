package modelo;

import componentes.CompDiscoRigido;
import componentes.CompLectora;
import componentes.CompMemoriaRam;
import componentes.CompPlacaBase;
import componentes.CompProcesador;

public class Computadora {

	private String idComputadora, estado, notas;
	private CompPlacaBase placaBase;
	private CompProcesador procesador;
	private CompDiscoRigido disco;
	private CompMemoriaRam ram;
	private CompLectora lectora;

	public Computadora(String idComputadora, String estado, CompPlacaBase placaBase, CompProcesador procesador,
			CompDiscoRigido disco, CompMemoriaRam ram, CompLectora lectora, String notas) {
		super();
		this.setIdComputadora(idComputadora);
		this.setEstado(estado);
		this.setPlacaBase(placaBase);
		this.setProcesador(procesador);
		this.setDisco(disco);
		this.setRam(ram);
		this.setLectora(lectora);
		this.setNotas(notas);
	}

	@Override
	public String toString() {
		return "Nº Computadora: " + this.getIdComputadora() + "  -  Estado: " + this.getEstado() + "\n \nPlaca Base "
				+ this.getPlacaBase().toString() + "\nProcesador " + this.getProcesador().toString() + "\nDisco "
				+ this.getDisco().toString() + "\nMemoria Ram " + this.getRam().toString() + "\nLectora "
				+ this.getLectora().toString();
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

	public CompPlacaBase getPlacaBase() {
		return placaBase;
	}

	public void setPlacaBase(CompPlacaBase placaBase) {
		this.placaBase = placaBase;
	}

	public CompProcesador getProcesador() {
		return procesador;
	}

	public void setProcesador(CompProcesador procesador) {
		this.procesador = procesador;
	}

	public CompDiscoRigido getDisco() {
		return disco;
	}

	public void setDisco(CompDiscoRigido disco) {
		this.disco = disco;
	}

	public CompMemoriaRam getRam() {
		return ram;
	}

	public void setRam(CompMemoriaRam ram) {
		this.ram = ram;
	}

	public CompLectora getLectora() {
		return lectora;
	}

	public void setLectora(CompLectora lectora) {
		this.lectora = lectora;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

}