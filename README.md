# API Rest - Countries and Cities

## API REST
* **https://documenter.getpostman.com/view/1134062/T1LJjU52#dd5bd0d9-2602-4161-8c77-3af30cd2f41a**

## Paths - Endpoints

```
Primero ejecutar getCountries() para luego filtrar el país enviando el codigo ISO2 o ISO 3

GET:

http://localhost:8080/countries
http://localhost:8080/country
http://localhost:8080/country/ec
http://localhost:8080/country/ecu

http://localhost:8080/cities - Example

```
## Código ISO 2 & 3 - Paises
* **https://www.datosmundial.com/codigos-de-pais.php**
* **https://www.sanidad.gob.es/ciudadanos/saludAmbLaboral/docs/codigoIsoPai.pdf**

## Tutorial
* **https://www.youtube.com/watch?v=fQxCuSpc3PY**


## API Rest con Spring Boot
* **https://blog.codmind.com/mi-primer-api-rest-con-spring-boot/**

```
package com.example.demo.Controlller;

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

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	
	@GetMapping("/persons")
	public List<Person> allPersons(){
		return repository.findAll();
	}
	
	@GetMapping("/person/{name}")
	public List<Person> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
	
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		return repository.save(person);
	}
	
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable int id ,@RequestBody Person person) {
		return repository.save(person);
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}

```




