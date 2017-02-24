
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.IndexController;
import controller.UserController;
import model.Article;
import model.User;

/**
 * Created by reeco_000 on 2015/7/22.
 */
public class AppConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setEncoding("UTF-8");
        constants.setDevMode(true);
        constants.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class);
        routes.add("/user", UserController.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        //这里启用Jfinal插件
        PropKit.use("jdbc.properties");
        final String URL = PropKit.get("jdbcUrl");
        final String USERNAME = PropKit.get("user");
        final String PASSWORD = PropKit.get("password");
        final Integer INITIALSIZE = PropKit.getInt("initialSize");
        final Integer MIDIDLE = PropKit.getInt("minIdle");
        final Integer MAXACTIVEE = PropKit.getInt("maxActivee");
        DruidPlugin druidPlugin = new DruidPlugin(URL, USERNAME, PASSWORD);
        druidPlugin.set(INITIALSIZE, MIDIDLE, MAXACTIVEE);
        druidPlugin.setFilters("stat,wall");
        plugins.add(druidPlugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);

        activeRecordPlugin.addMapping("user", "userid", User.class);
        activeRecordPlugin.addMapping("article", "id", Article.class);

        plugins.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        //这里用于配置全局的拦截器，对�?��请求进行拦截
        //interceptors.addGlobalActionInterceptor(new AuthInterceptor());
        // 添加业务层全�?��截器
        //interceptors.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {
    }
}