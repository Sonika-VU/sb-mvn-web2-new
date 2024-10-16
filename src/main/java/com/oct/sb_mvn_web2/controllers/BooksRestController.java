package com.oct.sb_mvn_web2.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksRestController {
	Logger LOGGER = Logger.getLogger("com.oct.sb_mvn_web2.controllers.BooksRestController");

	
	Map<Integer, Book> books = new HashMap<>();

	public BooksRestController() {
		books.put(1,  new Book(1, "The Republic", "Plato"));
		books.put(2,  new Book(2, "Sapiens", "Harihar"));
	}
	
//	@GetMapping(value="all", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Map<Integer, Book> getBook(){
//		return books;
//	}
	
	@PostMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> postController2(@RequestBody Book book){
		books.put(book.getId(), book);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Book getBook(@PathVariable int id) {
		return books.get(id);
	}
	
	@DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Book deleteBook(@PathVariable int id) {
		return books.remove(id);
	}
	
	
//	@GetMapping("/hello")
//	public String getGreeting() {
//		return "hello from rest";
//		Logger.info("running getGreeting()");
//	}
//	@GetMapping(value = "/hello_json", produces=MediaType.APPLICATION_JSON_VALUE)
//	public String getGreetingJSON() {
//		return "hello from rest";
//	}
	
	@GetMapping(value = "/hello_json", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<Integer, Book> getBooksJSON() {
		return books;
	}
}
