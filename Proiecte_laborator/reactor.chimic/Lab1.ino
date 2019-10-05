#define PIN_MOTOR 2
#define PIN_Y1 3
#define PIN_Y2 4
#define PIN_INDICATOR_FUNCTIONARE 5
#define PIN_BUTON_START 6
#define PIN_SENZOR_1 8
#define PIN_SENZOR_2 7
#define PIN_SENZOR_3 9
#define PIN_SENZOR_4 10

bool stareAnterioaraMotor=false;
bool stareAnterioaraY1=false;
bool stareAnterioaraY2=false;
bool stareAnteriaraFunctionare=false;

bool stareAnterioaraButonStart=false;
bool stareAnterioaraS1=false;
bool stareAnterioaraS2=false;
bool stareAnterioaraS3=false;
bool stareAnterioaraS4=false;

void initPins() {
  pinMode(PIN_MOTOR, OUTPUT);
  pinMode(PIN_Y1, OUTPUT);
  pinMode(PIN_Y2, OUTPUT);
  pinMode(PIN_INDICATOR_FUNCTIONARE, OUTPUT);

  pinMode(PIN_BUTON_START, INPUT_PULLUP);
  pinMode(PIN_SENZOR_1, INPUT_PULLUP);
  pinMode(PIN_SENZOR_2, INPUT_PULLUP);
  pinMode(PIN_SENZOR_3, INPUT_PULLUP);
  pinMode(PIN_SENZOR_4, INPUT_PULLUP);
}

void setMotor(bool state){
  
  if(state)
  {
    digitalWrite(PIN_MOTOR, HIGH);

    if(!stareAnterioaraMotor)
      Serial.println("Motorul e pornit.");
  }
  else
  {
    digitalWrite(PIN_MOTOR, LOW);
    if(stareAnterioaraMotor)
      Serial.println("Motorul e oprit.");
  }

  stareAnterioaraMotor = state;
}

void setY1(bool state){
  
  if(state)
  {
    digitalWrite(PIN_Y1, HIGH);
    if(!stareAnterioaraY1)
      Serial.println("Servovana Y1 e pornita.");
  }
  else
  {
    digitalWrite(PIN_Y1, LOW);
    if(stareAnterioaraY1)
      Serial.println("Servovana Y1 e oprita.");
  }

  stareAnterioaraY1 = state;
}

void setY2(bool state){
  
  if(state)
  {
    digitalWrite(PIN_Y2, HIGH);
    if(!stareAnterioaraY2)
        Serial.println("Servovana Y2 e pornita.");
  }
  else
  {
    digitalWrite(PIN_Y2, LOW);
    if(stareAnterioaraY2)
        Serial.println("Servovana Y2 e oprita.");
  }

  stareAnterioaraY2 = state;
}

void setIndicatorFunctionare(bool state){
  
  if(state)
  {
    digitalWrite(PIN_INDICATOR_FUNCTIONARE, HIGH);
    if(!stareAnteriaraFunctionare)
      Serial.println("Indicator functionare e pornit.");
  }
  else
  {
    digitalWrite(PIN_INDICATOR_FUNCTIONARE, LOW);
    if(stareAnteriaraFunctionare)
      Serial.println("Indicator functionare e oprit.");
  }

  stareAnteriaraFunctionare = state;
}

bool getButonStart(){
   bool stareCurenta = !digitalRead(PIN_BUTON_START);

  if((!stareAnterioaraButonStart)&&(stareCurenta))
    Serial.println("S-a apasat butonul de start.");

  stareAnterioaraButonStart = stareCurenta;
  
  return stareCurenta;
}

bool getSenzor1(){
  bool stareCurenta = !digitalRead(PIN_SENZOR_1);

  if((!stareAnterioaraS1)&&(stareCurenta))
    Serial.println("S-a activat S1.");

  stareAnterioaraS1 = stareCurenta;
  
  return stareCurenta;
}

bool getSenzor2(){
  bool stareCurenta = !digitalRead(PIN_SENZOR_2);

  if((!stareAnterioaraS2)&&(stareCurenta))
    Serial.println("S-a activat S2.");

  stareAnterioaraS2 = stareCurenta;
  
  return stareCurenta;
}

bool getSenzor3(){
  bool stareCurenta = !digitalRead(PIN_SENZOR_3);

  if((!stareAnterioaraS3)&&(stareCurenta))
    Serial.println("S-a activat S3.");

  stareAnterioaraS1 = stareCurenta;
  
  return stareCurenta;
}

bool getSenzor4(){
  bool stareCurenta = !digitalRead(PIN_SENZOR_4);

  if((!stareAnterioaraS4)&&(stareCurenta))
    Serial.println("S-a activat S4.");

  stareAnterioaraS1 = stareCurenta;
  
  return stareCurenta;
}

void setup() {
  Serial.begin(9600);
  Serial.println("Aplicatia a pornit.");

  initPins(); 

}

//Declara starile aici




void loop() {
  
  //Rezolva problema aici



  
}
