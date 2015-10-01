package edu.esprit.first.business;

import javax.ejb.Remote;

@Remote
public interface AccumulatorServiceRemote {
	
	int accumulate(int dx);

}
