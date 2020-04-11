package com.example.lettucedemo.service.impl;

import com.example.lettucedemo.pojo.User;
import com.example.lettucedemo.service.UserService;
import com.example.lettucedemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String setUser() {

        for (int j=0;j<100;j++) {
            Thread t = new Thread() {
                public void run(){
                    for(int i=0;i<10000;i++) {
                        User user = new User();
                        user.setUID(""+i);
                        user.setName("testUser"+i);
                        user.setGroupID(i%10);

                        redisUtils.set("usrkey"+i, user);
                        System.out.println(redisUtils.get("usrobjkey1"));
                    }
                }
            };
            t.start();
        }

        return "Done";
    }
}
