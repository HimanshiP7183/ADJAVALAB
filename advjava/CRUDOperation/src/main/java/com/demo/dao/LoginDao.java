package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginDao {

	MyUser validation(String uname, String password);

	boolean registration(Person p, MyUser user);

}
