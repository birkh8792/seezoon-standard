package com.seezoon.interfaces.sys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seezoon.application.sys.UserApplicationService;
import com.seezoon.application.sys.dto.AddUserCmd;
import com.seezoon.application.sys.dto.ModifyUserMobileCmd;
import com.seezoon.application.sys.dto.QryUserById;
import com.seezoon.application.sys.dto.QryUserPage;
import com.seezoon.application.sys.dto.clientobject.UserCO;
import com.seezoon.ddd.dto.Page;
import com.seezoon.ddd.dto.Response;

import lombok.RequiredArgsConstructor;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
public class SysUserController {

    private final UserApplicationService userApplicationService;

    @PostMapping("/add_user")
    public Response addUser(@RequestBody AddUserCmd cmd) {
        return userApplicationService.addUser(cmd);
    }

    /**
     * 通过id查询用户
     *
     * @param id 用户id 可以遵循restful 风格，也可以统一使用http+json 方式接收参数
     * @return
     */
    @GetMapping("/qry/{id}")
    public Response<UserCO> qryUserById(@PathVariable Integer id) {
        QryUserById qry = new QryUserById(id);
        return userApplicationService.qryUserById(qry);
    }

    /**
     * 修改用户手机号
     *
     * @param cmd
     * @return
     */
    @PostMapping("/modify_user_mobile")
    public Response modifyUserMobile(@RequestBody ModifyUserMobileCmd cmd) {
        return this.userApplicationService.modifyUserMobile(cmd);
    }

    /**
     * 分页查询
     *
     * @param qry
     * @return
     */
    @PostMapping("/qry_user_page")
    public Response<Page<UserCO>> qryUserPage(@RequestBody QryUserPage qry) {
        return this.userApplicationService.qryUserPage(qry);
    }

}
