import java.util.Calendar;

public class Ansatt extends Kort implements Konstanter {
	
	private String fornavn;
	private String etternavn;
	private int pin;
	private Calendar tid; 
	private int faktor;
	private double timelonn;
	private int ansennitet;
	
	public Ansatt(String navn, int pin) {
		this.navn = navn;
		this.pin = pin;
		this.tid = Calendar.getInstance();
	}

	public boolean sjekkPIN(int kode) {
		if (tid.get(Calendar.DAY_OF_WEEK) != SATURDAY || tid.get(Calendar.DAY_OF_WEEK) != SUNDAY && tid.get(Calendar.HOUR_OF_DAY) > 6 || tid.get(Calendar.HOUR_OF_DAY) < 18) {
			return true; 	// innen arbeidstiden, fri adgang
		}else if (super.isSperret()) {
			return false;	//kortet er sperret, ingen tilgang
		} else if (kode == pin) {
				return true;
		}
		return false;
	}
	public void settFaktor(int nyFaktor) { this.faktor = nyFaktor; }
	public void settTimelonn(double nyLonn) { this.timelonn = nyLonn; }
	public void settAnsinnitet(int nyAnsennitet) {this.ansennitet = nyAnsennitet; }
	
	
	public void settFornavn(String navn) { this.fornavn = navn; }
	public String hentFornavn() { return fornavn; }
	
	public void settEtternavn(String navn) { this.etternavn = navn; }
	public String hentEtternavn() { return etternavn; }
	
	public void settFullstNavn(String heltNavn) { 
		String[] navn = heltNavn.split();
		this.fornavn = navn[1];
		this.etternavn = navn[2];
	}
	public String hentFulltNavn() { return fornavn + " " + etternavn; }
	
	public double beregnKreditt() { return faktor * timelonn; }
	public double beregnBonus() { return faktor * ansennitet; }
}
