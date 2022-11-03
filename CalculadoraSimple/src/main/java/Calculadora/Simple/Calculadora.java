package Calculadora.Simple;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textPantalla;
	CalculadoraStatus calc = new CalculadoraStatus();
	int c=0;


	public Calculadora() {
		
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonSumar = new JButton("+");
		botonSumar.setBounds(196, 228, 98, 46);
		botonSumar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(botonSumar);
		
		JButton botonRestar = new JButton("-");
		botonRestar.setBounds(196, 186, 98, 46);
		botonRestar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(botonRestar);
		
		JButton botonMultiplicar = new JButton("x");
		botonMultiplicar.setBounds(196, 142, 98, 46);
		botonMultiplicar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(botonMultiplicar);
		
		JButton botonDividir = new JButton("%");
		botonDividir.setBounds(196, 100, 98, 46);
		botonDividir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(botonDividir);
		
		JButton boton9 = new JButton("9");
		boton9.setBounds(122, 100, 50, 46);
		boton9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(boton9);
		
		JButton boton8 = new JButton("8");
		boton8.setBounds(72, 100, 50, 46);
		boton8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(boton8);
		
		JButton boton7 = new JButton("7");
		boton7.setBounds(22, 100, 50, 46);
		boton7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(boton7);
		
		JButton boton6 = new JButton("6");
		boton6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton6.setBounds(122, 150, 50, 46);
		contentPane.add(boton6);
		
		JButton boton5 = new JButton("5");
		boton5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton5.setBounds(72, 150, 50, 46);
		contentPane.add(boton5);
		
		JButton boton4 = new JButton("4");
		boton4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton4.setBounds(22, 150, 50, 46);
		contentPane.add(boton4);
		
		JButton boton3 = new JButton("3");
		boton3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton3.setBounds(122, 200, 50, 46);
		contentPane.add(boton3);
		
		JButton boton2 = new JButton("2");
		boton2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton2.setBounds(72, 200, 50, 46);
		contentPane.add(boton2);
		
		JButton boton1 = new JButton("1");
		boton1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton1.setBounds(22, 200, 50, 46);
		contentPane.add(boton1);
		
		JButton boton0 = new JButton("0");
		boton0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton0.setBounds(72, 250, 50, 46);
		contentPane.add(boton0);
		
		textPantalla = new JTextField();
		textPantalla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textPantalla.setBackground(new Color(255, 255, 255));
		textPantalla.setEditable(false);
		textPantalla.setBounds(22, 25, 271, 51);
		contentPane.add(textPantalla);
		textPantalla.setColumns(10);
		
		JButton botonReset = new JButton("C");

		botonReset.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonReset.setBounds(196, 280, 98, 46);
		contentPane.add(botonReset);
		
		JButton botonComa = new JButton(",");
		botonComa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonComa.setBounds(122, 250, 50, 46);
		contentPane.add(botonComa);
		
		JButton botonNegativo = new JButton("+/-");
		botonNegativo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botonNegativo.setBounds(22, 250, 50, 46);
		contentPane.add(botonNegativo);
		
		JButton botonIgual = new JButton("=");
		botonIgual.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonIgual.setBounds(47, 301, 98, 46);
		contentPane.add(botonIgual);
		
		JButton botonBorrar = new JButton("<--");
		botonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonBorrar.setBounds(196, 325, 98, 46);
		contentPane.add(botonBorrar);
		
		//Eventos.
		
		//Evento para reiniciar la caja de resultados.
		
		botonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.resetResultado();
				textPantalla.setText("");
				c=0;
			}
		});
		
		//Evento para borrar el último numero.
		
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actual = textPantalla.getText();
				String nuevoActual = actual.substring(0,actual.length()-1);
				textPantalla.setText(nuevoActual);
				c=0;
			}
		});
		
		//Eventos para asignar los números a la acción de mostrarlos en pantalla.
		
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"9");
			}
		});
		
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"8");
			}
		});
		
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"7");
			}
		});
		
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"6");
			}
		});
		
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"5");
			}
		});
		
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"4");
			}
		});
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"3");
			}
		});
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"2");
			}
		});
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"1");
			}
		});
		
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"0");
			}
		});
		
		botonComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+".");
			}
		});
		
		botonNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPantalla.setText(textPantalla.getText()+"-");
			}
		});
		
		//Eventos para realizar las operaciones.
		
		botonMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(c==1) {
						throw (new Exception("Es una calculadora simple.\n"
								+ "No puedes multiplicar más de dos operandos"));
					}
				double numero = transformador(textPantalla.getText());
				calc.setNum1(numero);
				calc.setOperador("*");
				textPantalla.setText("");
				c=1;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}

			}	
		});
		
		botonDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(c==1) {
						throw (new Exception("Es una calculadora simple.\n"
								+ "No puedes dividir más de dos operandos"));
					}
				double numero = transformador(textPantalla.getText());
				calc.setNum1(numero);
				calc.setOperador("/");
				textPantalla.setText("");
				c=1;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}

			}
		});
		
		botonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(c==1) {
						throw (new Exception("Es una calculadora simple.\n"
								+ "No puedes sumar más de dos operandos"));
					}
				double numero = transformador(textPantalla.getText());
				calc.setNum1(numero);
				calc.setOperador("+");
				textPantalla.setText("");
				c=1;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		botonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(c==1) {
						throw (new Exception("Es una calculadora simple.\n"
								+ "No puedes restar más de dos operandos"));
					}
				double numero = transformador(textPantalla.getText());
				calc.setNum1(numero);
				calc.setOperador("-");
				textPantalla.setText("");
				c=1;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		//Evento para obtener el resultado final por pantalla.
		
		botonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==0) {
					JOptionPane.showMessageDialog(null, "Por favor introduce dos operadores antes de obtener el resultado");
				}else {
					
					double numero= Double.parseDouble(textPantalla.getText());
					calc.setNum2(numero);
					double numero1 = calc.getNum1();
					double numero2 = calc.getNum2();
					String operador = calc.getOperador();
					double resultado = calc.calcular(numero1,numero2,operador);
					textPantalla.setText(""+resultado);
					c=0;
				}
			}
		});
		
		
	}
	
	//Método para parsear Strings a doubles.
	public double transformador(String a) {
		double numero = Double.parseDouble(a);
		return numero;
	}
}
