package org.sang.controller;

import org.sang.bean.Category;
import org.sang.bean.RespBean;
import org.sang.bean.User;
import org.sang.service.CategoryService;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.time.Instant;
import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@RestController
public class LoginRegController {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/login_error")
    public RespBean loginError() {
        return new RespBean("error", "登录失败!");
    }

    @RequestMapping("/login_success")
    public RespBean loginSuccess() {
        return new RespBean("success", "登录成功!");
    }

    /**
     * 如果自动跳转到这个页面，说明用户未登录，返回相应的提示即可
     * <p>
     * 如果要支持表单登录，可以在这个方法中判断请求的类型，进而决定返回JSON还是HTML页面
     *
     * @return
     */
    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }

    @PostMapping("/reg")
    public RespBean reg(User user) {
        int result = userService.reg(user);
        if (result == 0) {
            //成功
            return new RespBean("success", "注册成功!");
        } else if (result == 1) {
            return new RespBean("error", "用户名重复，注册失败!");
        } else {
            //失败
            return new RespBean("error", "注册失败!");
        }
    }

    @RequestMapping("/aaa")
    public RespBean aaa() {
        return new RespBean("success", "123123123!");
    }

    @RequestMapping("/test/ccc")
    public void ccc() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");

        System.out.println("格式化输出：" + sdf.format(d));



        System.out.println(d.getTime()/1000);

        String aa=String.valueOf(d.getTime()/1000) ;
        System.out.println(aa);
        String ccdd="12323";

        System.out.println(ccdd);
    }

    @RequestMapping(value="/test/updatec",method = RequestMethod.PUT)
    public RespBean updatec(Category category){
        System.out.print(category);
//        int i = categoryService.updateCategoryById(category);
//        if (i == 1) {
//            return new RespBean("success", "修改成功!");
//        }
        return new RespBean("error", "修改失败!");
    }

    @RequestMapping(value = "/test/all", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping("/test/updatestatus")
    public RespBean updatestatus(Category category){

        int i = categoryService.updateStatus(category);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
//
        return new RespBean("error", "修改失败!");
    }

    @RequestMapping(value = "/test/updatestatus2",method=RequestMethod.GET)
    public RespBean updatestatus2(@RequestParam("id") long id){
       System.out.println(id);
        int i = categoryService.updateStatus2(id);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
//
        return new RespBean("error", "修改失败!");
    }


}
