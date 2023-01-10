//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dbest.rpp.util;

import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.Stateless;

@Stateless
public class PasswordHash {
    public PasswordHash() {
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyHash(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }
}

