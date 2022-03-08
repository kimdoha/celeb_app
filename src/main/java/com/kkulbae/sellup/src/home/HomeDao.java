package com.kkulbae.sellup.src.home;

import com.kkulbae.sellup.src.home.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class HomeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetCelebRes> getCelebBySearch(String word){
        String getCelebInfoBySearchQuery = "select clbIdx, name, description, job, profileImage\n" +
                                            "from celebs\n"+
                                            "where name IN (?)\n"+
                                            "and isDeleted = 'N'";
        String getCelebInfoBySearchParams = word;
        return this.jdbcTemplate.query(getCelebInfoBySearchQuery,
                (rs, rowNum) -> new GetCelebRes(
                        rs.getInt("clbIdx"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("job"),
                        rs.getString("profileImage")),
                getCelebInfoBySearchParams);

    }

    public int checkCelebIdx(int clbIdx){
        String checkExistCelebQuery = "select exists(select clbIdx from celebs where clbIdx = ? and isDeleted='N')";
        int checkExistCelebParams = clbIdx;
        return this.jdbcTemplate.queryForObject(checkExistCelebQuery,
                int.class,
                checkExistCelebParams);
    }

    public void createTheme(int clbIdx, PostThemeReq postThemeReq){
        String createThemeQuery = "insert into themes(clbIdx, title, themeUrl) VALUES (?,?,?)";
        Object[] createThemeParams = new Object[]{clbIdx, postThemeReq.getTitle(), postThemeReq.getThemeUrl()};
        this.jdbcTemplate.update(createThemeQuery, createThemeParams );
    }


}
