package Units;

public class Unit_System {
	private String system;
	private String type;
	private Double base_convertion;
	
	public Unit_System(String system,String tipo,Double rate){
		this.system=system;
		this.type=tipo;
		this.setBase_convertion(rate);
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBase_convertion() {
		return base_convertion;
	}

	public void setBase_convertion(Double base_convertion) {
		this.base_convertion = base_convertion;
	}
	
	
	
	
}
