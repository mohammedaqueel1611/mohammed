package com.hrms.TestScripts;
import com.hrms.lib.*;

public class TC_102 {
public static void main(String args[]) throws Exception{
	General g=new General();
	g.openapplication();
	g.login();
	g.addemp();
	g.closeapplication();
}
}
