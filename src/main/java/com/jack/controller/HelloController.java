package com.jack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.domain.Book;

@Controller    //訪問頁面用Controller
//@RestController
@RequestMapping("/api/v1")  //servlet context path 可於properties 自訂義
public class HelloController {	
	
	
	@Autowired
	private Book book;
	
	
//	@RequestMapping(value = "/say", method= RequestMethod.GET)
	@GetMapping("/say")
	public Object hello() {
		
		return "books";
	}	
	
	
	
	
	@GetMapping("/books")
//	@ResponseBody
	public Object getAll(@RequestParam int page, @RequestParam(value="size", defaultValue="10") int size) {
		
		Map<String, Object> book = new HashMap<>();
		book.put("name", "name");
		book.put("isbn", "isbn");
		book.put("author", "author");
		Map<String, Object> book2 = new HashMap<>();
		book2.put("name", "金庸全套");
		book2.put("isbn", "213165498");
		book2.put("author", "金庸");
		
		List<Map> contents = new ArrayList<>();
		contents.add(book);
		contents.add(book2);
		
		Map<String, Object> pagemap = new HashMap<>();
		pagemap.put("page", page);
		pagemap.put("size", size);
		pagemap.put("contents", contents);
		
		return pagemap;
	}
	
	/*
	 * 正則表達式:{參數名:正則表達式}
	 * @param id
	 * @param username
	 * @return	  
	 */
	@GetMapping("/books/{id}/{username:[a-z_]+}")
	public Object getOneAndUsername(@PathVariable long id, @PathVariable(value = "username") String username) {
		
		System.out.println("id--------" + id);
		System.out.println("username--------" + username);
		
		Map<String, Object> book = new HashMap<>();
		book.put("name", "天觀雙俠");
		book.put("isbn", "213165498");
		book.put("author", "許峻榕");
		book.put("username", username);
		
		return book;
	}
	
	@GetMapping("/books/{id}")
	public Object getOne(@PathVariable long id) {
		
		System.out.println("id--------" + id);		
		
		return book;
	}
	
	@PostMapping("/books")
	public Object post(@RequestParam("name") String name,
					   @RequestParam String author,
					   @RequestParam String isbn,
					   @RequestParam(value = "size", defaultValue = "10") String size) {
		
		Map<String, Object> book = new HashMap<String, Object>();
		book.put("name", name);
		book.put("author", author);
		book.put("isbn", isbn);
		book.put("size", size);
		
		return book;
	}
	
	
}
