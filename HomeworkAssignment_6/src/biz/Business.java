/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

/**
 *
 * @author hezj
 */
public class Business {
    private static Business business;

    private Business() {}

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }
}
