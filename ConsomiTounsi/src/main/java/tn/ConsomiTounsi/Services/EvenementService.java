package tn.ConsomiTounsi.Services;

import tn.ConsomiTounsi.Entities.Evenement;

public interface EvenementService {

	Evenement addEvenement(Evenement ee);
	void deleteEvenement(int id);
	Evenement updateEvenement(Evenement ee);

}
