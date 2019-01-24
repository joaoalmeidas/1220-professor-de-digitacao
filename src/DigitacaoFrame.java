import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DigitacaoFrame extends JFrame {

	private JLabel labelInstrucaoDigitacao;
	private JLabel labelNotaInstrucao;
	private JTextArea campoDigitacao;
	
	private JButton[] teclas;
	private final static String[] nomeTeclas = {"'", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
												"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "´", "[", "Enter",
												"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç", "~", "]", "Enter2",
												"Shift", "\\", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ":", "/", "ShiftDir",
												"Ctrl", "cmd", "Alt", "Espaço", "Alt", "cmd", "MsD", "Ctrl"};
	
	private JPanel panelTeclado;
	private JPanel panelTituloCampoDigitacao;
	private JPanel panelCampoDigitacao;
	private JPanel panelLinhaUmTeclado;
	private JPanel panelLinhaDoisTeclado;
	private JPanel panelLinhaTresTeclado;
	private JPanel panelLinhaQuatroTeclado;
	private JPanel panelLinhaCincoTeclado;
	
	private Container container;
	
	public DigitacaoFrame() {
		
		super("Digitação");
		setLayout(new FlowLayout());
		container = getContentPane();
		
		panelTeclado = new JPanel(new GridLayout(5, 1));
		panelTituloCampoDigitacao = new JPanel(new GridLayout(2, 1));
		panelCampoDigitacao = new JPanel(new BorderLayout());
		
		labelInstrucaoDigitacao = new JLabel("Digite alguma coisa usando o teclado. As teclas que você apertar serão destacadas e o texto será exibido.");
		labelNotaInstrucao = new JLabel("Observação: Clicar nos botões do seu mouse não resultaram em nenhuma ação.");
		panelTituloCampoDigitacao.add(labelInstrucaoDigitacao);
		panelTituloCampoDigitacao.add(labelNotaInstrucao);
		
		panelCampoDigitacao.add(panelTituloCampoDigitacao, BorderLayout.NORTH);
		panelCampoDigitacao.setPreferredSize(new Dimension(1300, 300));
		
		campoDigitacao = new JTextArea();
		panelCampoDigitacao.add(campoDigitacao, BorderLayout.CENTER);
		
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
		
		
		
		panelTeclado.add(panelLinhaUmTeclado);
		panelTeclado.add(panelLinhaDoisTeclado);
		panelTeclado.add(panelLinhaTresTeclado);
		panelTeclado.add(panelLinhaQuatroTeclado);
		panelTeclado.add(panelLinhaCincoTeclado);
		
		
		
		add(panelCampoDigitacao);
		add(panelTeclado);
	}
	
}
