package controllers

import entitys.Usuario
import javafx.event.Event
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Border
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import sample.Main
import java.net.URL
import java.util.*

class LoginCont():Initializable {
    @FXML lateinit var contenedorVBox:VBox
    @FXML lateinit var loginButton: Button
    //val menuPrincipalView:menuPrincipal = menuPrincipal()
    val usuarios:MutableList<Usuario> = mutableListOf(
            Usuario("ID1","sa","Rootpass1","Prueba"),
            Usuario("ID2","sa1","Rootpass1","Prueba1"),
            Usuario("ID3","sa2","Rootpass1","Prueba2")
    )


    override fun initialize(location: URL?, resources: ResourceBundle?) {

        loginButton.setOnAction { e->
           // loginEvent()
            loadView(e)
        }


    }

    fun loginEvent() {


    }
    fun loadView(e:Event){
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/fxml/MenuPrincipal.fxml"))
        val scene:Scene = Scene(root)
        val stage:Stage = (e.source as Node).scene.window as Stage
        stage.scene = scene
        stage.show()

    }

}

