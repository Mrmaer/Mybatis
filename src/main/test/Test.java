

import com.bean.Bean;
import com.mapper.Useperson;
import com.sqlsession.GetSqlsession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = GetSqlsession.getSession();
        Useperson mapper = sqlSession.getMapper(Useperson.class);
        try {
            List<Bean> person= mapper.all();
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
