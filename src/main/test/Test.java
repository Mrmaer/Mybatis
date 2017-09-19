

import com.bean.Bean;
import com.mapper.Useperson;
import com.sqlsession.GetSqlsession;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = GetSqlsession.getSession();
        Useperson mapper = sqlSession.getMapper(Useperson.class);
        try {
            List<Bean> person= mapper.all();
            for (Bean p : person){
                System.out.println(p);
            }

            List<String> name = mapper.selectone("小红");
            System.out.println(name);

            Map<String ,Object> m = new HashMap<String, Object>();
            m.put("name","小明");
            m.put("sex","男");
            name = mapper.selecttwo(m);
            System.out.println(name);

            name = mapper.select("小明","男");
            System.out.println(name);

            Bean bean = new Bean();
            bean.setName("小明");
            bean.setSex("男");
            name = mapper.selectBean(bean);
            System.out.println(name);

            name = mapper.selectbean(bean);
            System.out.println(name);


//            添加
//            bean.setName("小飞");
//            bean.setSex("男");
//            int i = mapper.into(bean);
//            System.out.println(i);

//            修改
//            i = mapper.update("小飞","小马");
//            System.out.println(i);

//            删除
//
            int i = mapper.delete("小马");
            System.out.println(i);

             person= mapper.all();
            for (Bean p : person){
                System.out.println(p);
            }

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
