package cn.cwnu.cs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.cwnu.cs.bean.User;
import cn.cwnu.cs.util.FreeMarkerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private List<User> list = new ArrayList<User>();

	public String list() {
		list.add(new User("use1", "pass1"));
		list.add(new User("use2", "pass2"));
		list.add(new User("use3", "pass3"));
		list.add(new User("use4", "pass4"));
		list.add(new User("use5", "pass5"));
		list.add(new User("use6", "pass6"));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("list", list);
		String ftlPath = "user.ftl";
		String htmlPath = "user.html";
		FreeMarkerUtil.createHtml(ServletActionContext.getServletContext(),
				root, ftlPath, htmlPath);
		return SUCCESS;
	}
}
