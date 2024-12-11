package com.example.tust.service;

import com.example.tust.entity.Users;
import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author silences
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @return 查询结果
     */
    Map<String, Object> queryByPage(Users users, int pageIndex, int pageSize);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    Map<String, Object> deleteById(Integer userId);
    
    
    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    Map<String, Object> deletes(String ids);


    Users findUserByUAndP(String username, String password);
}
