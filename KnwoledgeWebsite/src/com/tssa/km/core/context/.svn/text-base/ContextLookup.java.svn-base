package com.tssa.km.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextLookup implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private boolean ignoreOverwrite = false;

    private static ContextLookup instance;

    /**
     * 
     */
    public ContextLookup() {
    }

    /**
     * @see ApplicationContextAware#setApplicationContext(ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (instance != null && !ignoreOverwrite) {
            throw new RuntimeException(ContextLookup.class.getName()
                    + " applicationContext already initialised");
        }
        this.applicationContext = applicationContext;
        instance = this;
    }

    public static ApplicationContext getApplicationContext() {
        if (instance == null) {
            throw new RuntimeException(ContextLookup.class.getName() + " not initialised");
        }
        if (instance.applicationContext == null) {
            throw new RuntimeException(ContextLookup.class.getName() + " application context null");
        }
        return instance.applicationContext;
    }

    /**
     * @param ignoreOverwrite the ignoreOverwrite to set
     */
    public void setIgnoreOverwrite(boolean ignoreOverwrite) {
        this.ignoreOverwrite = ignoreOverwrite;
    }

}
