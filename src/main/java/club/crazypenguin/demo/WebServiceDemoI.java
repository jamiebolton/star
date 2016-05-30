package club.crazypenguin.demo;

import club.crazypenguin.model.Syuser;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * WebService接口定义
 * 
 * @author jamie
 * 
 */
@WebService
public interface WebServiceDemoI {

	public String helloWs(@WebParam(name = "userName") String name);

	public Syuser getUser(@WebParam(name = "userId") String id);

}
