package edu.esprit.first.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.first.business.CalculatorServiceRemote;



public class Application {
	
	
	
	
	public static void main(String[] args) throws NamingException {
		CalculatorServiceRemote proxy = null;
		Context ctx = new InitialContext();
		proxy = (CalculatorServiceRemote) ctx.lookup("/first-ejb/CalculatorService!edu.esprit.first.business.CalculatorServiceRemote");
		int z = proxy.sum(1,20);
		System.out.println(z);
	}

}
