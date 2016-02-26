import java.util.Date;

public class Gjest extends Kort {
	private String navn;
	private int pin;
	private Date opprettet;
	private final long weekInMillis = 604800000;
	private final Date now = new Date();
	
	/* konstruktør som ikke tar inn tiden kortet er aktivert */
	public Gjest(String navn, int pin) {
		this.navn = navn;
		this.pin = pin;
		opprettet.setTime(0);
	}
	
	/* konstruktør som tar inn tiden kortet ble aktivert */
	public Gjest(String navn, int pin, Date opprettet) {
		this.navn = navn;
		this.pin = pin;
		this.opprettet = opprettet;
	}
	
	public boolean sjekkPIN(int kode) {
		if (opprettet.getTime() != 0) {
			if (opprettet.getTime() > now.getTime() + weekInMillis){
				return false;	//kortet er utgått på tid
			} else if (opprettet.getTime() < now.getTime()) {
				return false;	//kortet er ikke aktivert enda
			}
		}else if (super.isSperret()==true) {
			return false;	//kortet er sperret
		}else if (pin != kode) {
			return false;	//koden er feil
		}else{
		return true;	//ikke utgått på tid, ikke sperret, og riktig kode
		}
	}
	
}
