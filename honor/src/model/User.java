package model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by reeco_000 on 2015/7/22.
 */
public class User extends Model<User>{

    private int userid;
    private String username;
    private String password;
    private List<Article> articles;
}