import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

public class MiDibujo extends View {
    private ShapeDrawable miDrawable;
    public MiDibujo(Context c, AttributeSet a) {
        super(c,a);
    }

    protected void onDraw(Canvas c) {
        Paint miPincel = new Paint();
        Paint miPincel2 = new Paint();

        miPincel.setColor(Color.RED);
        miPincel2.setColor(Color.BLUE);

        miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
        miPincel2.setStyle(Paint.Style.FILL_AND_STROKE);

        c.drawRect(130,200,350,420,miPincel);
        c.drawCircle(70,70,50,miPincel2);
        c.drawCircle(410,70,50,miPincel2);
        c.drawCircle(70,600,50,miPincel2);
        c.drawCircle(410,600,50,miPincel2);

            /*
            miPincel.setTextSize(30);
            lienzo.drawText("MI CIRCULO",100,450,miPincel);
            String mensaje="Ancho: " + getWidth()+" Alto: "+ getHeight();
            lienzo.drawText(mensaje,100,500,miPincel);
            Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();
            */
    }
}
