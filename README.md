## 지원 Operating Systems 및 실행 방법

### 지원 Operating Systems

### 실행 방법

## 실행 예시
1. 주사위 굴리고 점수 등록하기

![roll_and_save](https://github.com/Suyeong00/yatzy/assets/158289642/e4c711b5-4b42-4f54-b37f-af8123403e5f)
2. 1번 아이템 사용

![item1](https://github.com/Suyeong00/yatzy/assets/158289642/47339de2-24f3-45c8-a0d4-5f576a999234)
3. 2번 아이템 사용

![item2](https://github.com/Suyeong00/yatzy/assets/158289642/fd853d16-6b30-42d2-a35f-6b48610d5d88)


## 코드 설명

## Todo List
- 게임 재시작 버튼 구현
- 게임 종료시 이벤트 구현 (현재 게임이 종료되어도 사용자에게 종료되었다는 메세지나 이벤트가 발생하지 않음)
- 코드가 난잡하여 리팩토링 필요 
1.component 생성을 ScreenConfiguration 클래스에 위임하기
2.actionPerformed 메서드가 복잡하므로 각 버튼별로 이벤트 분리하기