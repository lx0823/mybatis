import com.lx.dao.UserMapper;
import com.lx.pojo.User;
import com.lx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mybatis01Test {

    @Test
    public void test(){
        //获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            //获取mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.getUserList();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUser(new User(1,"99","23"));

            //提交事务
            sqlSession.commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String,Object> map = new HashMap<>();
            map.put("id","1");
            map.put("pas","3");

            mapper.addUserByMap(map);

            //提交事务
            sqlSession.commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getUserByLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.getUserByLike("li");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
