import java.awt.*;
public class checkCommand extends Checkbox
      implements Command
{
   Command cmd;
   public checkCommand(String caption, CheckboxGroup grp, Command comd)
   {
      super(caption, grp, false);
      cmd  = comd;
   }
   public void Execute()
   {
      cmd.Execute();
   }
}
