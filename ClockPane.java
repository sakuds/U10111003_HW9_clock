
//U10111003朱永捷

import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private int addH = 0;
	private int addM = 0;
  
	/** Construct a default clock with the current time*/
	public ClockPane() {
	}

	/** Construct a clock with specified hour, minute, and second */
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	/** Return hour */
	public int getHour() {
		return hour;
	}

	/** Set a new hour */
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	/** Return minute */
	public int getMinute() {
		return minute;
	}

	/** Set a new minute */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	/** Return second */
	public int getSecond() {
		return second;
	}

	/** Set a new second */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	/** Set to add hour */
	public void setAddH(int H) {
		// Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
		this.addH = H;
		this.hour = calendar.get(Calendar.HOUR_OF_DAY) + addH;
		paintClock();
	}

	/** Set to add minute */
	public void setAddM(int M) {
		// Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
		this.addM = M;
		this.minute = calendar.get(Calendar.MINUTE) + addM;
		paintClock();
	}
  
	/* Set the current time for the clock */
	public void setCurrentTime() {
		// Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();

		// Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY) + addH;
		this.minute = calendar.get(Calendar.MINUTE) + addM;
		this.second = calendar.get(Calendar.SECOND);
    
		paintClock(); // Repaint the clock
	}
  
	/** Paint the clock */
	private void paintClock() {
		// Initialize clock parameters
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
    		double centerX = getWidth() / 2;
    		double centerY = getHeight() / 2;

		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		// add
		Text t5 = new Text(centerX + clockRadius - 25, centerY -40, "2");
		Text t6 = new Text(centerX + clockRadius - 60, centerY -75, "1");
		Text t7 = new Text(centerX + clockRadius - 25, centerY +50, "4");
		Text t8 = new Text(centerX + clockRadius - 55, centerY +80, "5");
		Text t9 = new Text(centerX - clockRadius + 15, centerY -40, "10");
		Text t10 = new Text(centerX - clockRadius + 50, centerY -75, "11");
    		Text t11 = new Text(centerX - clockRadius + 15, centerY +45, "8");
		Text t12 = new Text(centerX - clockRadius + 45, centerY +80, "7");

		// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);

		// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);
    
		// Draw hour hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength *Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
    
		getChildren().clear();  
		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
		getChildren().addAll(t5,t6,t7,t8,t9,t10,t11,t12);
	}
  
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
	}
  
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}
}
