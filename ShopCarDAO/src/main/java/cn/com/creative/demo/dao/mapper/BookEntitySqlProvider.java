package cn.com.creative.demo.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.creative.demo.entity.BookEntity;

public class BookEntitySqlProvider {

    public String insertSelective(BookEntity record) {
        BEGIN();
        INSERT_INTO("crt_book");
        
        if (record.getBkId() != null) {
            VALUES("bk_id", "#{bkId,jdbcType=INTEGER}");
        }
        
        if (record.getBkName() != null) {
            VALUES("bk_name", "#{bkName,jdbcType=VARCHAR}");
        }
        
        if (record.getBkImage() != null) {
            VALUES("bk_image", "#{bkImage,jdbcType=VARCHAR}");
        }
        
        if (record.getBkPrice() != null) {
            VALUES("bk_price", "#{bkPrice,jdbcType=DOUBLE}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BookEntity record) {
        BEGIN();
        UPDATE("crt_book");
        
        if (record.getBkName() != null) {
            SET("bk_name = #{bkName,jdbcType=VARCHAR}");
        }
        
        if (record.getBkImage() != null) {
            SET("bk_image = #{bkImage,jdbcType=VARCHAR}");
        }
        
        if (record.getBkPrice() != null) {
            SET("bk_price = #{bkPrice,jdbcType=DOUBLE}");
        }
        
        WHERE("bk_id = #{bkId,jdbcType=INTEGER}");
        
        return SQL();
    }
}