package cn.dz.daima.mapper.db1;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper1 {
    @Select("select * from t_s_user")
    public List<Map<String,Object>> search();
}
