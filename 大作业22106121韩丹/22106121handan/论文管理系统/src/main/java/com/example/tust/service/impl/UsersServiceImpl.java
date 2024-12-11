package com.example.tust.service.impl;

import com.example.tust.entity.Users;
import com.example.tust.dao.UsersDao;
import com.example.tust.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;

/**
 * (Users)表服务实现类
 *
 * @author silences
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> queryById(Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", usersDao.queryById(userId));
        map.put("msg", "查询成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @return 查询结果
     */
    @Override
    public Map<String, Object> queryByPage(Users users, int pageIndex, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        long total = usersDao.count(users);
        
        map.put("data", usersDao.queryAllByLimit(users, (pageIndex-1)*pageSize, pageSize));
        map.put("count", total);
        map.put("msg", "查询成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();
        usersDao.insert(users);
        map.put("msg", "插入成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();
        usersDao.update(users);
        map.put("msg", "修改成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deleteById(Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        usersDao.deleteById(userId);
        map.put("msg", "删除成功！");
        map.put("code", "0000");
        return map;
    }
    
    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deletes(String ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] idarr = ids.substring(0, ids.length() - 1).split(",");
        for(int i = 0;i < idarr.length;i++) {
            deleteById(Integer.parseInt(idarr[i]));
        }
        map.put("msg", "批量删除成功！");
        map.put("code", "0000");
        return map;
    }

    @Override
    public Users findUserByUAndP(String username, String password) {
        Users user = usersDao.findUserByUAndP(username, password);
        return user;
    }
}
