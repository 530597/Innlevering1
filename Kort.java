import java.util.Date;
import java.util.Random;

public abstract class Kort implements Comparable<Kort> implements Cloneable {
	
	private String fornavn;
	private String etternavn;
	private int kode;
	private long kortnummer;
	private boolean sperretKort; // true - sperret, false - åpent
	protected Date opprettet = new Date();
	Random random = new Random();
	
	public Kort(String fornavn, String etternavn, int kode, long kortnummer, boolean sperretKort) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kode = kode;
		this.kortnummer = random.nextInt(9999) + 10000;
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
	
	public abstract boolean sjekkPIN(int kode);
	
	public int compareTo(Kort k) {
		String[] navn2 = k.getNavn().split();
		String[] navn1 = getNavn().split();
		int temp = navn1[1].compareTo(navn2[2]);
		if(temp == 0) {
			temp = navn1[2].compareTo(navn2[2]);
		}
		return temp;
	}
	
}
