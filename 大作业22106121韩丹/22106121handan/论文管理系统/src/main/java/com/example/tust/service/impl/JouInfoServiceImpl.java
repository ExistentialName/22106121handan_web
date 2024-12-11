package com.example.tust.service.impl;

import com.example.tust.entity.JouInfo;
import com.example.tust.dao.JouInfoDao;
import com.example.tust.service.JouInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;

/**
 * (JouInfo)表服务实现类
 *
 * @author silences
 */
@Service("jouInfoService")
public class JouInfoServiceImpl implements JouInfoService {
    @Resource
    private JouInfoDao jouInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> queryById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", jouInfoDao.queryById(id));
        map.put("msg", "查询成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 分页查询
     *
     * @param jouInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public Map<String, Object> queryByPage(JouInfo jouInfo, int pageIndex, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        long total = jouInfoDao.count(jouInfo);
        
        map.put("data", jouInfoDao.queryAllByLimit(jouInfo, (pageIndex-1)*pageSize, pageSize));
        map.put("count", total);
        map.put("msg", "查询成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 新增数据
     *
     * @param jouInfo 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(JouInfo jouInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        jouInfoDao.insert(jouInfo);
        map.put("msg", "插入成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 修改数据
     *
     * @param jouInfo 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(JouInfo jouInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        jouInfoDao.update(jouInfo);
        map.put("msg", "修改成功！");
        map.put("code", "0000");
        return map;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deleteById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        jouInfoDao.deleteById(id);
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
}
