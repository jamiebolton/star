package club.crazypenguin.service.sys.impl;

import club.crazypenguin.dao.BaseDaoI;
import club.crazypenguin.model.Syresource;
import club.crazypenguin.model.Syrole;
import club.crazypenguin.model.Syuser;
import club.crazypenguin.service.impl.BaseServiceImpl;
import club.crazypenguin.service.sys.SyroleServiceI;
import club.crazypenguin.utils.HqlFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * 角色业务实现类
 *
 * @author jamie
 */
@Service
public class SyroleServiceImpl extends BaseServiceImpl<Syrole> implements SyroleServiceI {

    @Autowired
    private BaseDaoI<Syuser> userDao;
    @Autowired
    private BaseDaoI<Syresource> resourceDao;

    @Override
    public List<Syrole> findRoleByFilter(HqlFilter hqlFilter, int page, int rows) {
        String hql = "select distinct t from Syrole t join t.syusers user";
        return find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), page, rows);
    }

    @Override
    public List<Syrole> findRoleByFilter(HqlFilter hqlFilter) {
        String hql = "select distinct t from Syrole t join t.syusers user";
        return find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams());
    }

    @Override
    public Long countRoleByFilter(HqlFilter hqlFilter) {
        String hql = "select count(distinct t) from Syrole t join t.syusers user";
        return count(hql + hqlFilter.getWhereHql(), hqlFilter.getParams());
    }

    @Override
    public void saveRole(Syrole syrole, String userId) {
        save(syrole);

        Syuser user = userDao.getById(Syuser.class, userId);
        user.getSyroles().add(syrole);// 把新添加的角色与当前用户关联
    }

    @Override
    public void grant(String id, String resourceIds) {
        Syrole role = getById(id);
        if (role != null) {
            role.setSyresources(new HashSet<Syresource>());
            for (String resourceId : resourceIds.split(",")) {
                if (!StringUtils.isBlank(resourceId)) {
                    Syresource resource = resourceDao.getById(Syresource.class, resourceId);
                    if (resource != null) {
                        role.getSyresources().add(resource);
                    }
                }
            }
        }
    }

}
