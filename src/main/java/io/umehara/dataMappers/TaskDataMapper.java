package io.umehara.dataMappers;

import io.umehara.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDataMapper {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDataMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM tasks ORDER BY created_at DESC",
                (rs, rowNum) -> new Task(rs.getString("name"))
        );
    }
}
