interface Shape{

    String getShapeInfo();
}

class Circle implements Shape{

    private double radius;
    private String name;

    Circle(double radius){
        this.name = "Circle";
        this.radius = radius;
    }

    public void resize(double newRadius)
    {
        this.radius = newRadius;
    }

    @Override
    public String getShapeInfo() {

        return "This is a " + name + " with " + radius + " unit radius";
    }

}



class Rectangle implements Shape{

    private double width;
    private double height;
    private String name;

    Rectangle(double width, double height){
        this.name = "Ractangle";
        this.width = width;
        this.height = height;
    }
    @Override
    public String getShapeInfo() {

        return "This is a " + name + " with height: " + height + " and width:" + width;
    }

}



/*
 * We may want coloredShapes like: coloredRectangle, coloredCircle, etc...
 * We may want to have transparentRectangle, transparentCircle, etc.
 * We may want to have coloredTransparentRectangle, etc...
 * */


// So, we are going to build decorator classes; here is one for you

class ColoredShape implements Shape{

    Shape localShape;
    String color;

    ColoredShape(Shape ls, String color)
    {
        localShape = ls;
        this.color = color;
    }


    @Override
    public String getShapeInfo() {

        return localShape.getShapeInfo() + " that has " + color + " color";
    }
}

class TransparentShape implements Shape{

    Shape localShape;
    double transparency;

    TransparentShape(Shape ls, double transparency)
    {
        localShape = ls;
        this.transparency = transparency;
    }


    @Override
    public String getShapeInfo() {

        return localShape.getShapeInfo() + " that has " + transparency + "% transparency.";
    }
}

public class TestDecorator {


    public static void main(String[] args) {

        // create a circle 'c1' with radius = 5 unit

        Circle c1 = new Circle(5);

        // create a rectangle 'c2' with width = 5 unit and height = 7

        Rectangle c2 = new Rectangle(5, 7);

        // create a green colored circle 'gc1' with radius = 5

        ColoredShape gc1 = new ColoredShape(new Circle(5) ,"green");

        // create a red rectangle 'rr1' with width = 2 and height = 3

        ColoredShape rr1 = new ColoredShape(new Rectangle(2, 3), "red");

        // create a new decorator class TransparentShape that composes a shape object and
        // has an integer parameter to assign the transparency value (in percentage).

        // now create a red circle (with 20% transparency) whose radius is 10 unit. call it x.

        ColoredShape x = new ColoredShape(new TransparentShape(new Circle(10), .20), "red");

        // change the radius of x to 5 unit.

        // x.resize(5);

        Shape[] shapeArray = new Shape[2];

        shapeArray[0] = c1;
        shapeArray[1] = c2;
        //shapeArray[3] = gc1;
        //shapeArray[4] = rr1;
        // shapeArray[5] = x;

        for (Shape shape : shapeArray) {
            System.out.println(shape.getShapeInfo());
        }
        /** extra to-do (if time permits):
         *  Add a new decorator class that can be used to create a shape with different dimensions
         *  Example: A 2D Rectangle, A 3D Red Triangle, A 3D Blue 10% transparent Rectangle, etc.
         *  Now create two such objects and print their information.
         */

        // copy and paste the line of code you have written (just the TransparentShape class and
        // TestDecoratorForClass on the discussion page.

    }

}
