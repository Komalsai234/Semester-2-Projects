#include <NewPing.h>
#include <NewTone.h>
#include "Talkie.h"
#include "Vocab_US_Large.h"
#define maxDistance 100

Talkie voice;

const int trg1 = A0,ech1 = 2;
const int trg2 = A1,ech2 = 3;
const int trg3 = A2,ech3 = 4;
const int trg4 = A3,ech4 = 5;

int flameInPin = 2;
int msensor = A1; 
int msvalue = 0;
boolean flag = false; 

const int led = 7, buz = 8;
const int ldri = 9, ldro = A5;
const int ltilti = 10, ltilto = 11;
const int rtilti = 12, rtilto = 13;
const uint8_t scale[] PROGMEM = {239,226,213,201,190,179,169,160,151,142,134,127};

const int sensorMin = 0;
const int sensorMax = 1024;

NewPing sonar1(trg1, ech1, 30);
NewPing sonar2(trg2, ech2, 30);
NewPing sonar3(trg3, ech3, 30);
NewPing sonar4(trg4, ech4, 30);


long dist1;
long dist2;
long dist3;
long dist4;

long light;
bool  ltilt,rtilt;

void setup() {
  // put your setup code here, to run once:
  
  pinMode(trg1, OUTPUT);
  pinMode(trg2, OUTPUT);
  pinMode(trg3, OUTPUT);
  pinMode(trg4, OUTPUT);

  pinMode(ech1, INPUT);
  pinMode(ech2, INPUT);
  pinMode(ech3, INPUT);
  pinMode(ech4, INPUT);

  
  pinMode(buz, OUTPUT);
  
  pinMode(ldri, OUTPUT);
  pinMode(ldro, INPUT);
  pinMode(ltilti, OUTPUT);
  pinMode(ltilto, INPUT);
  pinMode(rtilti, OUTPUT);
  pinMode(rtilto, INPUT);
  pinMode(led,OUTPUT);

  pinMode(flameInPin, INPUT);

  pinMode(msensor, INPUT);
  
  Serial.begin(9600);
}

void loop() {

  //  digitalWrite(ldri,HIGH);

  msvalue = analogRead(msensor);

  if((msvalue<=980 ) && ( flag == false )){
    digitalWrite(led, HIGH); 
    flag = true; 
    voice.say(sp4_ALERT);
    voice.say(sp4_CAUTION);
    voice.say(sp4_CAUTION);
    voice.say(sp4_CAUTION);
  
  delay(1000);
  }

  if(digitalRead(flameInPin) == HIGH){
      voice.say(sp4_ALERT);
      voice.say(sp2_FIRE);
      voice.say(sp2_FIRE);
      voice.say(sp2_FIRE);
    }
    
  light = analogRead(ldro);
  
  if(light<20 ||light > 600){
    Serial.println("buz light");
    digitalWrite(buz,HIGH);
    delay(1000);
  }
  
  digitalWrite(ltilti, HIGH);
  ltilt = digitalRead(ltilto);
  digitalWrite(rtilti,HIGH);
  rtilt = digitalRead(rtilto);
  
  if(ltilt==1){
    digitalWrite(led,HIGH);
    delay(1000);
  }
  
  else if(rtilt==1){
    digitalWrite(led,HIGH);
    delay(1000);
  }
  
  else{
    digitalWrite(led,LOW);
    delay(1000);
  }


  dist1 = sonar1.ping_cm();
  dist2 = sonar2.ping_cm();
  dist3 = sonar3.ping_cm();
  dist4 = sonar4.ping_cm();


  if(dist1<20 && dist1!=0){
    NewTone(buz, 441);
    delay(1000);
    noNewTone(buz);
    voice.say(sp4_WARNING);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
}

else if(dist2<20 && dist2!=0){
   NewTone(buz, 441);
   delay(1000);
   noNewTone(buz);
   voice.say(sp4_WARNING);
   voice.say(sp4_DANGER);
   voice.say(sp4_DANGER);
   voice.say(sp4_DANGER);
}

else if(dist3<20 && dist3!=0){
    NewTone(buz, 441);
    delay(1000);
    noNewTone(buz);
    
    voice.say(sp4_WARNING);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
}
 if(dist4<20 && dist4!=0){ 
    NewTone(buz, 441);
    delay(1000);
    noNewTone(buz);
    
    voice.say(sp4_WARNING);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
    voice.say(sp4_DANGER);
} 

else{
  digitalWrite(buz,LOW);
}

}
