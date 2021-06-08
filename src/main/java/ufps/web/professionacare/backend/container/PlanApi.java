package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptPlan;

public class PlanApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private SsptPlan plan;

	public SsptPlan getPlan() {
		return plan;
	}

	public void setPlan(SsptPlan plan) {
		this.plan = plan;
	}

}
