package com.yefan.dao;

import com.yefan.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/12
 */

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findMemberById(String id) throws Exception;
}
