package controller;

import com.jfinal.core.Controller;
/**
 * Created by reeco_000 on 2015/7/22.
 */
public class IndexController extends Controller{
    public void index(){
		renderJsp("index.jsp");
	}
}