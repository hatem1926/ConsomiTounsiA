package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Don;
import tn.ConsomiTounsi.Entities.Likes;

public interface DonService {

	Don addDon(Don dd) ;
	void deletDon(int id);
	Don updateDon(Don dd);
	List<Don>getAllPub();


}
