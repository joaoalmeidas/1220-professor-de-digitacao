import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DigitacaoFrame extends JFrame {

	private JLabel labelInstrucaoDigitacao;
	private JLabel labelNotaInstrucao;
	private JTextField campoDigitacao;
	
	private JTextArea textFrase;
	
	private JButton[] teclas;
	private final static String[] nomeTeclas = {"'", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
												"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "´", "[", "Enter",
												"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç", "~", "]", "Enter2",
												"Shift", "\\", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ":", "/", "ShiftDir",
												"Ctrl", "cmd", "Alt", "Espaço", "Alt", "cmd", "MsD", "Ctrl"};
	
	private final static int[] codigoTeclas = {222, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 45, 61, 8, 9, 81, 
			87, 69, 82, 84, 89, 85, 73, 79, 80, 129, 91, 10, 20, 65, 83, 68, 70, 71, 72, 74, 75, 76, 0, 131, 
			93, 10, 16, 92, 90, 88, 67, 86, 66, 78, 77, 44, 46, 59, 0, 16, 17, 524, 18, 32, 17, 524, 525, 17};
	
	private JPanel panelTeclado;
	private JPanel panelTituloCampoDigitacao;
	private JPanel panelCampoDigitacao;
	private JPanel panelLinhaUmTeclado;
	private JPanel panelLinhaDoisTeclado;
	private JPanel panelLinhaTresTeclado;
	private JPanel panelLinhaQuatroTeclado;
	private JPanel panelLinhaCincoTeclado;
	private JPanel panelFrase;
	
	private Digitacao dig;
	private int fraseAtual = 0;
	private int letraAtual = 0;
	
	public DigitacaoFrame() {
		
		super("Digitação");
		setLayout(new FlowLayout());
		
		dig = new Digitacao();
		
		
		panelTeclado = new JPanel(new GridLayout(6, 1));
		panelTituloCampoDigitacao = new JPanel(new GridLayout(2, 1));
		panelCampoDigitacao = new JPanel(new BorderLayout());
		panelFrase = new JPanel(new FlowLayout());
		
		labelInstrucaoDigitacao = new JLabel("Digite as frases abaixo usando o teclado. As teclas que você apertar serão destacadas e o texto será exibido.");
		labelNotaInstrucao = new JLabel("Observação: Clicar nos botões do seu mouse não resultaram em nenhuma ação.");
		panelTituloCampoDigitacao.add(labelInstrucaoDigitacao);
		panelTituloCampoDigitacao.add(labelNotaInstrucao);
		
		panelCampoDigitacao.add(panelTituloCampoDigitacao, BorderLayout.NORTH);
		panelCampoDigitacao.setPreferredSize(new Dimension(1300, 300));
		
		
		campoDigitacao = new JTextField();
		campoDigitacao.setFont(new Font("TimesRoman", Font.PLAIN, 35));
		panelCampoDigitacao.add(campoDigitacao, BorderLayout.CENTER);
		
		textFrase = new JTextArea(String.format(Digitacao.getPangramas()[fraseAtual]));
		textFrase.setEditable(false);
		textFrase.setEnabled(false);
		textFrase.setDisabledTextColor(Color.BLACK);
		textFrase.setFont(new Font("TimesRoman", Font.PLAIN, 35));
		textFrase.setPreferredSize(new Dimension(1300, 200));
		panelFrase.add(textFrase);
		
		panelLinhaUmTeclado = new JPanel(new FlowLayout());
		panelLinhaDoisTeclado = new JPanel(new FlowLayout());
		panelLinhaTresTeclado = new JPanel(new FlowLayout());
		panelLinhaQuatroTeclado = new JPanel(new FlowLayout());
		panelLinhaCincoTeclado = new JPanel(new FlowLayout());
		
		teclas = new JButton[nomeTeclas.length];
		
		for(int i = 0; i < teclas.length; i++) {
			
			teclas[i] = new JButton(nomeTeclas[i]);
			
			if(nomeTeclas[i].equals("Backspace")) {
				
				teclas[i].setMinimumSize(new Dimension(120, 50));
				teclas[i].setPreferredSize(new Dimension(120, 50));
				teclas[i].setMaximumSize(new Dimension(120, 50));
				
			}else if(nomeTeclas[i].equals("Enter") || nomeTeclas[i].equals("Caps")){
				
				teclas[i].setMinimumSize(new Dimension(90, 50));
				teclas[i].setPreferredSize(new Dimension(90, 50));
				teclas[i].setMaximumSize(new Dimension(90, 50));
				
			}else if(nomeTeclas[i].equals("Tab") || nomeTeclas[i].equals("Enter2") ){
				
				teclas[i].setMinimumSize(new Dimension(80, 50));
				teclas[i].setPreferredSize(new Dimension(80, 50));
				teclas[i].setMaximumSize(new Dimension(80, 50));
				
			}else if(nomeTeclas[i].equals("ShiftDir")){
				
				teclas[i].setMinimumSize(new Dimension(107, 50));
				teclas[i].setPreferredSize(new Dimension(107, 50));
				teclas[i].setMaximumSize(new Dimension(107, 50));
				
			}else if(nomeTeclas[i].equals("Shift") || nomeTeclas[i].equals("Ctrl") || nomeTeclas[i].equals("Alt") || nomeTeclas[i].equals("MsD")
					|| nomeTeclas[i].equals("cmd")){
				
				teclas[i].setMinimumSize(new Dimension(63, 50));
				teclas[i].setPreferredSize(new Dimension(63, 50));
				teclas[i].setMaximumSize(new Dimension(63, 50));
				
			}else if(nomeTeclas[i].equals("Espaço")){
				
				teclas[i].setMinimumSize(new Dimension(360, 50));
				teclas[i].setPreferredSize(new Dimension(360, 50));
				teclas[i].setMaximumSize(new Dimension(360, 50));
				teclas[i].setText("");
				
				
			}else {
				
				teclas[i].setMinimumSize(new Dimension(50, 50));
				teclas[i].setPreferredSize(new Dimension(50, 50));
				teclas[i].setMaximumSize(new Dimension(50, 50));
				
			}
				
			
			
			if(i >= 0 && i <= 13) {
				
				panelLinhaUmTeclado.add(teclas[i]);
				
			}else if(i >= 14 && i <= 27) {
				
				panelLinhaDoisTeclado.add(teclas[i]);
				
			}else if(i >= 26 && i <= 41) {
				
				panelLinhaTresTeclado.add(teclas[i]);
				
			}else if(i >= 42 && i <= 55) {
				
				panelLinhaQuatroTeclado.add(teclas[i]);
				
			}else if(i >= 56 && i <= 68) {
				
				panelLinhaCincoTeclado.add(teclas[i]);
				
			}
			
			
			

		}

		
		final Color corOriginal = teclas[0].getBackground();
		

		
		campoDigitacao.addKeyListener(
		
					new KeyListener() {
						
						

						@Override
						public void keyPressed(KeyEvent arg0) {
							
							for(int i = 0; i < teclas.length; i++) {
								
								if(arg0.getKeyCode() == codigoTeclas[i]) {
									
										
									teclas[i].setBackground(Color.cyan);
									
									
									if(arg0.getKeyCode() == 8) {
										
										letraAtual--;
										
									}
									
									
								}
								
								
								
							}
							
						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							
							for(int i = 0; i < teclas.length; i++) {
								
								if(arg0.getKeyCode() == codigoTeclas[i]) {
									
									teclas[i].setBackground(corOriginal);
									
								}
								
								
							}
							
							if(campoDigitacao.getText().charAt(letraAtual) == textFrase.getText().charAt(letraAtual)) {
								
								letraAtual++;
								dig.setAcertos(dig.getAcertos() + 1);
								
							}else {
								
								for(int i = 0; i < teclas.length; i++) {
									
									if(arg0.getKeyCode() == codigoTeclas[i]) {
										
										dig.getErrosPorTecla()[i] += 1; 
										
									}
									
									
								}
								
								
								
								campoDigitacao.setText(campoDigitacao.getText().substring(0, letraAtual));
								
							}
							
							System.out.println(textFrase.getText());
							System.out.println(campoDigitacao.getText());
							
							if(textFrase.getText().equals(campoDigitacao.getText())) {
								
								
								
								if(fraseAtual < 9) {
									
									fraseAtual++;
									textFrase.setText(Digitacao.getPangramas()[fraseAtual]);
									campoDigitacao.setText(null);
									letraAtual = 0;
									
									
								}else {
									
									campoDigitacao.setText(null);
									campoDigitacao.setEditable(false);
									textFrase.setText(dig.toString());
									
								}
								
								
							}
							
							
							
							
							
							
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							
							
							
							
							
						}
						
						
					}
					
				
		);
		
		
		
		panelTeclado.add(panelLinhaUmTeclado);
		panelTeclado.add(panelLinhaDoisTeclado);
		panelTeclado.add(panelLinhaTresTeclado);
		panelTeclado.add(panelLinhaQuatroTeclado);
		panelTeclado.add(panelLinhaCincoTeclado);

		
		
		add(panelCampoDigitacao);
		add(panelFrase);
		add(panelTeclado);
		
	}
	
}
