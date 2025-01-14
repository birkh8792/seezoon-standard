package com.seezoon.mybatis.repository.mapper;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.seezoon.mybatis.repository.po.AbstractPOQueryCondition;
import com.seezoon.mybatis.repository.po.BasePO;

/**
 * 包含基本CRUD定义，DAO 完成基础字段验证
 *
 * @param <T> DB 实体
 * @param <PK> 主键 快速开发所以只支持简单主键，即数值和字符
 * @author hdf
 */
public interface CrudMapper<T extends BasePO<PK>, PK> extends BaseMapper {

    /**
     * 通用删除，实际线上一般不给删除权限，无意义，可以根据项目情况注释掉
     *
     * @param pks
     * @return
     */
    int deleteByPrimaryKey(@NotEmpty PK... pks);

    /**
     * 插入
     *
     * @param records
     * @return
     */
    int insert(@NotEmpty T... records);

    /**
     * 根据主键查询
     *
     * @param pk
     * @return
     */
    T selectByPrimaryKey(@NotNull PK pk);

    /**
     * 查询
     *
     * @param condition
     * @return
     */
    List<T> selectByCondition(AbstractPOQueryCondition condition);

    /**
     * 选择性更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(@NotNull T record);

    /**
     * 主键全字段更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(@NotNull T record);
}
