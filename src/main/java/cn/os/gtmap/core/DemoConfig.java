package cn.os.gtmap.core;

import com.jfinal.config.*;
import com.jfinal.core.Const;
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


    }

    /**
     * 配置插件 eg 数据库插件等
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {

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
