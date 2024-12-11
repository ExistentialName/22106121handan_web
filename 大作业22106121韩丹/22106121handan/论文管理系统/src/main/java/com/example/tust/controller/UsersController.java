package com.example.tust.controller;

import com.example.tust.entity.Users;
import com.example.tust.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import javax.annotation.Resource;

/**
 * (Users)表控制层
 *
 * @author silences
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @return 查询结果
     */
    @GetMapping("/getUserss")
    public ResponseEntity<Map<String, Object>> queryByPage(Users users, int pageIndex, int pageSize) {
        return ResponseEntity.ok(usersService.queryByPage(users, pageIndex, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getUsersById/{id}")
    public ResponseEntity<Map<String, Object>> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping("/addUsers")
    public ResponseEntity<Map<String, Object>> add(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.insert(users));
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PostMapping("/editUsers")
    public ResponseEntity<Map<String, Object>> edit(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usersService.deleteById(id));
    }
    
    /**
     * 批量删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteUserss/{ids}")
    public ResponseEntity<Map<String, Object>> deletes(@PathVariable("ids") String ids) {
        return ResponseEntity.ok(usersService.deletes(ids));
    }

}

