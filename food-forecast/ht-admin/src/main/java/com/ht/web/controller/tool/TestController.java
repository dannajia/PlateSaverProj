package com.ht.web.controller.tool;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.R;
import com.ht.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * swagger TestController
 * 
 * @author DJ
 */
@Api("TestController")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController
{
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();
    {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ht", "admin123", "15666666666"));
    }

    @ApiOperation("getUserList")
    @GetMapping("/list")
    public R<List<UserEntity>> userList()
    {
        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
        return R.ok(userList);
    }

    @ApiOperation("getUser")
    @ApiImplicitParam(name = "userId", value = "userID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping("/{userId}")
    public R<UserEntity> getUser(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            return R.ok(users.get(userId));
        }
        else
        {
            return R.fail("the user doesn't exist");
        }
    }

    @ApiOperation("save")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "userId", dataType = "Integer", dataTypeClass = Integer.class),
        @ApiImplicitParam(name = "username", value = "userName", dataType = "String", dataTypeClass = String.class),
        @ApiImplicitParam(name = "password", value = "userPassword", dataType = "String", dataTypeClass = String.class),
        @ApiImplicitParam(name = "mobile", value = "userMobile", dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/save")
    public R<String> save(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return R.fail("userID can't be null");
        }
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @ApiOperation("update")
    @PutMapping("/update")
    public R<String> update(@RequestBody UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return R.fail("userID can't be null");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId()))
        {
            return R.fail("user doesn't exist");
        }
        users.remove(user.getUserId());
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @ApiOperation("delete")
    @ApiImplicitParam(name = "userId", value = "userID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @DeleteMapping("/{userId}")
    public R<String> delete(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            users.remove(userId);
            return R.ok();
        }
        else
        {
            return R.fail("user doesn't exist");
        }
    }
}

@ApiModel(value = "UserEntity", description = "User Entity")
class UserEntity
{
    @ApiModelProperty("userID")
    private Integer userId;

    @ApiModelProperty("userName")
    private String username;

    @ApiModelProperty("userPassword")
    private String password;

    @ApiModelProperty("userMobile")
    private String mobile;

    public UserEntity()
    {

    }

    public UserEntity(Integer userId, String username, String password, String mobile)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
}
