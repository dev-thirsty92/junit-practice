- pom.xml 파일에 추가한 Junit5 의존성
    - 스프링부트 프로젝트를 생성하였기 때문에 별도의 의존성을 추가하지 않는다.
    - spring-boot-starter-test 하위에 책에서 요구하는 api와 engine을 포함하는 것을 확인 할 수 있다.
    ![img1.png](images/img1.png)


- @TestInstance(Lifecycle.PER_CLASS)
  - 테스트는 실행 순서에 관계없이 동일한 결과를 얻어야 하므로, @Test 메서드를 호출하기 전에 테스트 클래스 인스턴스를 매번 새로 만든다.
  - 따라서 테스트 메서드 간에 인스턴스 변수를 재사용할 수 없다.
  - **@TestInstance(Lifecycle.PER_CLASS)**
    - 테스트 클래스 인스턴스가 메서드 단위가 아닌 클래스 단위로 생성 된다.