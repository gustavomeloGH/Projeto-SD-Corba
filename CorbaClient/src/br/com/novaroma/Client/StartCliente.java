package br.com.novaroma.Client;

import javax.swing.JOptionPane;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import br.com.novaroma.ReverseApp.Reverse;
import br.com.novaroma.ReverseApp.ReverseHelper;

public class StartCliente {
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Reverse reverseObj = (Reverse) ReverseHelper.narrow(ncRef.resolve_str("ABC"));

			while (true) {
				String phrase = JOptionPane.showInputDialog("Welcome to the Reverse system:\nEnter a phrase to be reversed: ");

				if (phrase != null) {
					String reversePhrase = reverseObj.reverse(phrase);
					JOptionPane.showMessageDialog(null, ("The inverted phrase result is :\n " + reversePhrase));
				} else {
					break;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ("ERROR: " + e));
			e.printStackTrace();
		}
	}
}
