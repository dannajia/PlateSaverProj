package com.ht.common.core.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Set;
import com.ht.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Convert class
 *
 * @author DJ
 */
public class Convert
{
    /**
     * convert to String<br>
     * if the value is null or the conversion failed，return default value<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static String toStr(Object value, String defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof String)
        {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * convert to String<br>
     * if the vaule is <code>null</code>，or conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static String toStr(Object value)
    {
        return toStr(value, null);
    }

    /**
     * convert to char<br>
     * if the value is null，or conversion failed，return default value<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Character toChar(Object value, Character defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof Character)
        {
            return (Character) value;
        }

        final String valueStr = toStr(value, null);
        return StringUtils.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
    }

    /**
     * convert to char<br>
     * if the value is <code>null</code>，or conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value
     * @return 
     */
    public static Character toChar(Object value)
    {
        return toChar(value, null);
    }

    /**
     * conver to byte<br>
     * if the value is <code>null</code>，or conversion failed，return default value<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Byte toByte(Object value, Byte defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Byte)
        {
            return (Byte) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).byteValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Byte.parseByte(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to byte<br>
     * if the given value is <code>null</code>，or the conversion failed，return default <code>null</code><br>
     *
     * @param value 
     * @return 
     */
    public static Byte toByte(Object value)
    {
        return toByte(value, null);
    }

    /**
     * convert to Short<br>
     * if the given value is <code>null</code>，or the conversion failed，return the defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Short toShort(Object value, Short defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Short)
        {
            return (Short) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).shortValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Short.parseShort(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to Short<br>
     * if the given value is <code>null</code>，or the conversion failed，return default <code>null</code><br>
     *
     * @param value 
     * @return 
     */
    public static Short toShort(Object value)
    {
        return toShort(value, null);
    }

    /**
     * convert to Number<br>
     * if the given value is null，or the conversion failed，return the defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Number toNumber(Object value, Number defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Number)
        {
            return (Number) value;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return NumberFormat.getInstance().parse(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to Number<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     *
     * @param value 
     * @return 
     */
    public static Number toNumber(Object value)
    {
        return toNumber(value, null);
    }

    /**
     * convert to int<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Integer toInt(Object value, Integer defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Integer)
        {
            return (Integer) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to int<br>
     * if the given value is <code>null</code>，or the conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static Integer toInt(Object value)
    {
        return toInt(value, null);
    }

    /**
     * convert to Integer array<br>
     *
     * @param str 
     * @return 
     */
    public static Integer[] toIntArray(String str)
    {
        return toIntArray(",", str);
    }

    /**
     * convert to Long array<br>
     *
     * @param str 
     * @return 
     */
    public static Long[] toLongArray(String str)
    {
        return toLongArray(",", str);
    }

    /**
     * convert to Integer array<br>
     *
     * @param split 
     * @param str 
     * @return 
     */
    public static Integer[] toIntArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Integer[] {};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    /**
     * convert to Long array<br>
     *
     * @param split 
     * @param str 
     * @return 
     */
    public static Long[] toLongArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Long[] {};
        }
        String[] arr = str.split(split);
        final Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Long v = toLong(arr[i], null);
            longs[i] = v;
        }
        return longs;
    }

    /**
     * convert to String array<br>
     *
     * @param str 
     * @return 
     */
    public static String[] toStrArray(String str)
    {
        return toStrArray(",", str);
    }

    /**
     * convert to String array<br>
     *
     * @param split 
     * @param str 
     * @return 
     */
    public static String[] toStrArray(String split, String str)
    {
        return str.split(split);
    }

    /**
     * convert to long<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value
     * @param defaultValue 
     * @return 
     */
    public static Long toLong(Object value, Long defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Long)
        {
            return (Long) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).longValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            
            return new BigDecimal(valueStr.trim()).longValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to long<br>
     * if the given value is <code>null</code>，or the conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static Long toLong(Object value)
    {
        return toLong(value, null);
    }

    /**
     * convert to double<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Double toDouble(Object value, Double defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Double)
        {
            return (Double) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).doubleValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            
            return new BigDecimal(valueStr.trim()).doubleValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to double<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static Double toDouble(Object value)
    {
        return toDouble(value, null);
    }

    /**
     * convert to Float<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Float toFloat(Object value, Float defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Float)
        {
            return (Float) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).floatValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Float.parseFloat(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to Float<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     *
     * @param value 
     * @return 
     */
    public static Float toFloat(Object value)
    {
        return toFloat(value, null);
    }

    /**
     * convert to boolean<br>
     * supported String value：true、false、yes、ok、no，1,0 if the given value is null，or the conversion failed，return defaultValue<br>
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static Boolean toBool(Object value, Boolean defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Boolean)
        {
            return (Boolean) value;
        }
        String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        valueStr = valueStr.trim().toLowerCase();
        switch (valueStr)
        {
            case "true":
            case "yes":
            case "ok":
            case "1":
                return true;
            case "false":
            case "no":
            case "0":
                return false;
            default:
                return defaultValue;
        }
    }

    /**
     * convert to boolean<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static Boolean toBool(Object value)
    {
        return toBool(value, null);
    }

    /**
     * convert to Enum<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     *
     * @param clazz Enum Class
     * @param value 
     * @param defaultValue 
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (clazz.isAssignableFrom(value.getClass()))
        {
            @SuppressWarnings("unchecked")
            E myE = (E) value;
            return myE;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Enum.valueOf(clazz, valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to Enum<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     *
     * @param clazz Enum Class
     * @param value 
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value)
    {
        return toEnum(clazz, value, null);
    }

    /**
     * convert to BigInteger<br>
     * if the given value is null, or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return
     */
    public static BigInteger toBigInteger(Object value, BigInteger defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigInteger)
        {
            return (BigInteger) value;
        }
        if (value instanceof Long)
        {
            return BigInteger.valueOf((Long) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigInteger(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to BigInteger<br>
     * if the given value is null，or the conversion failed，return default <code>null</code><br>
     * 
     *
     * @param value 
     * @return 
     */
    public static BigInteger toBigInteger(Object value)
    {
        return toBigInteger(value, null);
    }

    /**
     * convert to BigDecimal<br>
     * if the given value is null，or the conversion failed，return defaultValue<br>
     * 
     *
     * @param value 
     * @param defaultValue 
     * @return 
     */
    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigDecimal)
        {
            return (BigDecimal) value;
        }
        if (value instanceof Long)
        {
            return new BigDecimal((Long) value);
        }
        if (value instanceof Double)
        {
            return BigDecimal.valueOf((Double) value);
        }
        if (value instanceof Integer)
        {
            return new BigDecimal((Integer) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigDecimal(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * convert to BigDecimal<br>
     * if the given value is null，or the conversion failed，return default null<br>
     * 
     *
     * @param value 
     * @return 
     */
    public static BigDecimal toBigDecimal(Object value)
    {
        return toBigDecimal(value, null);
    }

    /**
     * convert to utf8 string<br>
     *
     * @param obj 
     * @return 
     */
    public static String utf8Str(Object obj)
    {
        return str(obj, CharsetKit.CHARSET_UTF_8);
    }

    /**
     * convert to string<br>
     *
     * @param obj 
     * @param charsetName 
     * @return 
     */
    public static String str(Object obj, String charsetName)
    {
        return str(obj, Charset.forName(charsetName));
    }

    /**
     * convert to string<br>
     * 
     *
     * @param obj 
     * @param charset 
     * @return 
     */
    public static String str(Object obj, Charset charset)
    {
        if (null == obj)
        {
            return null;
        }

        if (obj instanceof String)
        {
            return (String) obj;
        }
        else if (obj instanceof byte[])
        {
            return str((byte[]) obj, charset);
        }
        else if (obj instanceof Byte[])
        {
            byte[] bytes = ArrayUtils.toPrimitive((Byte[]) obj);
            return str(bytes, charset);
        }
        else if (obj instanceof ByteBuffer)
        {
            return str((ByteBuffer) obj, charset);
        }
        return obj.toString();
    }

    /**
     * convert to String
     *
     * @param bytes byte array
     * @param charset 
     * @return 
     */
    public static String str(byte[] bytes, String charset)
    {
        return str(bytes, StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * convert to String
     *
     * @param data the byte array 
     * @param charset 
     * @return 
     */
    public static String str(byte[] data, Charset charset)
    {
        if (data == null)
        {
            return null;
        }

        if (null == charset)
        {
            return new String(data);
        }
        return new String(data, charset);
    }

    /**
     * convert byteBuffer to String
     *
     * @param data 
     * @param charset 
     * @return 
     */
    public static String str(ByteBuffer data, String charset)
    {
        if (data == null)
        {
            return null;
        }

        return str(data, Charset.forName(charset));
    }

    /**
     * convert byteBuffer to String
     *
     * @param data 
     * @param charset 
     * @return 
     */
    public static String str(ByteBuffer data, Charset charset)
    {
        if (null == charset)
        {
            charset = Charset.defaultCharset();
        }
        return charset.decode(data).toString();
    }

    
    /**
     * to SBC
     *
     * @param input String.
     * @return 
     */
    public static String toSBC(String input)
    {
        return toSBC(input, null);
    }

    /**
     * toSBC()
     *
     * @param input String
     * @param notConvertSet 
     * @return 
     */
    public static String toSBC(String input, Set<Character> notConvertSet)
    {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                
                continue;
            }

            if (c[i] == ' ')
            {
                c[i] = '\u3000';
            }
            else if (c[i] < '\177')
            {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    /**
     * toDBC()
     *
     * @param input String.
     * @return 
     */
    public static String toDBC(String input)
    {
        return toDBC(input, null);
    }

    /**
     * toDBC()
     *
     * @param text 
     * @param notConvertSet 
     * @return 
     */
    public static String toDBC(String text, Set<Character> notConvertSet)
    {
        char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                
                continue;
            }

            if (c[i] == '\u3000')
            {
                c[i] = ' ';
            }
            else if (c[i] > '\uFF00' && c[i] < '\uFF5F')
            {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);

        return returnString;
    }
}
