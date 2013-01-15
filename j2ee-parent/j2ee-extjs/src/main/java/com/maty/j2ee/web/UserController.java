package com.maty.j2ee.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maty.j2ee.entity.ext.ExtReturn;

/**
 * F
 * 
 * @author Maty Chen
 * @date 2013-1-15下午3:38:12
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	/**
	 * 演示自行绑定表单中的checkBox roleList到对象中.
	 */
	@RequiresPermissions("user:view")
	@RequestMapping(value = "all/{path}", method = RequestMethod.GET)
	public String update(@PathVariable String path,RedirectAttributes redirectAttributes) {
		return "userList";
	}
	@RequiresPermissions("user:update")
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public String view(RedirectAttributes redirectAttributes) {
		return "userList";
	}
	@RequiresPermissions("user:edit")
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(RedirectAttributes redirectAttributes) {
		return "userList";
	}
	@RequiresPermissions("user:all")
	@RequestMapping(value = "alls", method = RequestMethod.GET)
	@ResponseBody
	public Object all(RedirectAttributes redirectAttributes) {
		return new ExtReturn("test");
	}

}
