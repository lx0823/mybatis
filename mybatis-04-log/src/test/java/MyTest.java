import com.github.pagehelper.PageHelper;
import com.lx.dao.UserMapper;
import com.lx.pojo.User;
import com.lx.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {

    Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void getUserList(){
        /* 获取sqlSession */
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = mapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.commit();
            }
        }
    }


    @Test
    public void testLog4j(){
        logger.info("info");

        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }

        logger.error("error");
    }

    @Test
    public void getUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap map = new HashMap();
            map.put("startIndex",0);
            map.put("endIndex",5);
            List userLimit = mapper.getUserLimit(map);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            RowBounds rowBounds = new RowBounds(0,5);

            List<User> userList = sqlSession.selectList("com.lx.dao.UserMapper.getUserByRowBounds", null, rowBounds);

            System.out.println(userList.size());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void getUserByPageHelper(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            PageHelper.startPage(1,10);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = mapper.getUserByPageHelper();
            System.out.println(userList.size());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
