package objectstructures;

public class Partner2 {

	String name; 
	Partner2 currentPartner, oldPartner; 
	public Partner2(String name){
		this.name = name; 
	}
	
	public String getName(){
		return name;
	}
	
	public Partner2 getPartner(){
		return currentPartner; 
	}
	
	public void setPartner(Partner2 newPartner){
		//Dersom den nye partneren er currentPartner, ikke gjør noe.
		if (newPartner == currentPartner){
			return; 
		} else if(newPartner==null){
			oldPartner = currentPartner; 
			currentPartner = null; 
		}
		
		else {
			oldPartner = currentPartner; //Sett nåværende partner til å bli gammel partner. 
			currentPartner = newPartner; //Oppdater nåværende partner til å bli ny partner.
			newPartner.setPartner(this); //Oppdater nåværende partners partner til å bli dette objektet.
			
			if (oldPartner != null && oldPartner.getPartner() == this){
				oldPartner.setPartner(null); //Dersom gammel partners partner var dette objektet, sett det til null. 
			}
		}
		
	}
	
	@Override
	public String toString(){
		if (currentPartner==null){
			return getName() + " has no partner.";
		}
		return getName() + " er sammen med " + currentPartner.getName();
	}
	
	/*public static void main(String[] args) {
		Partner halvor = new Partner("Halvor");
		Partner marie = new Partner("Marie");
		Partner jeanett = new Partner("Jeanett");
		
		halvor.setPartner(marie);
		
		System.out.println(halvor.getPartner().getName());
		
		halvor.setPartner(jeanett);
		System.out.println(halvor.getPartner().getName());
		System.out.println(jeanett.getPartner().getName());
		
	}
	*/
}
