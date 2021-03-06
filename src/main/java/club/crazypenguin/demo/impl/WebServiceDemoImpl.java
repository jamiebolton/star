package club.crazypenguin.demo.impl;

import javax.jws.WebService;

import club.crazypenguin.demo.WebServiceDemoI;
import club.crazypenguin.model.Syuser;
import club.crazypenguin.service.sys.SyuserServiceI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * WebService接口实现类
 * 
 * @author jamie
 * 
 */
@WebService(endpointInterface = "club.crazypenguin.demo.WebServiceDemoI", serviceName = "webServiceDemo")
public class WebServiceDemoImpl implements WebServiceDemoI {

	@Autowired
	private SyuserServiceI userService;

	@Override
	public String helloWs(String name) {
		if (StringUtils.isBlank(name)) {
			name = "SunYu";
		}
		String str = "hello[" + name.trim() + "]WebService test ok!";
		System.out.println(str);
		return str;
	}

	@Override
	public Syuser getUser(String id) {
		if (StringUtils.isBlank(id)) {
			id = "0";
		}
		Syuser user = userService.getById(id.trim());
		Syuser u = new Syuser();
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setCreatedatetime(user.getCreatedatetime());
		u.setUpdatedatetime(user.getUpdatedatetime());
		u.setId(user.getId());
		u.setLoginname(user.getLoginname());
		u.setSex(user.getSex());
		u.setPhoto(user.getPhoto());
		return u;
	}

}
