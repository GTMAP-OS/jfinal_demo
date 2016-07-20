package cn.os.gtmap.core;

import cn.os.gtmap.entity.UserInfo;
import cn.os.gtmap.support.spring.SpringPlugin;
import cn.os.gtmap.web.IndexController;
import com.jfinal.config.*;
import com.jfinal.core.Const;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
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
        me.setDevMode(getPropertyToBoolean("dev.mode",false));
    }

    /**
     * 路由配置
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
    }

    /**
     * 配置插件 eg 数据库插件等
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {
        //添加spring插件 非必要
        me.add(new SpringPlugin(PathKit.getRootClassPath()+"\\app-context.xml"));

        // 配置C3p0数据库连接池插件
        C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("db.url").trim(), getProperty("db.username").trim(), getProperty("db.password").trim());
        me.add(c3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);
        arp.addMapping("user_info", UserInfo.class);	// 映射UserInfo 表到 UserInfo模型


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
