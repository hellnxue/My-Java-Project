package com.anbo.test;

public class Person {
    public void eat(){System.out.println("ssssssssss");};
    
    public static class Demo {
        public static void main(String[] args) {
            Person p = new Person() {
                public void eat() {
                    System.out.println("eat something");
                }
            };
            p.eat();
        }
    }
}

