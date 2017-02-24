package model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by VinDiesel on 2017/2/22.
 */
public class Article extends Model<Article> {

    private int id;
    private User user;


}
