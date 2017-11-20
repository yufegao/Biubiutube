/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

/**
 *
 * @author hezj
 */
public class BiubiuBrowser {
    private static BiubiuBrowser biubiuBrowser = new BiubiuBrowser();
    public Browser browser = new Browser();
    public BrowserView view = new BrowserView(browser);

    public static BiubiuBrowser getInstance() {
        return biubiuBrowser;
    }
}
