package ufps.web.professionacare.backend.util;

import java.util.Date;

public interface FormateadorService {
	
	public String getFecha(Date fecha);
	
	public Boolean verificarDato(String dato);
	
	public Boolean verificarEmail(String dato);
	
	public Double getDouble(String valor);
	
	public Date getFecha(String fecha);
	
	public String getHora(Date fecha);
	
	public String getFechaHora(Date fecha);
	
	public String getAniosAndMesesBetween(Date fecha);
	
	public long getDiasDeDiferencia(Date fecha);
	
	public long getDiasDeDiferencia(Date fechainicio, Date fechaFin);
	
	public String cantidadConLetra(String s);

}
