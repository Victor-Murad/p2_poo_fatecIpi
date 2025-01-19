import java.io.FileInputStream;
import java.io.File;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory{
    private static Properties properties;
    static{
        try{
            properties = new Properties();
            properties.load(new FileInputStream(new File("conf.properties")));
        }
        catch(Exception e){
            System.exit(1);
        }
    }
    public static java.sql.Connection conectar () throws Exception{
        String host = properties.getProperty("DB_HOST");
        String port = properties.getProperty("DB_PORT");
        String name = properties.getProperty("DB_NAME");
        String user = properties.getProperty("DB_USER");
        String password = properties.getProperty("DB_PASSWORD");
        String s = String.format("jdbc:postgresql://%s:%s/%s", host, port, name);
        var conexao = DriverManager.getConnection(s, user, password);
        return conexao;
    }
}