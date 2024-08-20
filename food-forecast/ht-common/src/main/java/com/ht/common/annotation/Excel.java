package com.ht.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import com.ht.common.utils.poi.ExcelHandlerAdapter;

/**
 * Excel data format interface
 * 
 * @author DJ
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel
{
    /**
     * sort in excel
     */
    public int sort() default Integer.MAX_VALUE;

    /**
     * name in Excel
     */
    public String name() default "";

    /**
     * date format, e.g. yyyy-MM-dd
     */
    public String dateFormat() default "";

    /**
     * dictionary type (e.g. sys_user_sex)
     */
    public String dictType() default "";

    /**
     * read converterter expression (e.g. 0=male,1=female,2=unknown)
     */
    public String readConverterExp() default "";

    /**
     * splitter char
     */
    public String separator() default ",";

    /**
     * BigDecimal scale default:-1(default BigDecimal formatter off)
     */
    public int scale() default -1;

    /**
     * BigDecimal rounding mode default:BigDecimal.ROUND_HALF_EVEN
     */
    public int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * height of column in excel
     */
    public double height() default 14;

    /**
     * height of column in excel
     */
    public double width() default 16;

    /**
     * suffix, e.g.% 90 convert to 90%
     */
    public String suffix() default "";

    /**
     * default String value
     */
    public String defaultValue() default "";

    /**
     * prompt
     */
    public String prompt() default "";

    /**
     * the columns not allowed to input
     */
    public String[] combo() default {};

    /**
     * needMerge or not
     */
    public boolean needMerge() default false;

    /**
     * isExport or not
     */
    public boolean isExport() default true;

    /**
     * target atrributes, supporting multiple levels and separating with dot
     */
    public String targetAttr() default "";

    /**
     * isStatistics or not
     */
    public boolean isStatistics() default false;

    /**
     * the type of cell（0 numeric 1 String 2 Image）
     */
    public ColumnType cellType() default ColumnType.STRING;

    /**
     * header background color
     */
    public IndexedColors headerBackgroundColor() default IndexedColors.GREY_50_PERCENT;

    /**
     * header color
     */
    public IndexedColors headerColor() default IndexedColors.WHITE;

    /**
     * backgound color
     */
    public IndexedColors backgroundColor() default IndexedColors.WHITE;

    /**
     * color of cell
     */
    public IndexedColors color() default IndexedColors.BLACK;

    /**
     * align
     */
    public HorizontalAlignment align() default HorizontalAlignment.CENTER;

    /**
     * handler
     */
    public Class<?> handler() default ExcelHandlerAdapter.class;

    /**
     * args list
     */
    public String[] args() default {};

    /**
     * Enum of data exchange type（0：All；1：Export；2：Import）
     */
    Type type() default Type.ALL;

    public enum Type
    {
        ALL(0), EXPORT(1), IMPORT(2);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    public enum ColumnType
    {
        NUMERIC(0), STRING(1), IMAGE(2);
        private final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
}