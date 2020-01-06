#define PIN_BUTON_F1 2
#define PIN_BUTON_F2 3
#define PIN_BUTON_F3 4
#define PIN_FUNCTIE_INCALZIRE_AMBIENTALA 41
#define PIN_FUNCTIE_INCALZIRE_APA 45
#define PIN_SENZOR_PREZENTA_FLACARA 31
#define PIN_SENZOR_PRESIUNE_GAZ 16
#define PIN_SENZOR_TEMPERATURA_APA_DIN_CIRCUITUL_DE_CALDURA 14
#define PIN_SENZOR_TEMPERATURA_AMBIENTALA 15
#define PIN_SERVOVANA_GAZ 20
#define PIN_GENERATOR_SCANTEIE 7
#define PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA 44
#define PIN_7_SEG_DA 9
#define PIN_7_SEG_DB 14
#define PIN_7_SEG_DC 10
#define PIN_7_SEG_DD 12
#define PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_HIGH 11
#define PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_LOW 18
#define PIN_7_SEG_SELECT_PANOU_DE_COMANDA_HIGH 6
#define PIN_7_SEG_SELECT_PANOU_DE_COMANDA_LOW 5
#define PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_HIGH 0
#define PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_LOW 21
#define PIN_SENZOR_STARE_ROBINET_APA 53
#define PIN_LED_I1 15
#define PIN_LED_I2 17
#define PIN_LED_I3 8

void initializareSistem();

bool stareAnterioaraButonF1 = false;
bool stareAnterioaraButonF2 = false;
bool stareAnterioaraButonF3 = false;
bool stareAnterioaraFunctieIncalzireAmbientala = false;
bool stareAnterioaraFunctieIncalzireApa = false;
bool stareAnterioaraSenzorPrezentaFlacara = false;
bool stareAnterioaraSenzorPresiuneGaz = false;
short stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura = 255;
short stareAnterioaraSenzorTemperaturaAmbientala = 255;
bool stareAnterioaraServovanaGaz = false;
bool stareAnterioaraGeneratorScanteie = false;
bool stareAnterioaraPompaApaACircuituluiDeCaldura = false;
bool stareAnterioara7SegDa = false;
bool stareAnterioara7SegDb = false;
bool stareAnterioara7SegDc = false;
bool stareAnterioara7SegDd = false;
byte stareAnterioaraIndicatorTemparaturaApaDinCircuitulDeCaldura = 255;
byte stareAnterioaraIndicatorPanaouComanda = 255;
byte stareAnterioaraIndicatorTemparaturaAmbientala = 255;
bool stareAnterioaraSenzorStareRobinetApa = false;
bool stareAnterioaraLedI1 = false;
bool stareAnterioaraLedI2 = false;
bool stareAnterioaraLedI3 = false;

void initPins() {
  pinMode(PIN_BUTON_F1,INPUT_PULLUP);
  pinMode(PIN_BUTON_F2,INPUT_PULLUP);
  pinMode(PIN_BUTON_F3,INPUT_PULLUP);
  pinMode(PIN_FUNCTIE_INCALZIRE_AMBIENTALA,OUTPUT);
  pinMode(PIN_FUNCTIE_INCALZIRE_APA,OUTPUT);
  pinMode(PIN_SENZOR_PREZENTA_FLACARA,INPUT);
  pinMode(PIN_SENZOR_PRESIUNE_GAZ,INPUT);
  //pinMode(PIN_SENZOR_TEMPERATURA_APA_INTRARE,);
  //pinMode(PIN_SENZOR_TEMPERATURA_APA_REFERINTA,);
  pinMode(PIN_SERVOVANA_GAZ,OUTPUT);
  pinMode(PIN_GENERATOR_SCANTEIE,OUTPUT);
  pinMode(PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA,OUTPUT);
  pinMode(PIN_7_SEG_DA,OUTPUT);
  pinMode(PIN_7_SEG_DB,OUTPUT);
  pinMode(PIN_7_SEG_DC,OUTPUT);
  pinMode(PIN_7_SEG_DD,OUTPUT);
  pinMode(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_HIGH,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_HIGH, HIGH );
  pinMode(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_LOW,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_LOW, HIGH );
  pinMode(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_HIGH,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_HIGH, HIGH );
  pinMode(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_LOW,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_LOW, HIGH );
  pinMode(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_HIGH,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_HIGH, HIGH );
  pinMode(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_LOW,OUTPUT);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_LOW, HIGH );
  pinMode(PIN_SENZOR_STARE_ROBINET_APA,INPUT);
  pinMode(PIN_LED_I1,OUTPUT);
  pinMode(PIN_LED_I2,OUTPUT);
  pinMode(PIN_LED_I3,OUTPUT);

}

void setFunctieIncalzireAmbientala(bool state){
  
  if(state)
  {
    digitalWrite(PIN_FUNCTIE_INCALZIRE_AMBIENTALA, HIGH);
    if(!stareAnterioaraFunctieIncalzireAmbientala)
      Serial.println("Functia de incalzire ambientala e activa.");
  }
  else
  {
    digitalWrite(PIN_FUNCTIE_INCALZIRE_AMBIENTALA, LOW);
    if(stareAnterioaraFunctieIncalzireAmbientala)
      Serial.println("Functia de incalzire ambientala e inactiva.");
  }

  stareAnterioaraFunctieIncalzireAmbientala = state;
}

void setFunctieIncalzireApa(bool state){

  if(state)
  {
    digitalWrite(PIN_FUNCTIE_INCALZIRE_APA, HIGH);
    if(!stareAnterioaraFunctieIncalzireApa)
      Serial.println("Functia de incalzire apa e activa.");
  }
  else
  {
    digitalWrite(PIN_FUNCTIE_INCALZIRE_APA, LOW);
    if(stareAnterioaraFunctieIncalzireApa)
      Serial.println("Functia de incalzire apa e inactiva.");
  }

  stareAnterioaraFunctieIncalzireApa = state;
}

void setServovanaGaz(bool state){
  
  if(state)
  {
    digitalWrite(PIN_SERVOVANA_GAZ, HIGH);
    if(!stareAnterioaraServovanaGaz)
      Serial.println("Servovana de gaz e pornita.");
  }
  else
  {
    digitalWrite(PIN_SERVOVANA_GAZ, LOW);
    if(stareAnterioaraServovanaGaz)
      Serial.println("Servovana de gaz e oprita.");
  }

  stareAnterioaraServovanaGaz = state;
}

void setGeneratorScanteie(bool state){
  
  if(state)
  {
    digitalWrite(PIN_GENERATOR_SCANTEIE, HIGH);
    if(!stareAnterioaraGeneratorScanteie)
      Serial.println("Generatorul de scanteie e pornit.");
  }
  else
  {
    digitalWrite(PIN_GENERATOR_SCANTEIE, LOW);
    if(stareAnterioaraGeneratorScanteie)
      Serial.println("Generatorul de scanteie e oprit.");
  }

  stareAnterioaraGeneratorScanteie = state;
}

void setPompaApaACircuituluiDeCaldura(bool state){
  
  if(state)
  {
    //digitalWrite(PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA, HIGH);
    analogWrite(PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA,255);
    if(!stareAnterioaraPompaApaACircuituluiDeCaldura)
      Serial.println("Pompa de apa a circuitului de caldura e pornita.");
  }
  else
  {
    //digitalWrite(PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA, LOW);
    analogWrite(PIN_POMPA_APA_A_CIRCUITULUI_DE_CALDURA,0);
    if(stareAnterioaraPompaApaACircuituluiDeCaldura)
      Serial.println("Pompa de apa a circuitului de caldura e oprita.");
  }

  stareAnterioaraPompaApaACircuituluiDeCaldura = state;
}

void setIndicatorI1(bool state){
  
  if(state)
  {
    digitalWrite(PIN_LED_I1, HIGH);
    if(!stareAnterioaraLedI1)
      Serial.println("Indicatorul I1 e activ.");
  }
  else
  {
    digitalWrite(PIN_LED_I1, LOW);
    if(stareAnterioaraLedI1)
      Serial.println("Servovana I1 e inactiva.");
  }

  stareAnterioaraLedI1 = state;
}

void setIndicatorI2(bool state){
  
  if(state)
  {
    digitalWrite(PIN_LED_I2, HIGH);
    if(!stareAnterioaraLedI2)
      Serial.println("Indicatorul I2 e activ.");
  }
  else
  {
    digitalWrite(PIN_LED_I2, LOW);
    if(stareAnterioaraLedI2)
      Serial.println("Servovana I2 e inactiva.");
  }

  stareAnterioaraLedI2 = state;
}

void setIndicatorI3(bool state){
  
  if(state)
  {
    digitalWrite(PIN_LED_I3, HIGH);
    if(!stareAnterioaraLedI3)
      Serial.println("Indicatorul I3 e activ.");
  }
  else
  {
    digitalWrite(PIN_LED_I3, LOW);
    if(stareAnterioaraLedI3)
      Serial.println("Indicatorul I3 e inactiv.");
  }

  stareAnterioaraLedI3 = state;
}

bool getButonF1(){
  
  bool stareCurenta1 = !digitalRead(PIN_BUTON_F1);
  delay(60);
  bool stareCurenta2 = !digitalRead(PIN_BUTON_F1);
  
  if(stareCurenta1 != stareCurenta2)
    return stareAnterioaraButonF1;

  if((!stareAnterioaraButonF1)&&(stareCurenta1)){
    Serial.println("S-a apasat butonul F1.");
  }

  stareAnterioaraButonF1 = stareCurenta1;
  
  return stareAnterioaraButonF1;
}

bool getButonF2(){
   bool stareCurenta = !digitalRead(PIN_BUTON_F2);

  if((!stareAnterioaraButonF2)&&(stareCurenta))
    Serial.println("S-a apasat butonul F2.");

  stareAnterioaraButonF2 = stareCurenta;
  
  return stareCurenta;
}

bool getButonF3(){
   bool stareCurenta = !digitalRead(PIN_BUTON_F3);

  if((!stareAnterioaraButonF3)&&(stareCurenta))
    Serial.println("S-a apasat butonul F3.");

  stareAnterioaraButonF3 = stareCurenta;
  
  return stareCurenta;
}

bool getSenzorPrezentaFlacara(){
   bool stareCurenta1 = !digitalRead(PIN_SENZOR_PREZENTA_FLACARA);
   delay(60);
   bool stareCurenta2 = !digitalRead(PIN_SENZOR_PREZENTA_FLACARA);

   if(stareCurenta1 != stareCurenta2)
    return stareAnterioaraSenzorPrezentaFlacara;

  if((!stareAnterioaraSenzorPrezentaFlacara)&&(stareCurenta1))
    Serial.println("S-a aprins flacara.");
  
  if((stareAnterioaraSenzorPrezentaFlacara)&&(!stareCurenta1))
    Serial.println("S-a stins flacara.");

  stareAnterioaraSenzorPrezentaFlacara = stareCurenta1;
  
  return stareCurenta1;
}

bool getSenzorPresiuneGaz(){
   bool stareCurenta1 = !digitalRead(PIN_SENZOR_PRESIUNE_GAZ);
   delay(60);
   bool stareCurenta2 = !digitalRead(PIN_SENZOR_PRESIUNE_GAZ);

   if(stareCurenta1 != stareCurenta2)
    return stareAnterioaraSenzorPresiuneGaz;

  if((!stareAnterioaraSenzorPresiuneGaz)&&(stareCurenta1))
    Serial.println("A crescut presiunea la gaz peste valoarea nominala.");

  if((stareAnterioaraSenzorPresiuneGaz)&&(!stareCurenta1))
    Serial.println("A scazut presiunea la gaz sub valoarea nominala.");

  stareAnterioaraSenzorPresiuneGaz = stareCurenta1;
  
  return stareCurenta1;
}

bool getSenzorStareRobinetApa(){
  
  bool stareCurenta1 = !digitalRead(PIN_SENZOR_STARE_ROBINET_APA);
  delay(60);
  bool stareCurenta2 = !digitalRead(PIN_SENZOR_STARE_ROBINET_APA);
  
  if(stareCurenta1 != stareCurenta2)
    return stareAnterioaraSenzorStareRobinetApa;
  
  if((!stareAnterioaraSenzorStareRobinetApa)&&(stareCurenta1))
    Serial.println("S-a deschis robinetul de apa.");
  
  if((stareAnterioaraSenzorStareRobinetApa)&&(!stareCurenta1))
    Serial.println("S-a închis robinetul de apa.");
  
  stareAnterioaraSenzorStareRobinetApa = stareCurenta1;
  
  return stareCurenta1;
}

void set7SegDataLines(int bcdValue) {

  switch (bcdValue) {
    case 0:
      digitalWrite(PIN_7_SEG_DA, LOW );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 1:
      digitalWrite(PIN_7_SEG_DA, HIGH );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 2:
      digitalWrite(PIN_7_SEG_DA, LOW );
      digitalWrite(PIN_7_SEG_DB, HIGH );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 3:
      digitalWrite(PIN_7_SEG_DA, HIGH );
      digitalWrite(PIN_7_SEG_DB, HIGH );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 4:
      digitalWrite(PIN_7_SEG_DA, LOW );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, HIGH );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 5:
      digitalWrite(PIN_7_SEG_DA, HIGH );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, HIGH );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 6:
      digitalWrite(PIN_7_SEG_DA, LOW );
      digitalWrite(PIN_7_SEG_DB, HIGH );
      digitalWrite(PIN_7_SEG_DC, HIGH );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 7:
      digitalWrite(PIN_7_SEG_DA, HIGH );
      digitalWrite(PIN_7_SEG_DB, HIGH );
      digitalWrite(PIN_7_SEG_DC, HIGH );
      digitalWrite(PIN_7_SEG_DD, LOW );
    break;
    
    case 8:
      digitalWrite(PIN_7_SEG_DA, LOW );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, HIGH );
    break;
    
    case 9:
      digitalWrite(PIN_7_SEG_DA, HIGH );
      digitalWrite(PIN_7_SEG_DB, LOW );
      digitalWrite(PIN_7_SEG_DC, LOW );
      digitalWrite(PIN_7_SEG_DD, HIGH );
    break;
  }

}


void setIndicatorTemparaturaApaDinCircuitulDeCaldura(byte value) {

  if(value > 99) {
    Serial.print("Nu se poate seta indicatorul de temperatura apa din circuitul de caldura la valoarea ");
    Serial.print(value);
    Serial.println(" deoarece aceasta este mai mare de 99. Aplicatia trebuie repornita.");
    
    for(;;);
  }
  
  if(value == stareAnterioaraIndicatorTemparaturaApaDinCircuitulDeCaldura)
    return;
//  else
//  {
//     Serial.print("Indicatorul de temperatura al apei din circuitul de caldura afiseaza ");
//     Serial.print(value);
//     Serial.println(".");
//  }

  stareAnterioaraIndicatorTemparaturaApaDinCircuitulDeCaldura = value;
  
  set7SegDataLines(value%10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_LOW, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_LOW, HIGH );
  delay(10);
  
  set7SegDataLines(value/10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_HIGH, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_APA_DIN_CIRCUITUL_DE_CALDURA_HIGH, HIGH );
  delay(10);

}

void setIndicatorPanaouComanda(byte value) {

  if(value > 99) {
    Serial.print("Nu se poate seta indicatorul de pe panoul de comanda la valoarea ");
    Serial.print(value);
    Serial.println(" deoarece aceasta este mai mare de 99. Aplicatia trebuie repornita.");
    
    for(;;);
  }

  if(value == stareAnterioaraIndicatorPanaouComanda)
    return;
    else
  {
     Serial.print("Indicatorul de pe panoul de comanda afiseaza ");
     Serial.print(value);
     Serial.println(".");
  }

  stareAnterioaraIndicatorPanaouComanda = value;

  
  set7SegDataLines(value%10);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_LOW, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_LOW, HIGH );
  delay(10);
  
  set7SegDataLines(value/10);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_HIGH, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_PANOU_DE_COMANDA_HIGH, HIGH );
  delay(10);

}


void setIndicatorTemparaturaAmbientala(byte value) {

  if(value > 99) {
    Serial.print("Nu se poate seta indicatorul de temperatura ambientala la valoarea ");
    Serial.print(value);
    Serial.println(" deoarece aceasta este mai mare de 99. Aplicatia trebuie repornita.");
    
    for(;;);
  }

  
  if(value == stareAnterioaraIndicatorTemparaturaAmbientala)
    return;
    else
  {
     Serial.print("Indicatorul de temperatura ambientala afiseaza ");
     Serial.print(value);
     Serial.println(".");
  }

  stareAnterioaraIndicatorTemparaturaAmbientala = value;
  
  set7SegDataLines(value%10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_LOW, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_LOW, HIGH );
  delay(10);
  
  set7SegDataLines(value/10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_HIGH, LOW );
  delay(10);
  digitalWrite(PIN_7_SEG_SELECT_TEMPARATURA_AMBIENTALA_HIGH, HIGH );
  delay(10);

}

short getTemperaturaApaDinCircuitulDeCaldura()
{
  int currentValue = analogRead(PIN_SENZOR_TEMPERATURA_APA_DIN_CIRCUITUL_DE_CALDURA)/11;;
  
  if((stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura != currentValue)
      &&(stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura-1 != currentValue)
      &&(stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura+1 != currentValue)
      &&(stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura-2 != currentValue)
      &&(stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura+2 != currentValue))
  {
    Serial.print("Temperatura apei din circuitul de caldura este ");
    Serial.println(currentValue);
    stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura = currentValue;
  }

  setIndicatorTemparaturaApaDinCircuitulDeCaldura(stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura);
   
  return stareAnterioaraSenzorTemperaturaApaDinCircuitulDeCaldura;
}

short getTemperaturaAmbientala()
{
  short currentValue = analogRead(PIN_SENZOR_TEMPERATURA_AMBIENTALA);
  
  if(stareAnterioaraSenzorTemperaturaAmbientala != currentValue)
  {
    Serial.print("Temperatura ambientala este ");
    Serial.println(currentValue);
  }
  
  stareAnterioaraSenzorTemperaturaAmbientala = currentValue;
  
  return currentValue;
}

bool timer1ElapsedState = true;
bool timer1ElapsedPreviousState = true;

void initTimer1()
{
  noInterrupts();          
  TCCR1A = 0;
  TCCR1B = 0;
  TCCR1B |= (1 << CS12)|(1 << CS10);    // 1024 prescaler; MCUFreq = 16MHz 
  TIMSK1 |= (1 << TOIE1);               // enable timer overflow interrupt
  interrupts();
}

ISR(TIMER1_OVF_vect)
{
  timer1ElapsedState = true;
}

void startTimer1(word timeOutInMS)
{
  if(timeOutInMS > 4000) {
    Serial.print("Nu se poate porni timer-ul 1 pentru un interval de ");
    Serial.print(timeOutInMS);
    Serial.println("ms deoarece aceasta este mai mare de 4000ms. Aplicatia trebuie repornita.");
    
    for(;;);
  }

  if(timeOutInMS < 500) {
    Serial.print("Nu se poate porni timer-ul 1 pentru un interval de ");
    Serial.print(timeOutInMS);
    Serial.println("ms deoarece aceasta este mai mic de 500ms. Aplicatia trebuie repornita.");
    
    for(;;);
  }
  
  TCNT1 = 65535 - 15 * timeOutInMS;
  timer1ElapsedState = false;
  Serial.print("Timer-ul 1 a pornit cu intervalul ");
  Serial.print(timeOutInMS);
  Serial.println(" ms.");
}

bool hasTimer1Elapsed()
{
  noInterrupts();
  if(timer1ElapsedState&&(!timer1ElapsedPreviousState))
    Serial.println("Timerul 1 a expirat.");

  timer1ElapsedPreviousState = timer1ElapsedState;
  interrupts();
  
  return timer1ElapsedPreviousState;
}

bool timer3ElapsedState = true;
bool timer3ElapsedPreviousState = true;

void initTimer3()
{
  noInterrupts();          
  TCCR3A = 0;
  TCCR3B = 0;
  TCCR3B |= (1 << CS12)|(1 << CS10);    // 1024 prescaler; MCUFreq = 16MHz 
  TIMSK3 |= (1 << TOIE3);               // enable timer overflow interrupt
  interrupts();
}

ISR(TIMER3_OVF_vect)
{
  timer3ElapsedState = true;
}

void startTimer3(word timeOutInMS)
{
  if(timeOutInMS > 4000) {
    Serial.print("Nu se poate porni timer-ul 3 pentru un interval de ");
    Serial.print(timeOutInMS);
    Serial.println("ms deoarece aceasta este mai mare de 4000ms. Aplicatia trebuie repornita.");
    
    for(;;);
  }

  if(timeOutInMS < 500) {
    Serial.print("Nu se poate porni timer-ul 3 pentru un interval de ");
    Serial.print(timeOutInMS);
    Serial.println("ms deoarece aceasta este mai mic de 500ms. Aplicatia trebuie repornita.");
    
    for(;;);
  }
  
  TCNT3 = 65535 - 15 * timeOutInMS;
  timer3ElapsedState = false;
  Serial.print("Timer-ul 3 a pornit cu intervalul ");
  Serial.print(timeOutInMS);
  Serial.println(" ms.");
}

bool hasTimer3Elapsed()
{
  noInterrupts();
  if(timer3ElapsedState&&(!timer3ElapsedPreviousState))
    Serial.println("Timerul 3 a expirat.");

  timer3ElapsedPreviousState = timer3ElapsedState;
  interrupts();
  
  return timer3ElapsedPreviousState;
}

bool timer4ElapsedState = true;
bool timer4ElapsedPreviousState = true;
byte timerSecondsStillToCount = 0;

void initTimer4()
{
  noInterrupts();          
  TCCR4A = 0;
  TCCR4B = 0;
  TCCR4B |= (1 << CS12)|(1 << CS10);    // 1024 prescaler; MCUFreq = 16MHz 
  TIMSK4 |= (1 << TOIE3);               // enable timer overflow interrupt
  interrupts();
}

ISR(TIMER4_OVF_vect)
{
  if(timer4ElapsedState)
    return;
  
  TCNT4 = 65535 - 15 * 1000;

  timerSecondsStillToCount--;

  if(timerSecondsStillToCount == 0)  
    timer4ElapsedState = true;
}

void startTimer4(byte timeOutInS)
{
  if(timeOutInS < 5) {
    Serial.print("Nu se poate porni timer-ul 4 pentru un interval de ");
    Serial.print(timeOutInS);
    Serial.println("S deoarece aceasta este mai mic de 5S. Aplicatia trebuie repornita.");
    
    for(;;);
  }

  timerSecondsStillToCount = timeOutInS;
  
  TCNT4 = 65535 - 15 * 1000;
  timer4ElapsedState = false;
  Serial.print("Timer-ul 4 a pornit cu intervalul ");
  Serial.print(timeOutInS);
  Serial.println("s.");
}

bool hasTimer4Elapsed()
{
  noInterrupts();
  if(timer4ElapsedState&&(!timer4ElapsedPreviousState))
    Serial.println("Timerul 4 a expirat.");

  timer4ElapsedPreviousState = timer4ElapsedState;
  interrupts();
  
  return timer4ElapsedPreviousState;
}

void setup() {
  Serial.begin(9600);
  Serial.println("Aplicatia a pornit.");

  initPins(); 
  initTimer1();
  initTimer3();
  initTimer4();

  initializareSistem();
}

//metode pentru actuatori
//NOT_OK-> void setFunctieIncalzireAmbientala(bool state)
//void setFunctieIncalzireApa(bool state)
//void setServovanaGaz(bool state)
//void setGeneratorScanteie(bool state)
//void setPompaApaACircuituluiDeCaldura(bool state)
//void setIndicatorI3(bool state)

//metode pentru senzori
//bool getButonF1()
//bool getSenzorPrezentaFlacara()
//bool getSenzorPresiuneGaz()
//bool getSenzorStareRobinetApa()

//metode pentru intrari analogice
//short getTemperaturaApaDinCircuitulDeCaldura()

//metode pentru controlul timerelor
//void startTimer1(word timeOutInMS) //timeOutInMS intervalul de timp dupa care timerul expira; valori disponibile [500mS - 4000mS]
//bool hasTimer1Elapsed()
//void startTimer3(word timeOutInMS) //timeOutInMS intervalul de timp dupa care timerul expira; valori disponibile [500mS - 4000mS]
//bool hasTimer3Elapsed()
//void startTimer4(byte timeOutInS) //timeOutInMS intervalul de timp dupa care timerul expira; valori disponibile [5S - 255S]
//bool hasTimer4Elapsed()

//metoda de initializare
//void initializareSistem(); // se apelează o singura data cand porneste sistemul


//Declara starile aici



void initializareSistem()
{
  //initialiseaza sistemul aici

}

void loop() {
  //rezolva problema aici 
    
}
