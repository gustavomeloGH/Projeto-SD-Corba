package br.com.novaroma.Server;
import br.com.novaroma.ReverseApp.*;
import org.omg.CORBA.*;

public class ReverseObj extends ReversePOA {
	 
	private ORB orb;
	 
	  public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
	
	  @Override
	  public String reverse(String phrase) {
		  return new StringBuilder(phrase).reverse().toString();
	  }

}
