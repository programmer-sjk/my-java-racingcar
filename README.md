# 자동차 경주 게임

## 기능 요구사항
- 주어진 횟수 동안 n 대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여 할 수 있다. 전진하는 자동차를 출력 할 때 자동차
  이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5 자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것 인지를 입력 할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random 값 을 구한 후 random 값 이 4 이상
  일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값 을 입력할 경우 IllegalArgumentException를 발생시키고,
  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분 부터 입력을 다시받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등
  과 같은 명확한 유형을 처리한다.


## 프로그램 결과 입출력
### 입력
- 경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)
    - pobi,woni,jun
- 시도할회수
    - 5
### 출력
- 각 차수 별 실행결과
    - pobi:——
    - woni:---
    - jun:----
- 단독 우승자 안내문구
    - 최종 우승자 : pobi
- 공동 우승자 안내문구
    - 최종 우승자 : pobi, jun
- 예외 상황시 에러 문구를 출력 해야한다.단,에러문구는 [ERROR]로 시작 해야한다.
- [ERROR] 시도 횟수는 숫자여야 한다.

## 프로그램 실행 결과 예시
- 경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)
    - pobi,crong,honux
- 시도 할 회수는 몇 회 인가요?
    - 5
- 실행결과
    - pobi:-
    - crong:
    - honux:-
    -
    - pobi:--
    - crong:-
    - honux:--
    -
    - pobi:---
    - crong:--
    - honux:---
    -
    - pobi:----
    - crong:--
    - honux:----
    -
    - pobi:-----
    - crong:--
    - honux:-----


- 최종 우승자 : pobi, honux

## 프로그램 요구사항 1
- 자동차 경주게임을 실행하는 시작점은 src/main/java폴더의 racinggame.Application의 main()이다.
- 자동차 경주게임은 JDK8버전에서 실행 가능해야 한다. JDK8에서 정상동작하지 않을 경우 0점처리 한다.
- JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms및 ConsoleAPI를 사용하여 구현해야 한다.
- Random값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 프로그램 구현을 완료했을 때 src/test/java폴더의 racinggame.ApplicationTest에 있는 2개의 TestCase가 성공해야 한다. 테스트가 실패할 경우 0점처리 한다.
- ApplicationTest에서 제공하는 2개의 TestCase는 자동차 경주게임을 위한 최소한의 TestCase이다.
- 필수 요구사항은 아니지만 제공하는 소스코드를 참고해 자동차 경주게임을 위한 모든 TestCase를 추가해보는 것도 테스트에 대한 좋은 연습이 될 수있다

## 프로그램 요구사항 2
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
- indent(인 덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인 덴트, 들여쓰기)depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는 메소드)의 길이가 10 라인을 넘어가지않도록 구현한다.
    - 함수(또는 메소드)가 한가지 일만 잘하도록 구현한다
- 일급 콜렉션을 활용해 구현한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4

## 프로그램 요구사항 3
- 도메인 로직에 단위 테스트를 구현해야 한다. 단 ,UI(System.out,System.in,Scanner)로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 힌트는 MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한
      단위 테스트를 추가하는 것에 집중한다.
- JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를
  참고해 사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현한다

## 디렉토리 구조
- racingcar
  - constant: enum이 위치한 폴더, 패키지 이름을 enum으로 만들수가 없어서 constant 패키지를 만들고 관리
  - controller: main 함수에 의해 실행되는 controller
  - domain: 핵심 도메인이 위치한 폴더
  - view: 프로그램 실행과 관련된 입/출력 로직이 존재하는 곳

## 지키려 헀던 원칙
- 한 클래스가 너무 많은 역할을 해서는 안 된다.
- model에 출력하는 함수(print / println)가 있어서는 안 된다.

## 개발하면서 고민 되는 것
- CarDistance 클래스에서 carToDistance 멤버 변수만 있다고 가정했을 때(maxDistance 없다고 가정),
생성자에서 받은 자료형을 변환시켜서 대입해도 이를 일급 컬렉션이라 할 수 있을까? 받은 자료형 그대로 대입을 해야 일급 컬렉션인가?
- 원래 Race 클래스에서 우승자를 구했는데, 우승자를 추려내는 로직을 전담하는 객체가 있으면 좋겠다 싶어 CarDistance 클래스를 추가했는데
좋은 선택이였을까?
- 모든 원시값과 문자열을 포장하라는 요구사항에 의해 시도 횟수도 TryRound 라는 클래스를 만들었다. 요구사항에 맞게 코딩한건지..?
자동차의 이름(CarName)과 거리(Distance)를 포장하는 걸로 충분헀던 건지..?


## 기능 구현목록
- [x] 경주할 자동차의 이름을 입력받는다.
- [x] 쉼표를 기준으로 자동차를 만든다.
- [x] 자동차의 이름이 5자를 초과할 경우 예외를 발생한다.
- [x] 몇 번의 이동을 할 것인지 입력받는다.
- [x] 입력받은 이동회수 만큼 각 자동차에게 랜덤값을 전달한다.
- [x] 랜덤값이 4이상일 경우 전진하고 3이하의 값이면 멈춘다.
- [x] 시도 회수 마다 자동차의 이동결과를 출력한다.
- [x] 우승자를 구한 뒤 출력한다.
- [x] 우승자가 한 명 이상일 경우 쉼표로 이름을 구분해 출력한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외를
  발생시킨다.
- [x] [ERROR]로 시작하는 에러메시지를 출력 후 그 부분부터 다시 입력받는다.