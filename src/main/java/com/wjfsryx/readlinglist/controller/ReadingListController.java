package com.wjfsryx.readlinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wjfsryx.readlinglist.entity.Book;
import com.wjfsryx.readlinglist.repository.BookRepository;


@Controller
@RequestMapping("/")
public class ReadingListController {

	private BookRepository bookRepository;
	
	@Autowired
	public ReadingListController(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model){
		List<Book> books = bookRepository.findByReader(reader);
		if(books != null){
			model.addAttribute("books", books);
		}
		return "readingList";
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToBookList(@PathVariable("reader") String reader, Book book){
		book.setReader(reader);
		bookRepository.save(book);
		return "redirect:/{reader}";
	}
	
}
