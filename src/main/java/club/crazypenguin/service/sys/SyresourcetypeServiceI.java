package club.crazypenguin.service.sys;

import club.crazypenguin.model.Syresourcetype;
import club.crazypenguin.service.BaseServiceI;

import java.util.List;

/**
 * 资源类型接口
 * 
 * @author jamie
 * 
 */
public interface SyresourcetypeServiceI extends BaseServiceI<Syresourcetype> {

	/**
	 * 获取所有资源类型
	 */
	public List<Syresourcetype> findResourcetype();

}
