package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jack.domain.Book2;
import com.jack.domain.Book2Service;

@RestController
@RequestMapping("api/v2")
public class Book2App {
	
	@Autowired
	private Book2Service book2Service;
	
	
	/*
	 * 獲取讀書清單列表
	 */
	@GetMapping("/books")
	public List<Book2> getAll(){		
		
		return book2Service.findAll();
	}
	
	/*
	 * 新增一筆書
	 */
	@PostMapping("/books")
	public Book2 post(Book2 book) {		
		return book2Service.save(book);
	}
	
	/*
	 * 獲取一本書
	 */
	@GetMapping("/books/{id}")
	public Book2 getOne(@PathVariable long id) {
		return (Book2) book2Service.findById(id);
	}
	
	/*
	 * 更新一個書單
	 */
	@PutMapping("/books")
	public Book2 update(@RequestParam long id,
						@RequestParam String name,
			  			@RequestParam String author,
			  			@RequestParam String description,
			  			@RequestParam int status) {
		Book2 book = new Book2();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setDescription(description);
		book.setStatus(status);
		
		return book2Service.save(book);		
	}
	
	/*
	 * 刪除一個書單
	 */
	@DeleteMapping("books/{id}")
	public void deleteOne(@PathVariable long id) {
		book2Service.delestById(id);
	}
}
