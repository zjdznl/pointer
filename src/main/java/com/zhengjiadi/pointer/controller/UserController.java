package com.zhengjiadi.pointer.controller;




import com.zhengjiadi.pointer.service.UserService;
import com.zhengjiadi.pointer.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhengjiadi
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //根据 uid 获得用户信息
//    @GetMapping("/info")
//    public BaseJson getUserMeg(@RequestParam("id") int id) {
//        BaseJson baseJson =  userService.getUserMsg( id );
//        return baseJson;
//    }
    // todo
    //注册用户
//    @PostMapping("/register")
//    public BaseJson userRegister(@RequestParam("password") String mail, @RequestParam("phone") String password, @RequestParam("code") String code) {
//        return userService.register(mail, password, code);
//    }

    @GetMapping("/code")
    public BaseJson getMessageCode(@RequestParam("phone") String phone) {
//        return ResponseEntity.ok("fuckyou");
        return userService.getMessageCode(phone);
    }

//    // 获取验证码
//    ResponseEntity<String> getMessageCode(String phone);
//
//    // 登录
//    ResponseEntity<JSONPObject> login(String phone, String password);

//    //验证码
//    @GetMapping("/register/code")
//    public BaseJson getVerifyCode(@RequestParam("phone") String phone) {
//        return userService.validatePhone( phone );
//    }
//
//    //用户登录
//    @Logged({"account", "password"})
//    @PostMapping("/login")
//    public BaseJson userLogin(@RequestParam("account") String account, @RequestParam("password") String password) {
//        return userService.userLogin( account, password );
//    }
//
//    @Logged({"userID", "newPassword", "oldPassword"})
//    @PostMapping("/update/password")
//    public BaseJson updateUserPassword(@RequestParam("id") int userID,
//                                       @RequestParam("oldPassword") String oldPassword,
//                                       @RequestParam("newPassword") String newPassword) {
//        return userService.updateUserPassword( userID, oldPassword, newPassword );
//    }
//    //更新密码
//    @PostMapping("/updata/email")
//    public BaseJson updateUserPassword(@RequestParam("id") int userId, @RequestParam("email") String email) {
//        return userService.setUserEmail( userId, email );
//    }
}
