package com.maty.j2ee.dao;

import com.maty.j2ee.pojo.BaseUserRole;
import com.maty.j2ee.pojo.Criteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface BaseUserRoleMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer userRoleId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BaseUserRole record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BaseUserRole record);

    /**
     * 根据条件查询记录集
     */
    List<BaseUserRole> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    BaseUserRole selectByPrimaryKey(Integer userRoleId);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") BaseUserRole record, @Param("condition") Map<String, Object> condition);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") BaseUserRole record, @Param("condition") Map<String, Object> condition);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BaseUserRole record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BaseUserRole record);
}