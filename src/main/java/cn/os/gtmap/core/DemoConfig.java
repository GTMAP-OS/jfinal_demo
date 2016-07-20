package cn.os.gtmap.core;

import cn.os.gtmap.support.spring.SpringPlugin;
import cn.os.gtmap.web.IndexController;
import com.jfinal.config.*;
import com.jfinal.core.Const;
import com.jfinal.kit.PathKit;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;

import java.util.HashMap;
import java.util.Map;

/**
 * demo config 核心类 用于控制整个应用的配置信息
 * Author: <a href="mailto:yingxiufeng@gtmap.cn">yingxiufeng</a>
 * Date:  2016/7/4 17:21
 */
public class DemoConfig extends JFinalConfig{

    /***
     * 配置应用的常量属性 可通过 getProperty()获取相关配置
     * @param me
     */
    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("conf/application.properties");
        me.setViewType(ViewType.FREE_MARKER);
        me.setBaseViewPath("/views");
    }

    /**
     * 路由配置
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class,"/WEB-INF/views");
    }

    /**
     * 配置插件 eg 数据库插件等
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {
        //添加spring插件 非必要
        me.add(new SpringPlugin(PathKit.getRootClassPath()+"\\app-context.xml"));
    }

    /***
     *  配置全局拦截器
     * @param me
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /***
     * 配置处理器
     * @param me
     */
    @Override
    public void configHandler(Handlers me) {

    }

    /***
     * 设置一些插件的参数等
     */
    public void afterJFinalStart() {
        FreeMarkerRender.getConfiguration().setClassicCompatible(true);
        FreeMarkerRender.getConfiguration().setURLEscapingCharset(Const.DEFAULT_ENCODING);
        FreeMarkerRender.getConfiguration().setAutoImports(getImportsMap());
    }

    /***
     *
     * @return
     */
    private Map getImportsMap(){
        Map map=new HashMap();
        map.put("common/core.ftl","core");
        return map;
    }
}
