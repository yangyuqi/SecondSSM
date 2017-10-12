package com.second.api.controller.user;

import java.util.HashMap;
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
import com.second.api.model.user.User;
import com.second.api.service.user.UserServiceImp;

@Controller
@RequestMapping("v1/user/")
public class UserControlller {

	@Autowired
	UserServiceImp UserServiceImp ;
	
	@RequestMapping("info/mobile")
	@ResponseBody
	public JsonResult getUserInfo(HttpServletRequest request ,HttpServletResponse response ,@RequestBody Map<String, Object> map){
		JsonResult result = new JsonResult();
		result.setCodeAndMsg(ResultCode.SUCCESS);
		User user = new User();
		String name = (String) map.get("name");
		user = UserServiceImp.getUserInfo(name);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", user.getId());
		data.put("name", user.getName());
		data.put("mobile", user.getMobile());
		result.setData(data);
		return result;
	}
}
