package com.ht.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.annotation.Log;
import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.entity.SysDictType;
import com.ht.common.core.page.TableDataInfo;
import com.ht.common.enums.BusinessType;
import com.ht.common.utils.poi.ExcelUtil;
import com.ht.system.service.ISysDictTypeService;

/**
 * data dictionary type controller
 * 
 * @author DJ
 */
@RestController
@RequestMapping("/system/dict/type")
public class SysDictTypeController extends BaseController
{
    @Autowired
    private ISysDictTypeService dictTypeService;

    @PreAuthorize("@ss.hasPermi('system:dict:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDictType dictType)
    {
        startPage();
        List<SysDictType> list = dictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }

    @Log(title = "dictionaryType", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:dict:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictType dictType)
    {
        List<SysDictType> list = dictTypeService.selectDictTypeList(dictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        util.exportExcel(response, list, "dictionaryType");
    }

    /**
     * getInfo
     */
    @PreAuthorize("@ss.hasPermi('system:dict:query')")
    @GetMapping(value = "/{dictId}")
    public AjaxResult getInfo(@PathVariable Long dictId)
    {
        return success(dictTypeService.selectDictTypeById(dictId));
    }

    /**
     * add dictionaryType
     */
    @PreAuthorize("@ss.hasPermi('system:dict:add')")
    @Log(title = "dictionaryType", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDictType dict)
    {
        if (!dictTypeService.checkDictTypeUnique(dict))
        {
            return error("new dictionary type'" + dict.getDictName() + "'failure，the dictionary type already exists");
        }
        dict.setCreateBy(getUsername());
        return toAjax(dictTypeService.insertDictType(dict));
    }

    /**
     * update dictionary type
     */
    @PreAuthorize("@ss.hasPermi('system:dict:edit')")
    @Log(title = "dictionaryType", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDictType dict)
    {
        if (!dictTypeService.checkDictTypeUnique(dict))
        {
            return error("update dictionary type'" + dict.getDictName() + "'failure，the dictionary type already exists");
        }
        dict.setUpdateBy(getUsername());
        return toAjax(dictTypeService.updateDictType(dict));
    }

    /**
     * remove dictionary type
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "dictionaryType", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictIds}")
    public AjaxResult remove(@PathVariable Long[] dictIds)
    {
        dictTypeService.deleteDictTypeByIds(dictIds);
        return success();
    }

    /**
     * refresh cache
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "dictionaryType", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    public AjaxResult refreshCache()
    {
        dictTypeService.resetDictCache();
        return success();
    }

    /**
     * get dictionary type list
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect()
    {
        List<SysDictType> dictTypes = dictTypeService.selectDictTypeAll();
        return success(dictTypes);
    }
}
