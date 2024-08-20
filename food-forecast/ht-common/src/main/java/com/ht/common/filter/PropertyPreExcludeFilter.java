package com.ht.common.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * PropertyPreExcludeFilter class
 * 
 * @author DJ
 */
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter
{
    public PropertyPreExcludeFilter()
    {
    }

    public PropertyPreExcludeFilter addExcludes(String... filters)
    {
        for (int i = 0; i < filters.length; i++)
        {
            this.getExcludes().add(filters[i]);
        }
        return this;
    }
}
