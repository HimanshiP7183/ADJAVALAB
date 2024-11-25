package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginService {

	MyUser validation(String uname, String password);

	boolean registerdetails(Person p, MyUser user);

}
