import conexionSQL.ConexionSQL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //primaryStage.setFullScreen(true);
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(new MenuPrueba().getRoot()));
        primaryStage.show();
        ConexionSQL sql = new ConexionSQL();
        Connection cn = sql.ConnectionSQL();
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("select * from alptabla where master=(select codigo from alptabla where nomtag='I_Vende')  and len(ltrim(rtrim(sgrupo)))>0");
        System.out.println(rs);
    }
}
