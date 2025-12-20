package Model;

public class Light extends Device {
         private int brightness;
         private String color;

    public Light(int id, String name, String location, double powerUsage, boolean isOn, int brightness, String color) {
        super(id, name, location, powerUsage, isOn,"Light");
        this.brightness = brightness;
        this.color = color;
    }

    public void setBrightness(int brightness) {
      if (brightness< 0){
          brightness = 0;
      }
      if (brightness > 100) {
          brightness = 100;
      }
      this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void increaseBrightness(){
        brightness += 10;
        if (brightness >100 ) brightness = 100;
    }
    public void decreaseBrightness(){
        brightness -= 10;
        if (brightness < 0) brightness =0;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getStatus() {
        return "Light:" + getName() + "|" + (isOn ? "ON" : "OFF") +
                "| Brightness: " + brightness + "% | Color:" +
                color ;
    }

}
