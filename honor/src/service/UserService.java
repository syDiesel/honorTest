package service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by reeco_000 on 2015/7/22.
 */
public class UserService{
    public boolean add(String username,String password){

		String SQL = "SELECT userid FROM user WHERE username =?";
		Integer result = Db.queryFirst(SQL, username);
		if(result==null){
			Record user = new Record().set("username", username).set("password", password);
			System.out.println(user.getStr("username"));
			Db.save("user", user);

			return true;
		}
		return false;
	}
	public boolean login(String username,String password){
		String SQL = "SELECT userid FROM user WHERE username =? and password=?";
		Integer result = Db.queryFirst(SQL, username, password);

		if(result!=null)
			return true;
		else return false;
	}

	public List<Record> getArticles(String username,String password){

        String SQL = "SELECT * FROM user WHERE username =? and password=?";
        Record user = Db.findFirst(SQL,username,password);
        String sql = "SELECT * from user,article where user.userid = article.user_id && user.userid = ?";
        List<Record> articles = Db.find(sql,user.getInt("userid"));
        System.out.println(articles.get(2));
        return articles;


    }
}