package org.jboss.weld.remote.ejb.with.cdi.test;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class Deployments {

    private static final String WAR_PATH = "../remote-ejb-with-cdi-server-side/target/remote-ejb-with-cdi-server-side.war";

    public static WebArchive getWar(){
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File(WAR_PATH));
    }

}
