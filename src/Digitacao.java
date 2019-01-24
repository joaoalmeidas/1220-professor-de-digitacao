
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
	
	
	
	

}
