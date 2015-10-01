package edu.esprit.first.business;

import javax.ejb.Stateless;

@Stateless
public class CalculatorService implements CalculatorServiceRemote, CalculatorServiceLocal{

	
	
	
	public CalculatorService() {
	}

	public int sum(int x, int y) {
		return x+y;
	}
	
	
}
