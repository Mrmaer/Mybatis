package com.mapper;


import com.bean.Bean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface Useperson {

    public List<Bean> all() throws Exception;

    public List<String> selectone(String name);

    public List<String> selecttwo(Map<String ,Object> map);

    public List<String> select(@Param("name")String name,@Param("sex") String sex);

    public List<String> selectBean(@Param("be") Bean bean);

    public List<String> selectbean(Bean bean);

    public int into(Bean bean);

    public int update(@Param("oldname") String oldname,
                      @Param("newname")String newname);

    public int delete(String name);
}
