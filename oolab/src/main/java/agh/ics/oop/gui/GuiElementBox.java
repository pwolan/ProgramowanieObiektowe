package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import agh.ics.oop.Vector2d;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class GuiElementBox {
    private VBox container;

    public GuiElementBox(IMapElement element) {

        if(element == null){
            Label label = new Label(" ");
            VBox container = new VBox();
            this.container = container;
            container.getChildren().add(label);
            return;
        }
        ImageView imageView = null;
        try {
            String path = element.getFileName() + ".png";
            InputStream stream = getClass().getResourceAsStream("/" + path);
            if (stream == null)
                throw new FileNotFoundException("/" + path);
            Image image = new Image(stream);

            imageView = new ImageView(image);
            imageView.setFitWidth(25);
            imageView.setFitHeight(25);
        } catch (FileNotFoundException ex){
            System.out.println("Error: File not Found! " + ex.getMessage());
        }

        Label label = new Label(element.getLabelText());
        label.setFont(new Font(10));
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        this.container = container;
        if(imageView != null)
            container.getChildren().add(imageView);
        container.getChildren().add(label);

    }
    void renderElement(GridPane rootElement, int x, int y){
        rootElement.add(this.container,x, y );
    }
}
