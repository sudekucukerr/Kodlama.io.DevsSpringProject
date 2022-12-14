package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
				
	}
	
	
	@PostMapping("/add")
    public void add (@RequestBody CreateLanguageRequest createLanguageRequest, int id) throws Exception {
        programmingLanguageService.add(createLanguageRequest, id);
    }
	
	@PutMapping("/update/{id}")
	public void update (@RequestBody UpdateLanguageRequest updateLanguageRequest, @PathVariable int id) throws Exception {
		programmingLanguageService.update(updateLanguageRequest, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable(name="id") int id) throws Exception {
		programmingLanguageService.delete(id);
	}
	
	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getByid(int id) throws Exception {
		return programmingLanguageService.getById(id);
	}
	
}
