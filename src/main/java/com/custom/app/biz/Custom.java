/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.biz;

import java.io.Serializable;

/**
 *
 * @author wb-tianzd
 * @version $Id: Custom.java, v 0.1 2013-4-23 ÉÏÎç09:39:43 wb-tianzd Exp $
 */
public class Custom implements Serializable {

    /**  */
    private static final long serialVersionUID = 5119725407859981310L;

    private String            username;

    private String            age;

    private String            address;

    private String            email;

    private String            Password;

    /**
     * Getter method for property <tt>username</tt>.
     * 
     * @return property value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for property <tt>username</tt>.
     * 
     * @param username value to be assigned to property username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public String getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for property <tt>email</tt>.
     *
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     *
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param Password value to be assigned to property password
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.username + "_" + this.age + "_" + this.email + "_" + this.address + "_"
               + this.Password;
    }

}
