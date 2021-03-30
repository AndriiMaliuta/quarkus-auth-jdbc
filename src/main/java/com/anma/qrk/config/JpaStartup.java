package com.anma.qrk.config;

import com.anma.qrk.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class JpaStartup {

    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
//        User.deleteAll();
//        User.add("admin", "admin", "admin");
//        User.add("user", "user", "user");
    }
}
