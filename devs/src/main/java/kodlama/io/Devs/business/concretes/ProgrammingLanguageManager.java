package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	List<ProgrammingLanguage> language;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository)
	{
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.findAll();
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest, int id) throws Exception {
       
       if(isNameExist(createLanguageRequest.getName())) {
    	   
    	   throw new Exception("This name is already exist.");
    	   
       }
       
       	createLanguageRequest.setName(createLanguageRequest.getName());
       	
    } 
	

	
	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		}
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		
		for(ProgrammingLanguage language: languages) {
			if(language.getId() == id)
				return language;
		}
		
		return null;
	}	

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		}
		programmingLanguageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		} 
		 if(isNameExist(updateLanguageRequest.getName())) {
	    	   
	    	   throw new Exception("This name is already exist.");
	    	   
	       }
		 
		ProgrammingLanguage language = getById(updateLanguageRequest.getId());
		
	}
	
	private boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguage : getAll()) {
			if(programmingLanguage.getId() == id ) {
				return true;
			}
		}
		return false;
		
	}
	
	private boolean isNameExist(String name) throws Exception {
        for(ProgrammingLanguage programmingLanguage : getAll()) {
            if(programmingLanguage.getName().equals(name) ) {
                return true;
            }
           
        }
        if(name.isEmpty()) {
            throw new Exception("You have to write a name");  
            
        }

        return false;
    }


	

}
