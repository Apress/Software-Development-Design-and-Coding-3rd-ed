import java.awt.*;

public class StateManager
{
 private State currentState;
 RectState rState;
 ArrowState aState;
 CircleState cState;
 FillState fState;

 public StateManager(Mediator med)
 {
  rState = new RectState(med);
  cState = new CircleState(med);
  aState = new ArrowState(med);
  fState = new FillState(med);
  currentState = aState;
 }
 public void setRect()
 {
    currentState = rState;
 }
 public void setCircle()
 {
    currentState = cState;
 }
 public void setFill()
 {
    currentState = fState;
 }
 public void setArrow()
 {
    currentState = aState;
 }
 public void mouseDown(int x, int y)
 {
    currentState.mouseDown(x, y);
 }
 public void mouseUp(int x, int y)
 {
    currentState.mouseUp(x, y);
 }
 public void mouseDrag(int x, int y)
 {
    currentState.mouseDrag(x, y);
 }
 public void select(Drawing d, Color c)
 {
    currentState.select(d, c);
 }
}
