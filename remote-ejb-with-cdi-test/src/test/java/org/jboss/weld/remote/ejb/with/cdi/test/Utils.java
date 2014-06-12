package org.jboss.weld.remote.ejb.with.cdi.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.weld.remote.ejb.with.cdi.server.side.CounterStatefulRemote;
import org.junit.Assert;

public class Utils {

    private static InitialContext context;

    /**
     * Looks up and returns the proxy to remote stateless calculator bean
     *
     * @return
     * @throws NamingException
     */
    public static Object lookupRemoteStatelessCalculator(String beanName, String intName) throws NamingException {
        Object lookedUpObject = getContext().lookup("ejb:/remote-ejb-with-cdi-server-side/" + beanName + "!" + intName);
        System.err.println("ejb:/remote-ejb-with-cdi-server-side/" + beanName + "!" + intName);
        Assert.assertNotNull(lookedUpObject);
        System.out.println("Obtained a remote stateless calculator for invocation");
        return lookedUpObject;
    }

    /**
     * Looks up and returns the proxy to remote stateful counter bean
     *
     * @return
     * @throws NamingException
     */
    public static CounterStatefulRemote lookupRemoteStatefulCounter(String beanName) throws NamingException {
        CounterStatefulRemote statefulCounter = (CounterStatefulRemote) getContext().lookup(
            "ejb:/remote-ejb-with-cdi-server-side/" + beanName + "!" + CounterStatefulRemote.class.getName() + "?stateful");
        Assert.assertNotNull(statefulCounter);
        System.out.println("Obtained a remote stateful counter for invocation");
        return statefulCounter;
    }

    public static Context getContext() throws NamingException {
        if (context == null) {
            final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            context = new InitialContext(jndiProperties);
        }
        return context;
    }

}
