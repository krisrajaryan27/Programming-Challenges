package com.nirvana.learning.designpatterns.creational.singleton;

/**
 * @author KrishnaV on 11/11/19
 * @project Programming-Challenges
 */
public class DbSingleton {
    //Making instance thread-safe using volatile, using null to get lazy loading
    private static volatile DbSingleton instance = null;
    
    private DbSingleton(){
        //Making instance to be avoided to be changed using Reflection
          if(instance != null){
              throw new RuntimeException("Use getInstance() Method to create");
          }
    }
    public static DbSingleton getInstance(){
        if(instance == null){
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
}
