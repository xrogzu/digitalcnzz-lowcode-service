package com.pig.easy.bpm.generator.controller;


import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.pig.easy.bpm.common.converter.LocalDateTimeConverter;
import com.pig.easy.bpm.common.entityError.EntityError;
import com.pig.easy.bpm.common.utils.BeanUtils;
import com.pig.easy.bpm.common.utils.EasyBpmAsset;
import com.pig.easy.bpm.common.utils.JsonResult;
import com.pig.easy.bpm.common.utils.Result;
import com.pig.easy.bpm.generator.dto.request.TemplateQueryDTO;
import com.pig.easy.bpm.generator.dto.request.TemplateSaveOrUpdateDTO;
import com.pig.easy.bpm.generator.dto.response.TemplateDTO;
import com.pig.easy.bpm.generator.dto.response.TemplateExportDTO;
import com.pig.easy.bpm.generator.service.TemplateService;
import com.pig.easy.bpm.generator.vo.request.TemplateQueryVO;
import com.pig.easy.bpm.generator.vo.request.TemplateSaveOrUpdateVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


/**
 * <p>
 * 模板表 前端控制器
 * </p>
 *
 * @author pig
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService service;

    @ApiOperation(value = "查询模板表列表", notes = "查询模板表列表", produces = "application/json")
    @PostMapping("/getListPage")
    public JsonResult getListPage(@Valid @RequestBody TemplateQueryVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, TemplateQueryDTO.class);

        Result<PageInfo<TemplateDTO>> result = service.getListPageByCondition(queryDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "查询模板表列表", notes = "查询模板表列表", produces = "application/json")
    @PostMapping("/getList")
    public JsonResult getList(@Valid @RequestBody TemplateQueryVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, TemplateQueryDTO.class);

        Result<List<TemplateDTO>> result = service.getListByCondition(queryDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "新增模板表", notes = "新增模板表", produces = "application/json")
    @PostMapping("/insert")
    public JsonResult insertTemplate(@Valid @RequestBody TemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, TemplateSaveOrUpdateDTO.class);

        Result<Integer> result = service.insertTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "修改模板表", notes = "修改模板表", produces = "application/json")
    @PostMapping("/update")
    public JsonResult updateTemplate(@Valid @RequestBody TemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, TemplateSaveOrUpdateDTO.class);

        Result<Integer> result = service.updateTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
          return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "删除模板表", notes = "删除模板表", produces = "application/json")
    @PostMapping("/deleteById")
    public JsonResult deleteById(@Valid @RequestBody TemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, TemplateSaveOrUpdateDTO.class);
        saveDTO.setValidState(0);

        Result<Integer> result = service.deleteTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "下载模板表", notes = "下载模板表", produces = "application/json")
    @PostMapping("download")
    public void download(HttpServletResponse response,@Valid @RequestBody TemplateQueryVO param) throws IOException {

        EasyBpmAsset.isAssetEmpty(param);
        TemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, TemplateQueryDTO.class);

        Result<List<TemplateDTO>> result = service.getListByCondition(queryDTO);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = String.valueOf(System.currentTimeMillis()) + "模板表.xlsx";
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        EasyExcel.write(response.getOutputStream(), TemplateExportDTO.class).registerConverter(new LocalDateTimeConverter()).sheet().doWrite(result.getData());
    }

    @ApiOperation(value = "根据编号获取模板表", notes = "根据编号获取模板表", produces = "application/json")
    @PostMapping("/getById")
    public JsonResult getById(@Valid @RequestBody TemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        EasyBpmAsset.isAssetEmpty(param.getTemplateId());

        Result<TemplateDTO> result = service.getTemplateById(param.getTemplateId());
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }
}
