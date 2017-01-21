    int up = 0;
    int down = 0;
    int left = 0;
    int right = 0;
    int shoot = 0;
    
    void setup(){
      Serial.begin(9600);
      pinMode(3,INPUT);
      pinMode(4,INPUT);
      pinMode(7,INPUT);
      pinMode(9,INPUT);
      pinMode(11,INPUT);
    }
    
    void loop(){
      up = digitalRead(9);
      down = digitalRead(3);
      left = digitalRead(4);
      right = digitalRead(11);
      shoot = digitalRead(7);
      
      if (up == LOW){
        Serial.println("OFF");
      }
      else if (up == HIGH){
        Serial.println ("ON");
      }
      else if (down == HIGH){
        Serial.println("DOWN");
      }
      else if (left == HIGH){
        Serial.println("LEFT");
      }
      else if (right == HIGH){
        Serial.println("RIGHT");
      }
      else if (shoot == HIGH){
        Serial.println("SHOOT");
      }
       
    }
