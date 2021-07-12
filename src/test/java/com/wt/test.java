package com.wt;

import com.wt.dao.impl.UserDaoImpl;
import com.wt.entity.User;
import org.junit.Test;

public class test {
    @Test
    public void test1() {
        User u = new UserDaoImpl().getUserByUsernameAndPassword("root", "123456");
        System.out.println(u);
    }
}
