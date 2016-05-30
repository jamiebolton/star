package club.crazypenguin.service.sys.impl;

import java.util.List;

import club.crazypenguin.model.Syresourcetype;
import club.crazypenguin.service.impl.BaseServiceImpl;
import club.crazypenguin.service.sys.SyresourcetypeServiceI;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * 资源类型实现类
 *
 * @author jamie
 */
@Service
public class SyresourcetypeServiceImpl extends BaseServiceImpl<Syresourcetype> implements SyresourcetypeServiceI {

    /**
     * 为列表添加了缓存，查询一次过后，只要不重启服务，缓存一直存在，不需要再查询数据库了，节省了一些资源
     * <p/>
     * 在ehcache.xml里面需要有对应的value
     * <p/>
     * <cache name="SyresourcetypeServiceCache"
     * <p/>
     * key是自己设定的一个ID，用来标识缓存
     */
    @Override
    @Cacheable(value = "SyresourcetypeServiceCache", key = "'SyresourcetypeList'")
    public List<Syresourcetype> findResourcetype() {
        return find();
    }

}
