package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.steam.api.GameItems;
import main.steam.api.PlayerService;
import main.steam.api.SteamNewsService;
import main.steam.api.UserService;
import main.steam.api.games.CSGoService;
import main.steam.api.games.DotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jonas on 2016-01-16.
 */
@RestController
public class Endpoints {
    Gson gson = new GsonBuilder().create();

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping("/endpoints")
    public Set<RequestMappingInfo> getEndpoints(){
        return requestMappingHandlerMapping.getHandlerMethods().keySet();
    }

    @RequestMapping("/")
    public String index() {
        Class c = GameItems.class;
        MethodList methodList = new MethodList();
        methodList.methods = new ArrayList<MethodContainer>();

        Method[] methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        c = PlayerService.class;
        methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        c = UserService.class;
        methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        c = SteamNewsService.class;
        methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        c = CSGoService.class;
        methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        c = DotaService.class;
        methods = c.getDeclaredMethods();
        getParamMap(methods, methodList);

        return gson.toJson(methodList);
    }

    private void getParamMap(Method[] methods, MethodList methodList) {
        for (Method method : methods) {
            MethodContainer methodContainer = new MethodContainer();
            methodContainer.name = method.getName();
            methodContainer.url = method.getAnnotation( RequestMapping.class ).value()[0];
            methodList.methods.add(methodContainer);
        }
    }
}

class MethodList {
    List<MethodContainer> methods;
}

class MethodContainer {
    String name;
    String url;
}
