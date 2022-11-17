package kodlama.io.Devs.business.requests.create;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnologyRequest {
	
	private String name;
	private ProgrammingLanguage language;

}
