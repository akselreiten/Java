package inheritance;

public class Tegneseriealbum extends Bok {

	public Tegneseriealbum(String tittel) {
		super(tittel);
	}

	private int antallStriper;
	
	public int getAntallStriper() {
		return antallStriper;
	}
	
	public void setAntallStriper(int antallStriper) {
		this.antallStriper = antallStriper;
	}

	@Override
	protected String getSjanger() {
		return "Tegneseriealbum";
	}
}
