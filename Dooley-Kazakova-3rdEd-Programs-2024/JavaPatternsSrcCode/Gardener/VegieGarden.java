public class VegieGarden extends Garden
{
   public Plant getShade()
   {
      return new Plant("Broccoli");
   }
 public Plant getCenter()
 {
    return new Plant("Corn");
 }
 public Plant getBorder()
 {
    return new Plant("Peas");
 }

}
