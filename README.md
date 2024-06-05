## 🎲 Yatzy 게임
이 프로젝트는 Java Swing을 사용하여 구현한 Yatzy 게임입니다.
기본적인 게임 룰은 다음을 참고해주세요.
https://namu.wiki/w/%EC%9A%94%ED%8A%B8(%EA%B2%8C%EC%9E%84)
https://namu.wiki/w/%EC%95%BC%EC%B0%8C   
이 프로젝트에서는 기존 yatzy게임과의 차별성을 위해 2개의 아이템을 구현하였습니다.

🎁 item1 : 최대 2개의 주사위를 스페셜 주사위로 변경합니다.
 (스페셜 주사위의 용도는 게임 예시 참고) 

🎁 item2 : 주사위를 1회 추가로 던질 수 있는 아이템입니다.

## 지원 Operating Systems 및 실행 방법
### 지원 Operating Systems
|OS| 지원 여부 |
|-----|--------|
|windows | :o:  |
| Linux  | ❓(확인 필요) |
|MacOS  | ❓(확인 필요)  |

윈도우 

### 실행 방법
#### Windows
1. Java 설치 (17 version 권장)
https://www.oracle.com/java/technologies/downloads/#java17  
2. 레포지토리 복사  
```sh
git clone https://github.com/Suyeong00/yatzy.git
```
3. 컴파일 후 게임 실행  
```sh
cd .\yatzy\yatzy\src\
javac -encoding UTF-8 dice\*.java score\*.java *.java
java -cp . YatzyGame
```

## 게임 예시
1. 주사위 굴리고 점수 등록하기

![roll_and_save](https://github.com/Suyeong00/yatzy/assets/158289642/e4c711b5-4b42-4f54-b37f-af8123403e5f)  

주사위는 클릭으로 고정/고정해제가 가능합니다.  
고정된 주사위는 roll 버튼을 눌러도 주사위 눈이 변하지 않습니다. 
주사위는 3번까지 roll 할 수 있습니다.  

2. 1번 아이템 사용

![item1](https://github.com/Suyeong00/yatzy/assets/158289642/47339de2-24f3-45c8-a0d4-5f576a999234)  
1번 아이템을 사용하면 최대 2개까지의 주사위를 스페셜 주사위로 설정할 수 있습니다.  
스페셜 주사위는 변하는 random dice에 맞춰 roll 버튼을 클릭하면 클릭 당시의 random dice의 주사위 눈으로 변합니다.  
random dice는 1번 아이템을 사용할 때를 제외하고는 게임에 영향을 주지 않습니다.

3. 2번 아이템 사용

![item2](https://github.com/Suyeong00/yatzy/assets/158289642/fd853d16-6b30-42d2-a35f-6b48610d5d88)  
원래 주사위는 3번까지 굴리는것이 가능하지만, 2번 아이템을 사용하면 3번째 주사위를 굴렸을 때 한번의 기회를 더 얻을 수 있습니다.  

## 코드 설명
### class Dice
### class Aces, Duces, Fours, Fives, Sixes
### class Choice, FourOfKind, FullHouse, SmallStaright, LargeStaright, Yacht
### class Button, Label, Panel, TextField
### class ScreenConfiguration
### class DiceMouseListener
### class Screen
### class YatzyGame


## Todo List
- 게임 재시작 버튼 구현
- 게임 종료시 이벤트 구현 (현재 게임이 종료되어도 사용자에게 종료되었다는 메세지나 이벤트가 발생하지 않음)
- 코드가 난잡하여 리팩토링 필요
  1.component 생성을 ScreenConfiguration 클래스에 위임하기
  2.actionPerformed 메서드가 복잡하므로 각 버튼별로 이벤트 분리하기

## Reference
https://en.wikipedia.org/wiki/Yahtzee
https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html
