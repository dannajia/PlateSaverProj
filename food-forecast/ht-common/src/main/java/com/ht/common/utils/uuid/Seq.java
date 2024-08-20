package com.ht.common.utils.uuid;

import java.util.concurrent.atomic.AtomicInteger;
import com.ht.common.utils.DateUtils;
import com.ht.common.utils.StringUtils;

/**
 * @author DJ Seq class
 */
public class Seq
{
    
    public static final String commSeqType = "COMMON";

    
    public static final String uploadSeqType = "UPLOAD";

    
    private static AtomicInteger commSeq = new AtomicInteger(1);

    
    private static AtomicInteger uploadSeq = new AtomicInteger(1);

    
    private static final String machineCode = "A";

    /**
     * getId()
     * 
     * @return 
     */
    public static String getId()
    {
        return getId(commSeqType);
    }
    
    /**
     * getId method
     * 
     * @return 
     */
    public static String getId(String type)
    {
        AtomicInteger atomicInt = commSeq;
        if (uploadSeqType.equals(type))
        {
            atomicInt = uploadSeq;
        }
        return getId(atomicInt, 3);
    }

    /**
     * getId method
     * 
     * @param atomicInt 
     * @param length 
     * @return 
     */
    public static String getId(AtomicInteger atomicInt, int length)
    {
        String result = DateUtils.dateTimeNow();
        result += machineCode;
        result += getSeq(atomicInt, length);
        return result;
    }

    /**
     * getSeq method
     * 
     * @return 
     */
    private synchronized static String getSeq(AtomicInteger atomicInt, int length)
    {
        
        int value = atomicInt.getAndIncrement();

        
        int maxSeq = (int) Math.pow(10, length);
        if (atomicInt.get() >= maxSeq)
        {
            atomicInt.set(1);
        }
        
        return StringUtils.padl(value, length);
    }
}
