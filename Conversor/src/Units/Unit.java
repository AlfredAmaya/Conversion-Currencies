package Units;

import java.util.Objects;

public class Unit {
	private String Name;
	private Double Scale;
	private String Symbol;
	private Unit_System Base;
	 
	
	public Unit(String name,String simbolo,Double scale,Unit_System Base) {
		this.Scale=scale;
		this.Name=name;
		this.Symbol=simbolo;
		this.Base=Base;
	}
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getScale() {
		return Scale;
	}

	public void setScale(Double scale) {
		Scale = scale;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public Unit_System getBase() {
		return Base;
	}

	public void setBase(Unit_System base) {
		Base = base;
	}
	
	public Double Convert(Unit To,Double Value) {
		Double Result;
		if(this.Base.equals(To.Base)) {
			Result = Value*(this.Scale/To.Scale);
		}else {
			Result = ((Value*this.Scale)*(this.Base.getBase_convertion()))/To.Scale;
		}		
		return Result;
	}
	
	@Override
	public String toString() {
		return(this.Name);
	}



	@Override
	public int hashCode() {
		return Objects.hash(Base, Name, Scale, Symbol);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		return Objects.equals(Base, other.Base) && Objects.equals(Name, other.Name)
				&& Objects.equals(Scale, other.Scale) && Objects.equals(Symbol, other.Symbol);
	}
	
	
	 
	
	
	
}
