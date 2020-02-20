package controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import tornadofx.View
import tornadofx.add
import java.net.URL
import java.util.*



class menuPrincipal: Initializable{
    //override val tabPane1:TabPane by fxml()
    @FXML var menu : MenuBar = MenuBar()
    @FXML lateinit var tabPane: TabPane
    @FXML lateinit var scroll: ScrollPane
    val listaModulos:MutableList<String> = mutableListOf("Modulo 1", "Modulo 2", "Modulo 3", "Modulo 4")
    val listaSide1:MutableList<String> = mutableListOf("Modulo Side 1", "Modulo Side 2", "Modulo Side 3", "Modulo Side 4")
    val opciones1: MutableList<String> = mutableListOf("Opcion1", "Opcion2","Opcion3")
    val listaSide2:MutableList<String> = mutableListOf("Modulo Side 21", "Modulo Side 22", "Modulo Side 23", "Modulo Side 24")
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        agregarPestañas()
    }
    fun agregarPestañas(){
        tabPane.tabs.clear()
        listaModulos.forEach(){
            var tab:Tab = Tab(it)
            tab.setOnSelectionChanged { e->
                generarMenu()
            }
            tabPane.tabs.add(tab)

        }
    }
    fun generarMenu(){
        var anchor:AnchorPane = scroll.content as AnchorPane
        var acordion:Accordion = anchor.children.get(0) as Accordion
        acordion.panes.clear()
        when(tabPane.selectionModel.selectedItem.text){
            "Modulo 1" -> {
                listaSide1.forEach(){ s ->
                    var opcion:TitledPane = TitledPane()
                    opcion.text =  s
                    var contenido:VBox = VBox()
                    opciones1.forEach(){
                        var label = Label(it)
                        label.setOnMouseClicked {print("HEY %{it}")}
                        contenido.children.addAll(label)
                    }
                    opcion.content = contenido
                    acordion.panes.add(opcion)
                }
            }
            "Modulo 2" -> {

            }
            "Modulo 3" -> {

            }

        }
    }

}