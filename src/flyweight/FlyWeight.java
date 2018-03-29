package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeight {
    public static void main(String[] args) {
        User ming = new User();
        ming.setUsername("小明");
        User gang = new User();
        gang.setUsername("小刚");

        //建立两个博客
        Website blog1 = WebsiteFactory.getWebsite("博客");
        blog1.show(ming);
        Website blog2 = WebsiteFactory.getWebsite("博客");
        blog2.show(gang);
        //建立两个购物网站
        Website shopping1 = WebsiteFactory.getWebsite("购物网站");
        shopping1.show(ming);
        Website shopping2 = WebsiteFactory.getWebsite("购物网站");
        shopping2.show(gang);

        System.out.println(WebsiteFactory.getWebsizeNum());
    }
}

class WebsiteFactory {
    private static Map<String, Website> websiteMap = new HashMap<>();

    //检查有没有已存在同一类型的对象
    public static Website getWebsite(String type) {
        Website website = websiteMap.get(type);
        if (website == null) {
            website = new ConcreteWebsite(type);
            websiteMap.put(type, website);
        }
        return website;
    }

    public static int getWebsizeNum() {
        return websiteMap.size();
    }
}

/**
 * 网站接口
 */
interface Website {
    //User是外部参数
    void show(User user);
}

class ConcreteWebsite implements Website {

    public ConcreteWebsite(String websiteType) {
        this.websiteType = websiteType;
    }

    //网站类型
    private String websiteType;

    @Override
    public void show(User user) {
        System.out.println("网站分类:" + websiteType + "  用户名:" + user.getUsername());
    }
}

class User {
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private String username;
}
