package com.example.tust.dao;

import com.example.tust.entity.JouInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (JouInfo)表数据库访问层
 *
 * @author silences
 */
public interface JouInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JouInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param jouInfo 查询条件
     * @return 对象列表
     */
    List<JouInfo> queryAllByLimit(@Param("jouInfo") JouInfo jouInfo, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 统计总行数
     *
     * @param jouInfo 查询条件
     * @return 总行数
     */
    long count(@Param("jouInfo") JouInfo jouInfo);

    /**
     * 新增数据
     *
     * @param jouInfo 实例对象
     * @return 影响行数
     */
    int insert(@Param("jouInfo") JouInfo jouInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<JouInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<JouInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<JouInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<JouInfo> entities);

    /**
     * 修改数据
     *
     * @param jouInfo 实例对象
     * @return 影响行数
     */
    int update(@Param("jouInfo") JouInfo jouInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

