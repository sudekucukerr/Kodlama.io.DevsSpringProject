package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id) throws Exception;
	
	void add(CreateLanguageRequest createLanguageRequest, int id) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception;
	void delete(int id) throws Exception;

	
}
