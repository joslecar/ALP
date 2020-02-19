import conexionSQL.ConexionSQL
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class MenuPrueba {
    private val root = BorderPane()
    private val contenedorSuperior = VBox()
    private val contenedorBot = HBox()
    private val boton = Button("Hola mundo!")
    private val label = Label()
    private val menuTop = MenuBar()
    constructor(){
        organizarComponentes()
        controlarBoton()
    }

    private fun organizarComponentes(){
        contenedorBot.children.addAll(boton)
        boton.id = "boton"
        boton.stylesheets.add("MenuStyles.css")
        val menu1: Menu = Menu("menu1")
        menu1.id = "menu1"
        val menuItem1: MenuItem = MenuItem("Item1")
        menuItem1.setOnAction { e->
            run {
                val alert = Alert(Alert.AlertType.CONFIRMATION)
                alert.headerText = "Confirmation"
                alert.contentText = "HOLA"+e.source.toString()
                alert.showAndWait()
            }
        }
        var menuItem2: MenuItem = MenuItem("Item2")
        menu1.items.addAll(menuItem1,menuItem2)
        val menuItem11 = MenuItem("Item1")
        val menuItem22 = MenuItem("Item2")
        val menu2 = Menu("menu2")
        menu2.items.addAll(menuItem11,menuItem22)
        menuTop.menus.addAll(menu1,menu2)
        contenedorSuperior.children.addAll(menuTop)
        root.top = contenedorSuperior
        root.center = label
        root.bottom = contenedorBot
    }
    fun controlarBoton(){
        boton.setOnAction { e ->
            run {
                println("HEY!")
                val cn:Connection = ConexionSQL().ConnectionSQL()
                val s:Statement = cn.createStatement()
                val result:ResultSet = s.executeQuery("select * from alptabla where " +
                        "master=(select codigo from alptabla where nomtag='I_Vende') and len(ltrim(rtrim(sgrupo)))>0")
                while(result.next()){
                    println(result.getString("nombre"))
                    label.text += result.toString()+"\n"
                }


            }
        }
    }
    fun getRoot():BorderPane{
        return root;
    }
}