# spring-jpa-1
- 아래 강의 실습 공부용
- https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0-JPA-%EC%8B%A4%EC%A0%84/dashboard


프로젝트 생성 시 스프링 부트 스타터를 이용한다.(https://start.spring.io/)

웹 어플리케이션 개발 시 사용할 라이브러리
- Spring Web Starter
- Thymeleaf(jsp 대신 사용)
- Spring Data JPA
- H2 Database(간단한 DB)
- lombok(지루하게 반복되는 코드를 줄여줌)
+) spring-boot-devtools
  -> devtools를 추가하면 서버를 다시 띄우지 않고도 변경된 화면이 적용된 화면을 볼 수 있다.
  -> 단 Build-Recompile'변경된 view 화면 파일' 클릭해야 ...[YTN]
  
프로젝트 생성 후 처음 프로젝트를 열때는 build.gradle을 선택한다.
- 스프링 가이드: https://spring.io/guides

- 일대다, 다대다의 양방향 관계에서는 연관관계의 주인을 정해야한다. 이때 외래 키가 존재하는 '다'쪽을 연관관계 주인으로 정한다.
- 모든 연관관계는 지연로딩(LAZY)으로 한다. *** 즉시로딩(EAGER)으로 하지 말랑이, 필요한 경우에는 fecth join 또는 엔티티 그래프 사용
  - @ManyToOne 조심하기. 얘는 기본 설정이 EAGER이다. 
 
