import java.util.Date;
import java.util.Random;

public abstract class Kort {
	
	private String fornavn;
	private String etternavn;
	private int kode;
	private static int kortnummer;
	private boolean sperretKort; // true - sperret, false - åpent
	protected Date opprettet = new Date();
	Random random = new Random();
	
	Kort(String fornavn, String etternavn, int kode, long kortnummer, boolean sperretKort) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kode = kode;
		Kort.kortnummer = random.nextInt(9999) + 10000;		//Genererer kortnummer på 5 siffer, starter med 1
		this.sperretKort = false;
	}
	
	public String getNavn() {
		return fornavn + " " + etternavn;
	}

	public boolean isSperret() {
		return sperretKort;
	}
	
	public String toString() {
		return "Navn: " + getNavn() + ", kortnummer: " + kortnummer + ", PIN: " + kode + ", sperret kort? " + isSperret(); 
	}
	
	public abstract boolean sjekkPIN(int pin);
	
}
