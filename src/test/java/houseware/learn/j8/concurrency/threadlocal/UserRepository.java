package houseware.learn.j8.concurrency.threadlocal;

import java.util.UUID;


public class UserRepository {
    String getUserNameForUserId(Integer userId) {
        return UUID.randomUUID().toString();
    }
}
