package com.ht.common.constant;

/**
 * code generated constants
 * 
 * @author DJ
 */
public class GenConstants
{
    /** crud） */
    public static final String TPL_CRUD = "crud";

    /** tree */
    public static final String TPL_TREE = "tree";

    /** sub） */
    public static final String TPL_SUB = "sub";

    /** treeCode */
    public static final String TREE_CODE = "treeCode";

    /** treeParentCode */
    public static final String TREE_PARENT_CODE = "treeParentCode";

    /** treeName */
    public static final String TREE_NAME = "treeName";

    /** parentMenuId */
    public static final String PARENT_MENU_ID = "parentMenuId";

    /** parentMenuName */
    public static final String PARENT_MENU_NAME = "parentMenuName";

    /** list of String type */
    public static final String[] COLUMNTYPE_STR = { "char", "varchar", "nvarchar", "varchar2" };

    /** list of Text type */
    public static final String[] COLUMNTYPE_TEXT = { "tinytext", "text", "mediumtext", "longtext" };

    /** list of the type of time */
    public static final String[] COLUMNTYPE_TIME = { "datetime", "time", "date", "timestamp" };

    /** list of number type */
    public static final String[] COLUMNTYPE_NUMBER = { "tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bit", "bigint", "float", "double", "decimal" };

    /** Non editable columns */
    public static final String[] COLUMNNAME_NOT_EDIT = { "id", "create_by", "create_time", "del_flag" };

    /** system columns */
    public static final String[] COLUMNNAME_NOT_LIST = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time" };

    /** non searchable columns */
    public static final String[] COLUMNNAME_NOT_QUERY = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time", "remark" };

    /** Entity */
    public static final String[] BASE_ENTITY = { "createBy", "createTime", "updateBy", "updateTime", "remark" };

    /** Tree */
    public static final String[] TREE_ENTITY = { "parentName", "parentId", "orderNum", "ancestors", "children" };

    /** Input */
    public static final String HTML_INPUT = "input";

    /** TextArea */
    public static final String HTML_TEXTAREA = "textarea";

    /** Select */
    public static final String HTML_SELECT = "select";

    /** radio button */
    public static final String HTML_RADIO = "radio";

    /** checkbox */
    public static final String HTML_CHECKBOX = "checkbox";

    /** dateTime */
    public static final String HTML_DATETIME = "datetime";

    /** imageUpload */
    public static final String HTML_IMAGE_UPLOAD = "imageUpload";

    /** fileUpload */
    public static final String HTML_FILE_UPLOAD = "fileUpload";

    /** editor */
    public static final String HTML_EDITOR = "editor";

    /** String */
    public static final String TYPE_STRING = "String";

    /**Integer */
    public static final String TYPE_INTEGER = "Integer";

    /** Long */
    public static final String TYPE_LONG = "Long";

    /** Double */
    public static final String TYPE_DOUBLE = "Double";

    /** BigDecimal */
    public static final String TYPE_BIGDECIMAL = "BigDecimal";

    /** Date */
    public static final String TYPE_DATE = "Date";

    /** Like */
    public static final String QUERY_LIKE = "LIKE";

    /** Equal */
    public static final String QUERY_EQ = "EQ";

    /** Require */
    public static final String REQUIRE = "1";
}
