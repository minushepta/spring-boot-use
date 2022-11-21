package com.example.spring.boot.use.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.boot.use.mybatis.plus.common.exception.OperationFailureException;
import com.example.spring.boot.use.mybatis.plus.entity.PmsStudent;
import com.example.spring.boot.use.mybatis.plus.mapper.PmsStudentMapper;
import com.example.spring.boot.use.mybatis.plus.model.ResultVO;
import com.example.spring.boot.use.mybatis.plus.service.PmsStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员管理-学生 服务实现类
 * </p>
 *
 * @author minus
 * @since 2022-11-21
 */
@Service
public class PmsStudentServiceImpl extends ServiceImpl<PmsStudentMapper, PmsStudent> implements PmsStudentService {

    @Override
    public ResultVO<Object> saveStudent(PmsStudent pmsStudent) {
        if (!save(pmsStudent)) {
            throw new OperationFailureException("新增失败");
        }
        return ResultVO.suc();
    }

    @Override
    public ResultVO<Object> removeStudent(String id) {
        if (!removeById(id)) {
            throw new OperationFailureException("删除失败");
        }
        return ResultVO.suc();
    }

    @Override
    public ResultVO<Object> updateStudent(PmsStudent pmsStudent) {
        if (!updateById(pmsStudent)) {
            throw new OperationFailureException("更新失败");
        }
        return ResultVO.suc();
    }

    @Override
    public ResultVO<PmsStudent> getStudentById(String id) {
        return ResultVO.suc(getById(id));
    }

    @Override
    public ResultVO<Page<PmsStudent>> pageStudent(Page<PmsStudent> pmsStudentPage) {
        return ResultVO.suc(page(pmsStudentPage));
    }
}
