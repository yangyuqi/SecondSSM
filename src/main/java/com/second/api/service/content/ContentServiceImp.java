package com.second.api.service.content;

import java.util.List;

import com.second.api.model.content.Content;

public interface ContentServiceImp {

	Content getContentById(int id);
	
	List<Content> getAllCont(String name);
	
	boolean addNewContent(String name ,String content);
	
	boolean deleteContent(int id);
	
	boolean updateContent(int id ,String content);
}
