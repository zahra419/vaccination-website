/*package com.example.demo.config;
import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.stereotype.Component;

@Component
public class ConnectionTest {

    private final DataSource dataSource;

    public ConnectionTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void testConnection() throws Exception {
        System.out.println(
            "Connected to DB: " +
            dataSource.getConnection().getMetaData().getURL()
        );
    }
}
*/