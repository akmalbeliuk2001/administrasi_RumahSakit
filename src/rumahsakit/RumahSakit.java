/*
TEST
 */
package rumahsakit;

/**
 *
 * @author X230
 */

public class RumahSakit {

    /**
     * @param args the command line arguments
     */
    
    private String call; // private = restricted access

    // Getter
    public String getCall() {
      return call;
    }

    // Setter
    public void setCall(String newCall) {
      this.call = newCall;
    }
    
    public static void main(String[] args) {
        
        RumahSakit obj = new RumahSakit();
        obj.setCall("Login");
        
        if(obj.getCall() == "Login"){
            new login().setVisible(true);
        }
        
        
    }
    
}
