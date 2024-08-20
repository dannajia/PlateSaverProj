package com.ht.web.controller.system;

import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.R;
import com.ht.common.core.page.TableDataInfo;
import com.ht.system.domain.SysDocumentEntity;
import com.ht.system.service.SysDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysDocument")
public class SysDocumentController extends BaseController {

    @Autowired
    private SysDocumentService documentService;

    @GetMapping
    public TableDataInfo list(SysDocumentEntity entity) {
        startPage();
        List<SysDocumentEntity> list = documentService.list(entity);
        return getDataTable(list);
    }

    @PostMapping
    public R insert(@RequestBody @Validated SysDocumentEntity entity) {
        documentService.insert(entity);
        return R.ok();
    }

    @PutMapping
    public R update(@RequestBody @Validated SysDocumentEntity entity) {
        if (entity.getId() == null) {
            return R.fail("iD can't be null");
        }
        documentService.update(entity);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R del(@PathVariable Long id) {
        documentService.del(id);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        SysDocumentEntity detail = documentService.detail(id);
        return R.ok(detail);
    }

}
