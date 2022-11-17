package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.delete.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyService {
	
	List<GetAllTechnologyResponse> getAll();
	
	void add(CreateTechnologyRequest technology) ;
	void delete(DeleteTechnologyRequest technology);
	void update(int id, UpdateTechnologyRequest technology) ;

	
	Technology getById(int id) throws Exception;
}
