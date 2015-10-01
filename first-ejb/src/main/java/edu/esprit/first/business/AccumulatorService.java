package edu.esprit.first.business;

import javax.ejb.Stateless;

@Stateless
public class AccumulatorService implements AccumulatorServiceRemote {

	private int x;
	
	
    public AccumulatorService() {
    }
    
    public int accumulate(int dx) {
    	x=x+dx;
    	return x;
    }

}
