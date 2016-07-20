package cn.os.gtmap.web;

import cn.os.gtmap.entity.UserInfo;
import com.jfinal.core.Controller;

/**
 * Author: <a href="mailto:yingxiufeng@gtmap.cn">yingxiufeng</a>
 * Date:  2016/7/20 11:20
 */
public class IndexController extends Controller {

    public void index() {
        render("login.ftl");
    }

    public void login(){
//        UserInfo.dao.find("select * from user_info where loginname= ? and passwd=?",getP);
    }

}
