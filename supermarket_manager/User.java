package Supermarket;
/**
 * 需求：创建一个用户类
 */
public class User {
    //创建属性
    String username;
    String password;
    /**
     * 需求：定义一个有参数的构造函数进行初始化
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * 需求：封装属性
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
