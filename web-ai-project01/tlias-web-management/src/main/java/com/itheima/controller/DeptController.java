package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*
     * 查询部门列表
     * */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET) //method:指定请求方式

    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }


    /*
     * 删除部门 - 方式1:HttpServletRequest 获取请求参数
     * */
/*
    @DeleteMapping("/depts")
    public Result delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        System.out.println("根据Id删除部门:" + id);
        return Result.success();
    }
*/

    /*
    * 删除部门 - 方式2:@RequestParam
    * 注意事项:一旦声明了@RequestParam,该参数在请求时必须传递,如果不传递将会报错 (默认required为true)
    * */
/*
    @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId) {
        System.out.println("根据Id删除部门:" + deptId);
        return Result.success();
    }
*/


    /*
     * 删除部门 - 方式3:省略@RequestParam
     * 注意事项:一旦声明了@RequestParam,该参数在请求时必须传递,如果不传递将会报错 (默认required为true)
     * */
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("根据Id删除部门:" + id);
        deptService.deleteById(id);
        return Result.success();
    }

}
