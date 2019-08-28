package cn.com.creative.demo.dao.mapper;

import cn.com.creative.demo.dao.IBookDAO;
import cn.com.creative.demo.entity.BookEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface BookEntityMapper extends IBookDAO {
    @Select("select * from crt_book")
    @ResultMap(value = "bookMap")
    public List<BookEntity> selectAllBooks();

    @Delete({
        "delete from crt_book",
        "where bk_id = #{bkId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bkId);

    @Insert({
        "insert into crt_book (bk_id, bk_name, ",
        "bk_image, bk_price)",
        "values (#{bkId,jdbcType=INTEGER}, #{bkName,jdbcType=VARCHAR}, ",
        "#{bkImage,jdbcType=VARCHAR}, #{bkPrice,jdbcType=DOUBLE})"
    })
    int insert(BookEntity record);

    @InsertProvider(type=BookEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BookEntity record);

    @Select({
        "select",
        "bk_id, bk_name, bk_image, bk_price",
        "from crt_book",
        "where bk_id = #{bkId,jdbcType=INTEGER}"
    })
    @Results(id="bookMap", value = {
        @Result(column="bk_id", property="bkId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bk_name", property="bkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bk_image", property="bkImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="bk_price", property="bkPrice", jdbcType=JdbcType.DOUBLE)
    })
    BookEntity selectByPrimaryKey(Integer bkId);

    @UpdateProvider(type=BookEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BookEntity record);

    @Update({
        "update crt_book",
        "set bk_name = #{bkName,jdbcType=VARCHAR},",
          "bk_image = #{bkImage,jdbcType=VARCHAR},",
          "bk_price = #{bkPrice,jdbcType=DOUBLE}",
        "where bk_id = #{bkId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BookEntity record);
}