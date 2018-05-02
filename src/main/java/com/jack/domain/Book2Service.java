package com.jack.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Book2Service {
	
	@Autowired
	private Book2Repository book2Repository;
	
	/*
	 * 查詢所有的書單列表 
	 */
	public List<Book2> findAll(){		
		
		return book2Repository.findAll();		
	}
	
	/*
	 * 提交一個書單 ( 可以新增、 也可以更新)
	 * 包含ID就是更新
	 */
	public Book2 save(Book2 book2) {
		return book2Repository.save(book2);
	}
	
	/*
	 * 獲取一本書
	 */
	public Book2 findById(long id) {
		
		return book2Repository.findById(id).orElse(new Book2());	//找不到時返回空書	
	}
	
	public void delestById(long id) {
		book2Repository.deleteById(id);
	}
	
}
