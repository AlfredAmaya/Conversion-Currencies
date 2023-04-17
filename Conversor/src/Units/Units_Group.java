package Units;

import java.util.ArrayList;
import java.util.List;

public class Units_Group {
	private List<Unit> Unit_List = new ArrayList<>();
	private String tipo;
	
	public Units_Group(String tipo) {
		this.tipo=tipo;
	}
	
	
	public List<Unit> getUnit_List() {
		return Unit_List;
	}
	public void setUnit_List(List<Unit> ulit_List) {
		Unit_List = ulit_List;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void addUnit(Unit Unidad) {
		this.Unit_List.add(Unidad);
	}
	
	public void printUnit_list() {
		Unit_List.forEach(U->{
			System.out.println(U);
		});
	}
	
}
