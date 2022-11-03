package Calculadora.Simple;

public class CalculadoraStatus {

	private double resultado;
	private double num1;
	private double num2;
	private String operador;
	
	//Constructor por defecto.
	
	public CalculadoraStatus() {
		resultado=0;
	}
	
	//Constructor con los dos numeros que calcularemos.
	
	public CalculadoraStatus(double num1,double num2) {
		resultado=0;
		this.num1 = num1;
		this.num2 = num1;
	}
	
	//Método para resetear el resultado.
	
	public void resetResultado() {
		this.resultado=0;
	}

	//Setters y getters necesarios para trabajar con los operadores.
	
	public double getResultado() {
		return this.resultado;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	public String getOperador() {
		return operador;
	}

	//Método para calcular
	
	public double calcular(double num1, double num2,String operador) {
		if(operador=="+") {
			resultado=num1+num2;
		}
		if(operador=="-") {
			resultado=num1-num2;
		}
		if(operador=="/") {
			resultado=num1/num2;
		}
		if(operador=="*") {
			resultado=num1*num2;
		}
		return resultado;
	}
	
}
