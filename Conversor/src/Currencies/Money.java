package Currencies;

public class Money implements Comparable<Money>{
	private String Name;
	private double Dollar_Value;
	private String Code;
	
	public Money(String nombre,Double valor,String codigo) {
		
		this.Name=nombre.toUpperCase();
		this.Code=codigo;
		this.Dollar_Value=valor;
	}
	
	public String getName() {
		return this.Name;
	}
	
	
	public String getCode() {
		return Code;
	}
	
	public double getDollar_Value(){
		return this.Dollar_Value;
	}
	

	@Override
	public String toString(){
		return(this.Name);
	}


	@Override
	public boolean equals(Object obj) {
		Money Moneda = (Money) obj;
		return this.Name.equals(Moneda.getName());
	}
	
	@Override
	public int hashCode() {
		return this.Name.hashCode();
	}

	@Override
	public int compareTo(Money o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	
}
