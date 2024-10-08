package com.ht.framework.manager;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.ht.common.utils.Threads;
import com.ht.common.utils.spring.SpringUtils;

/**
 * AsyncManager class
 * 
 * @author DJ
 */
public class AsyncManager
{
    
    private final int OPERATE_DELAY_TIME = 10;


    private ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");


    private AsyncManager(){}

    private static AsyncManager me = new AsyncManager();

    public static AsyncManager me()
    {
        return me;
    }

    /**
     * execute() method
     * 
     * @param task 
     */
    public void execute(TimerTask task)
    {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * shutdown() method
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
