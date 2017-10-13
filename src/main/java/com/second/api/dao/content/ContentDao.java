package com.second.api.dao.content;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.second.api.model.content.Content;

public interface ContentDao {
	Content getContentByUserName(@Param("id")int id);
	List<Content> getAllContent(@Param("name")String name);
	int addNewContent(Map<String, Object> map);
	int deleteContent(@Param("id")int id);
	int updateContent(Map<String, Object> map);
}
