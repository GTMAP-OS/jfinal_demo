package cn.os.gtmap.web;

import com.jfinal.core.Controller;

/**
 * Author: <a href="mailto:yingxiufeng@gtmap.cn">yingxiufeng</a>
 * Date:  2016/7/20 11:20
 */
public class IndexController extends Controller {

    public void index() {
        renderText("Hello Maven Jfinal");
    }

}
