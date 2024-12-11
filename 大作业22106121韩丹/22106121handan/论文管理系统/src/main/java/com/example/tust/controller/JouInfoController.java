package com.example.tust.controller;

import com.example.tust.entity.JouInfo;
import com.example.tust.service.JouInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import javax.annotation.Resource;

/**
 * (JouInfo)表控制层
 *
 * @author silences
 */
@RestController
@RequestMapping("/jouInfo")
public class JouInfoController {
    /**
     * 服务对象
     */
    @Resource
    private JouInfoService jouInfoService;

    /**
     * 分页查询
     *
     * @param jouInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/getJouInfos")
    public ResponseEntity<Map<String, Object>> queryByPage(JouInfo jouInfo, int pageIndex, int pageSize) {
        return ResponseEntity.ok(jouInfoService.queryByPage(jouInfo, pageIndex, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getJouInfoById/{id}")
    public ResponseEntity<Map<String, Object>> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(jouInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param jouInfo 实体
     * @return 新增结果
     */
    @PostMapping("/addJouInfo")
    public ResponseEntity<Map<String, Object>> add(@RequestBody JouInfo jouInfo) {
        return ResponseEntity.ok(jouInfoService.insert(jouInfo));
    }

    /**
     * 编辑数据
     *
     * @param jouInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/editJouInfo")
    public ResponseEntity<Map<String, Object>> edit(@RequestBody JouInfo jouInfo) {
        return ResponseEntity.ok(jouInfoService.update(jouInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteJouInfo/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(jouInfoService.deleteById(id));
    }
    
    /**
     * 批量删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteJouInfos/{ids}")
    public ResponseEntity<Map<String, Object>> deletes(@PathVariable("ids") String ids) {
        return ResponseEntity.ok(jouInfoService.deletes(ids));
    }

}

