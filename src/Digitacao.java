
public class Digitacao {
	
	private static final String[] pangramas = {"Bancos fúteis pagavam-lhe queijo, whisky e xadrez",
											   "Jovem craque belga prediz falhas no xote",
											   "Um pequeno jabuti xereta viu dez cegonhas felizes",
											   "Gazeta publica hoje breve nota de faxina na quermesse",
											   "Juiz faz com que whisky de malte baixe logo preço de venda",
											   "Zebras caolhas de Java querem mandar fax para moça gigante de New York",
											   "Jovem ex-quenga picha frase da Blitz",
											   "Blitz prende ex-vesgo com cheque fajuto",
											   "The quick brown fox jumps over the lazy dog",
											   "Sphinx of black quartz, judge my vow"};
	
	private final static String[] nomeTeclas = {"'", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
			"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "´", "[", "Enter",
			"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç", "~", "]", "Enter2",
			"Shift", "\\", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ":", "/", "ShiftDir",
			"Ctrl", "cmd", "Alt", "Espaço", "Alt", "cmd", "MsD", "Ctrl"};
	
	private int acertos;
	private int[] errosPorTecla = new int[64];
	
	
	public int getAcertos() {
		return acertos;
	}
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}
	public int[] getErrosPorTecla() {
		return errosPorTecla;
	}
	public void setErrosPorTecla(int[] errosPorTecla) {
		this.errosPorTecla = errosPorTecla;
	}
	public static String[] getPangramas() {
		return pangramas;
	}
	
	@Override
	public String toString() {
		
		String erros = "";
		
		for(int i = 0; i < errosPorTecla.length; i++) {
			
			if(errosPorTecla[i] != 0) {
				
				erros += String.format("%d - %s%n", errosPorTecla[i], nomeTeclas[i]);
				
			}
			
		}
		
		return (String.format("Acertos: %d%nErros:%n%s", getAcertos(), erros));
		
	}
	
	
	
	

}
