package com.second.api.controller.content;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.second.api.config.ResultCode;
import com.second.api.model.JsonResult;
import com.second.api.model.content.Content;
import com.second.api.service.content.ContentServiceImp;

@Controller
@RequestMapping("v1/content/")
public class ContentController {

	@Autowired
	ContentServiceImp serviceImp ;
	
	@RequestMapping("byId")
	@ResponseBody
	public JsonResult getContentById(HttpServletRequest request ,HttpServletResponse response,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		result.setCodeAndMsg(ResultCode.SUCCESS);
		String id =  (String) map.get("id");
		Content content = serviceImp.getContentById(Integer.parseInt(id));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", content.getId());
		data.put("content", content.getContent());
		data.put("userName", content.getUserName());
		result.setData(data);
		return result;
	}
	
	@RequestMapping("allContent")
	@ResponseBody
	public JsonResult getAllContent(HttpServletRequest request ,HttpServletResponse response ,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		result.setCodeAndMsg(ResultCode.SUCCESS);
		List<Content> list = serviceImp.getAllCont((String)map.get("name"));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		result.setData(data);
		return result;
	}
	
	@RequestMapping("addContent")
	@ResponseBody
	public JsonResult addContent(HttpServletRequest request ,HttpServletResponse response ,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		result.setCodeAndMsg(ResultCode.SUCCESS);
		String name = (String)map.get("name");
		String content = (String) map.get("content");
		if (name!=null&&content!=null) {
			boolean isSuccess = serviceImp.addNewContent(name, content);
			if (isSuccess) {
				return result ;
			}
		}else {
			result.setCodeAndMsg(ResultCode.FAILED);
		}
		return result;
	}
	
	@RequestMapping("delete/content")
	@ResponseBody
	public JsonResult deleteContent(HttpServletResponse response ,HttpServletRequest request ,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		String id = (String) map.get("id");
		if (id!=null&&!id.equals("")) {
			boolean isSuccess = serviceImp.deleteContent(Integer.parseInt(id));
			if (isSuccess) {
				result.setCodeAndMsg(ResultCode.SUCCESS);
			}else{
				result.setCodeAndMsg(ResultCode.FAILED);
			}
		}else {
			result.setCodeAndMsg(ResultCode.FAILEDPARAME);
		}
		return result ;
	}
	
	@RequestMapping("update/content")
	@ResponseBody
	public JsonResult updateContent(HttpServletRequest request ,HttpServletResponse response ,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		String id = (String) map.get("id");
		String content = (String) map.get("content");
		if (id!=null) {
			boolean isSuccess = serviceImp.updateContent(Integer.parseInt(id), content);
			if (isSuccess) {
				result.setCodeAndMsg(ResultCode.SUCCESS);
				return result;
			}
		}else {
			result.setCodeAndMsg(ResultCode.FAILEDPARAME);
		}
		return result;
	}
}
