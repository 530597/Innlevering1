import java.util.Date;

public class Gjest extends Kort {
	private String navn;
	private int pin;
	private Date opprettet;
	private final long weekInMillis = 604800000;
	private final Date now = new Date();
	
	/* konstrukt�r som ikke tar inn tiden kortet er aktivert */
	public Gjest(String navn, int pin) {
		this.navn = navn;
		this.pin = pin;
		opprettet.setTime(0);
	}
	
	/* konstrukt�r som tar inn tiden kortet ble aktivert */
	public Gjest(String navn, int pin, Date opprettet) {
		this.navn = navn;
		this.pin = pin;
		this.opprettet = opprettet;
	}
	
	public boolean sjekkPIN(int kode) {
		if (opprettet.getTime() != 0) {
			if (opprettet.getTime() > now.getTime() + weekInMillis){
				return false;	//kortet er utg�tt p� tid
			} else if (opprettet.getTime() < now.getTime()) {
				return false;	//kortet er ikke aktivert enda
			}
		}else if (super.isSperret()==true) {
			return false;	//kortet er sperret
		}else if (pin != kode) {
			return false;	//koden er feil
		}else{
		return true;	//ikke utg�tt p� tid, ikke sperret, og riktig kode
		}
	}
	
}
