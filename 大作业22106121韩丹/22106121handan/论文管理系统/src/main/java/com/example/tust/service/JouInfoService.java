package com.example.tust.service;

import com.example.tust.entity.JouInfo;
import java.util.Map;

/**
 * (JouInfo)表服务接口
 *
 * @author silences
 */
public interface JouInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(Integer id);

    /**
     * 分页查询
     *
     * @param jouInfo 筛选条件
     * @return 查询结果
     */
    Map<String, Object> queryByPage(JouInfo jouInfo, int pageIndex, int pageSize);

    /**
     * 新增数据
     *
     * @param jouInfo 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(JouInfo jouInfo);

    /**
     * 修改数据
     *
     * @param jouInfo 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(JouInfo jouInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Map<String, Object> deleteById(Integer id);
    
    
    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    Map<String, Object> deletes(String ids);

}
