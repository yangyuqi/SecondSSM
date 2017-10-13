package com.second.api.service.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.api.dao.content.ContentDao;
import com.second.api.model.content.Content;

@Service
public class ImpContentService implements ContentServiceImp{

	@Autowired
	ContentDao contentDao;
	
	public Content getContentById(int id) {
		// TODO Auto-generated method stub
		return contentDao.getContentByUserName(id);
	}

	public List<Content> getAllCont(String name) {
		// TODO Auto-generated method stub
		return contentDao.getAllContent(name);
	}

	public boolean addNewContent(String name, String content) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("content", content);
		int result = contentDao.addNewContent(params);
		if (result>0) {
			return true;
		}
		return false;
	}

	public boolean deleteContent(int id) {
		// TODO Auto-generated method stub
		int result = contentDao.deleteContent(id);
		if (result>0) {
			return true ;
		}
		return false;
	}

	public boolean updateContent(int id ,String content) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("content", content);
		int result = contentDao.addNewContent(map);
		if (result>0) {
			return true;
		}
		return false;
	}

	
}
