package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import Calculadora.Simple.Calculadora;
import Calculadora.Simple.CalculadoraStatus;

class CalculadoraTest {

	CalculadoraStatus calc;
	Calculadora interfaz;
	
	@BeforeEach
	public void before() {
		calc = new CalculadoraStatus();
	}
	
	@Test
	public void testCalculadoraStatus() {
		calc = new CalculadoraStatus(5.3,8.7);
	}
	
	@Test
	public void testResetResultado() {
		calc.resetResultado();
		double resultado = calc.getResultado();
		double esperado = 0;
		assertEquals(esperado,resultado);
	}
	
	//Testeamos los getters y setters de num1.
	
	@Test
	public void testGetSetNum1() {
		calc.setNum1(10);
		double resultado = calc.getNum1();
		double esperado = 10;
		assertEquals(esperado,resultado);
	}
	
	//Testeamos los getters y setters de num2.
	
	@Test
	public void testGetSetNum2() {
		calc.setNum2(20);
		double resultado = calc.getNum2();
		double esperado = 20;
		assertEquals(esperado,resultado);
	}
	
	//Testeamos los getters y setters de operador..
	
	@Test
	public void testGetSetOperador() {
		calc.setOperador("*");
		String resultado = calc.getOperador();
		String esperado = "*";
		assertEquals(esperado,resultado);
	}
	
	//Para comprobar todos los cálculos con distintos operadores lo haremos a través de un array.
	
	private static Stream<Arguments> getFormatFixture(){
		return Stream.of(
				Arguments.of(5,5,"+",10),
				Arguments.of(5,5,"-",0),
				Arguments.of(5,5,"*",25),
				Arguments.of(5,5,"/",1));
	}
	
	@ParameterizedTest
	@MethodSource("getFormatFixture")
	public void testOperaciones(double a, double b,String c,double d ) {
		double resultado = calc.calcular(a,b,c);
		assertEquals(d,resultado);
	}
		
	@Test
	public void testCalculadoraInterfaz() {
		interfaz = new Calculadora();
		double resultado= interfaz.transformador("987");
		double esperado = 987;
		assertEquals(esperado,resultado);
	}
	

	
}
