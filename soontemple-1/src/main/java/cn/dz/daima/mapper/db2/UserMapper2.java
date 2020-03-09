package cn.dz.daima.mapper.db2;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper2 {
    @Select("select * from wx_group")
    public List<Map<String,Object>> search();
}
