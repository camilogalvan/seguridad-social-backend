package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptPlan;

public class PlanesApi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<SsptPlan> planes;

	public List<SsptPlan> getPlanes() {
		return planes;
	}

	public void setPlanes(List<SsptPlan> planes) {
		this.planes = planes;
	}

}
