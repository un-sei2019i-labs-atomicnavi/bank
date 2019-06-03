package first.program.bank1.data_Acces.repositories;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class config extends OrmLiteConfigUtil {
    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("orm_config.txt");
    }
}
