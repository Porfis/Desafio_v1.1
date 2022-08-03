package lecom.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello-word")
	public ResponseEntity<String> get(){
		return ResponseEntity.ok("Hello word");
	}		

}
