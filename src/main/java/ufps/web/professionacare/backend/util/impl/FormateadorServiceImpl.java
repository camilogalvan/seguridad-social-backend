package ufps.web.professionacare.backend.util.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import ufps.web.professionacare.backend.util.FormateadorService;

@Service
public class FormateadorServiceImpl implements FormateadorService {
	private static final String UNIDADES[] = { "", "Un ", "Dos ", "Tres ", "Cuatro ", "Cinco ", "Seis ", "Siete ",
			"Ocho ", "Nueve " };
	private static final String DECENAS[] = { "", "Dieci", "Veinti", "Treinta ", "Cuarenta ", "Cincuenta ", "Sesenta ",
			"Setenta ", "Ochenta ", "Noventa " };
	private static final String CENTENAS[] = { "", "Ciento ", "Doscientos ", "Trescientos ", "Cuatrocientos ",
			"Quinientos ", "Seiscientos ", "Setecientos ", "Ochocientos ", "Novecientos " };

	@Override
	public String getFecha(Date fecha) {
		if (fecha != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
		}
		return "";
	}

	@Override
	public Boolean verificarDato(String dato) {
		try {
			return dato.strip().length() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	@Override
	public Boolean verificarEmail(String dato) {
		try {
			Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher mather = pattern.matcher(dato);
			return mather.find();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Double getDouble(String valor) {
		try {
			return Double.parseDouble(valor);
		} catch (Exception e) {
		}
		return 0d;
	}

	@Override
	public Date getFecha(String fecha) {
		if (fecha != null) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
			} catch (Exception e) {
			}
		}
		return null;
	}

	@Override
	public String getHora(Date fecha) {
		if (fecha != null) {
			return new SimpleDateFormat("HH:mm:ss").format(fecha);
		}
		return "";
	}

	@Override
	public String getFechaHora(Date fecha) {
		if (fecha != null) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fecha);
		}
		return "";
	}

	@Override
	public String getAniosAndMesesBetween(Date fecha) {

		try {
			Instant instant = Instant.ofEpochMilli(fecha.getTime());
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			LocalDate fechaNac = localDateTime.toLocalDate();

			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);

			return String.format("%s año(s) y %s mes(es)", periodo.getYears(), periodo.getMonths());
		} catch (Exception e) {
		}
		return "";
	}

	@Override
	public long getDiasDeDiferencia(Date fecha) {

		long diff = new Date().getTime() - fecha.getTime();

		return (diff / (86400000));

	}

	@Override
	public long getDiasDeDiferencia(Date fechaInicio, Date fechaFin) {

		long diff = fechaFin.getTime() - fechaInicio.getTime();

		return (diff / (86400000));
	}

	@SuppressWarnings("deprecation")
	@Override
	public String cantidadConLetra(String s) {
		StringBuilder result = new StringBuilder();
		BigDecimal totalBigDecimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN);
		long parteEntera = totalBigDecimal.toBigInteger().longValue();
		int triUnidades = (int) ((parteEntera % 1000));
		int triMiles = (int) ((parteEntera / 1000) % 1000);
		int triMillones = (int) ((parteEntera / 1000000) % 1000);
		int triMilMillones = (int) ((parteEntera / 1000000000) % 1000);

		if (parteEntera == 0) {
			result.append("Cero ");
			return result.toString();
		}

		if (triMilMillones > 0)
			result.append(triTexto(triMilMillones).toString() + "Mil ");
		if (triMillones > 0)
			result.append(triTexto(triMillones).toString());

		if (triMilMillones == 0 && triMillones == 1)
			result.append("Millón ");
		else if (triMilMillones > 0 || triMillones > 0)
			result.append("Millones ");

		if (triMiles > 0)
			result.append(triTexto(triMiles).toString() + "Mil ");
		if (triUnidades > 0)
			result.append(triTexto(triUnidades).toString());

		return result.toString();
	}

	private static StringBuilder triTexto(int n) {
		StringBuilder result = new StringBuilder();
		int centenas = n / 100;
		int decenas = (n % 100) / 10;
		int unidades = (n % 10);

		if (n == 100) {
			result.append("Cien ");
			return result;
		} else
			result.append(CENTENAS[centenas]);

		if (decenas == 1 && unidades <= 5) {
			if (unidades == 0)
				result.append("Diez ");
			else if (unidades == 1)
				result.append("Once ");
			else if (unidades == 2)
				result.append("Doce ");
			else if (unidades == 3)
				result.append("Trece ");
			else if (unidades == 4)
				result.append("Catorce ");
			else if (unidades == 5)
				result.append("Quince ");
			return result;
		} else if (decenas == 2 && unidades == 0) {
			result.append("Veinte ");
			return result;
		} else
			result.append(DECENAS[decenas]);

		if (decenas > 2 && unidades > 0)
			result.append("y ");

		result.append(UNIDADES[unidades]);

		return result;
	}

}
