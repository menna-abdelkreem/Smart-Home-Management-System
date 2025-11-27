package Model;

public class Light extends Device {
         private int brightness;
         private String color;

    public Light(int id, String name, String location, double powerUsage, int brightness, String color) {
        super(id, name, location, powerUsage);
        this.brightness = brightness;
        this.color = color;
    }

    public void setBrightness(int value) {
      if (value< 0){
          value = 0;
      }
      if (value > 100) {
          value = 100;
      }
      this.brightness = value;
    }

    public int getBrightness() {
        return brightness;
    }

    public void increaseBrightness(){
        brightness += 10;
        if (brightness >100 ) brightness = 100;
    }
    public void decreaseBright(){
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
        return "Light:" + name + "|" + (isOn ? "ON" : "OFF") +
                "| Brightness: " + brightness + "% | Color:" +
                color ;
    }

}
