package club.crazypenguin.action.sys;

import club.crazypenguin.action.BaseAction;
import club.crazypenguin.model.Syonline;
import club.crazypenguin.service.sys.SyonlineServiceI;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 上线用户
 * 
 * @author jamie
 * 
 */
@Namespace("/base")
@Action
public class SyonlineAction extends BaseAction<Syonline> {

	/**
	 * 注入业务逻辑，使当前action调用service.xxx的时候，直接是调用基础业务逻辑
	 * 
	 * 如果想调用自己特有的服务方法时，请使用((TServiceI) service).methodName()这种形式强转类型调用
	 * 
	 * @param service
	 */
	@Autowired
	public void setService(SyonlineServiceI service) {
		this.service = service;
	}

}
